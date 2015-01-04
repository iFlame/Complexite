import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin on 07/12/2014.
 */
public class FileReader {

    private ArrayList<Figure> figures;
    private boolean noData;

    public FileReader() {
        noData = false;
        figures = new ArrayList<Figure>();
    }

    public List<Figure> getData() {
        String file = "EntryFile.txt";

        try {
            InputStream ips = new FileInputStream(file);
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String line;
            while ((line = br.readLine()) != null) {
                //  System.out.println(line);
                dataAnalyse(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return figures;
    }

    private void dataAnalyse(String line) {
        if (noData) {
            createList(line);
            if (line.compareTo("//") == 0) {
                noData = false;
            }
        }
        if (line.compareTo("//") == 0) {
            noData = true;
        }
    }


    private void createList(String line) {
        String[] firstSplit = line.split(",");
        String[] secondSplit;
        for (int i = 0; i < firstSplit.length; i++) {
            secondSplit = firstSplit[i].split("x");
            Figure fig = new Figure(Integer.parseInt(secondSplit[1]), Integer.parseInt(secondSplit[0]), 0, 0);
            figures.add(fig);
        }
    }


    public ArrayList<Figure> getFigures() {
        return figures;
    }

    public void setFigures(ArrayList<Figure> figures) {
        this.figures = figures;
    }
}

