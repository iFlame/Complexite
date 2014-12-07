import javax.swing.*;
import java.util.List;

/**
 * Created by Quentin on 06/12/2014.
 */
public class ProjectLauncher {


    public static void main(String[] args) {


        FileReader fileReader = new FileReader();
        final List<Figure> liste = fileReader.getData();


        /**
         * Dessine la figure :
         */
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                Joins js = new Joins(liste);
                js.setVisible(true);
            }
        });


    }
}
