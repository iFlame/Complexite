import javax.swing.*;
import java.awt.*;
import java.util.List;

class Surface extends JPanel {

    private List<Figure> figure;
    private Figure container;
    private int x;
    private int y;
    private int multiply;
    private int containNumber;

    public Surface(List<Figure> liste, Figure container, int containNumber) {
        this.x = 15;
        this.y = 15;
        this.multiply = 25;
        this.figure = liste;
        this.containNumber = containNumber;
        this.container = container;
    }

    private void doDrawing(Graphics g) {
        BasicStroke bs;
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < containNumber; i++) {
            bs = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);


            int pixelY = container.getY() * multiply + y;
            int hauteurPix = container.getHauteur() * multiply;
            int largeurPix = container.getLargeur() * multiply;
            int pixelX = container.getX() * multiply + x + i * (largeurPix + 25);

            g2d.setStroke(bs);
            g2d.setColor(Color.white);
            g2d.fillRect(pixelX, pixelY, largeurPix, hauteurPix);
            g2d.setColor(Color.darkGray);
            g2d.drawRect(pixelX, pixelY, largeurPix, hauteurPix);
        }

        for (int i = 0; i < figure.size(); i++) {
            int haut = figure.get(i).getHauteur();
            int larg = figure.get(i).getLargeur();
            bs = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);


            int pixelX = figure.get(i).getX() * multiply + x;
            int pixelY = figure.get(i).getY() * multiply + y;
            int hauteurPix = figure.get(i).getHauteur() * multiply;
            int largeurPix = figure.get(i).getLargeur() * multiply;

            g2d.setStroke(bs);
            g2d.drawRect(pixelX, pixelY, largeurPix, hauteurPix);
            g2d.setColor(Color.gray);
            g2d.fillRect(pixelX, pixelY, largeurPix, hauteurPix);
            g2d.setColor(Color.darkGray);

        }


    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);

    }
}

class Joins extends JFrame {

    private List<Figure> liste;
    private Figure container;
    private int containNumber;

    public Joins(List<Figure> liste, Figure container, int containNumber) {
        this.liste = liste;
        this.container = container;
        this.containNumber = containNumber;
        initUI();
    }

    private void initUI() {

        setTitle("Complexite");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new Surface(liste, container, containNumber));
        setSize(300, 200);
        setLocationRelativeTo(null);
    }
}