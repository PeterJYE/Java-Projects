package Test;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class HTMLTEST {
    //要打开哪个html
    public static void openExplorer(String bw) {

        if (java.awt.Desktop.isDesktopSupported()) {

            try {

                Desktop.getDesktop().open(new File(bw));

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }
}
