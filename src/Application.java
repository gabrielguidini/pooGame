import list.transmiter.MainGUI;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Application {
    private static final MainGUI frame;

    static {
        try {
            frame = new MainGUI();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                frame.open();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
