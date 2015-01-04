import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 20/12/2014.
 */
public class Sorter {

    public Sorter(int containers) {
        this.containers = containers;
    }

    private ArrayList<Figure> decreaseHighList;
    private int containers;

    /**
     * Cette méthode créer une nouvelle liste qui a trié les figure par taille décroissante.
     *
     * @param initList
     */
    public void createHighList(List<Figure> initList) {
        decreaseHighList = new ArrayList<Figure>();
        decreaseHighList.add(new Figure(0, 0, 0, 0));
        for (int i = 0; i < initList.size(); i++) {
            int k = 0;

            if (initList.get(i).getHauteur() >= decreaseHighList.get(k).getHauteur()) {
                decreaseHighList.add(k, initList.get(i));
            } else {
                while (initList.get(i).getHauteur() < decreaseHighList.get(k).getHauteur()) {
                    k++;
                }
                decreaseHighList.add(k, initList.get(i));
            }
        }
        decreaseHighList.remove(decreaseHighList.size() - 1);
    }

    /**
     * Methode qui trie récursivement la liste d'élément tant qu'elle n'est pas vide, c'est à dire que toutes les figures
     * ont été placé correctement.
     *
     * @param container
     * @param figureList
     * @param level
     * @param shift
     */
    public void sort(Figure container, List<Figure> figureList, int level, int shift) {
        if (!figureList.isEmpty()) {
            if (level >= container.getHauteur()) {
                level = 0;
                shift = shift + 4;
                containers++;
            }
            Figure fc = new Figure(figureList.get(0).getHauteur(), container.getLargeur(), 0, 0);
            int i = 0;
            List<Figure> figures = new ArrayList<Figure>();
            for (Figure fig : figureList) {
                if (fig.getLargeur() <= fc.getLargeur()) {
                    fig.setX(fc.getX() + shift);
                    fc.setX(fc.getX() + fig.getLargeur());
                    fc.setLargeur(fc.getLargeur() - fig.getLargeur());
                    fig.setY(level);
                } else {
                    figures.add(fig);
                }
                i++;
            }

            sort(container, figures, fc.getHauteur() + level, shift);

        }
    }

    public ArrayList<Figure> getDecreaseHighList() {
        return decreaseHighList;
    }

    public void setDecreaseHighList(ArrayList<Figure> decreaseHighList) {
        this.decreaseHighList = decreaseHighList;
    }

    public int getContainers() {
        return containers;
    }

    public void setContainers(int containers) {
        this.containers = containers;
    }
}
