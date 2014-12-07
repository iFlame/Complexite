import javax.swing.*;
import java.awt.*;
import java.util.List;

class Surface extends JPanel {

    private List<Figure> figure;
    private int x;
    private int y;
    private int multiply;

    public Surface(List<Figure> liste) {
        this.x = 15;
        this.y = 15;
        this.multiply = 25;
        this.figure = liste;
    }

    private void doDrawing(Graphics g) {
        BasicStroke bs;
        Graphics2D g2d = (Graphics2D) g;

        for(int i = 0; i < figure.size(); i++) {
            int haut = figure.get(i).getHauteur();
            int larg = figure.get(i).getLargeur();
            if(i == 0) {
                bs = new BasicStroke(5, BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
            } else {
                bs = new BasicStroke(2, BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
            }

            int pixelX = figure.get(i).getX() * multiply + x;
            int pixelY = figure.get(i).getY() * multiply + y;
            int hauteurPix = figure.get(i).getHauteur() * multiply;
            int largeurPix = figure.get(i).getLargeur() * multiply;

            g2d.setStroke(bs);
            g2d.drawRect(pixelX,pixelY,largeurPix,hauteurPix);
            System.out.println("test");
        }

/*
        BasicStroke bs1 = new BasicStroke(5, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs1);
        g2d.drawRect(15, 15, 75,75);
        BasicStroke bs2 = new BasicStroke(2, BasicStroke.CAP_ROUND,
                BasicStroke.JOIN_BEVEL);
        g2d.setStroke(bs2);
        g2d.drawRect(15,40,25,50);
        g2d.drawRect(15,15,50,25);
        g2d.drawRect(40,40,25,25);
        g2d.drawRect(40,65,50,25);

*/
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}

class Joins extends JFrame {

    private List<Figure> liste;

    public Joins(List<Figure> liste) {
        this.liste = liste;
        initUI();
    }

    private void initUI() {

        setTitle("Complexite");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new Surface(liste));
        setSize(200, 200);
        setLocationRelativeTo(null);
    }
}