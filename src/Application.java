import list.transmiter.ListCreator;
import list.transmiter.MainGUI;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        ListCreator list = new ListCreator();
        List<String>  wordList = list.listCreator().stream().toList();
        SwingUtilities.invokeLater(() -> {
            MainGUI frame = new MainGUI();
            frame.open();
        });
    }
}
