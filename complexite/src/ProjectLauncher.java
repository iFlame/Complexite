import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 06/12/2014.
 */
public class ProjectLauncher {


    public static void main(String[] args) {


        FileReader fileReader = new FileReader();
        final List<Figure> liste = fileReader.getData();
        final List<Figure> liste2 = new ArrayList<Figure>();


        for (int i = 1; i < liste.size(); i++) {
            liste2.add(liste.get(i));
        }

        final Sorter sorter = new Sorter(1);
        sorter.createHighList(liste2);
        sorter.sort(liste.get(0), liste2, 0, 0);


        /**
         * Dessine la figure :
         */
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                Joins js = new Joins(liste2, liste.get(0), sorter.getContainers());
                js.setVisible(true);
            }
        });

    }

}
