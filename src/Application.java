import list.transmiter.ListConverter;
import list.transmiter.ListCreator;
import list.transmiter.MainGUI;

import javax.swing.*;
import java.io.FileNotFoundException;

public class Application {
    private static final MainGUI frame = new MainGUI();
    private static final ListConverter listConverter = new ListConverter();;

    public static void main(String[] args) throws FileNotFoundException {
        ListCreator listCreator = new ListCreator();
//        listConverter.verifyList(frame.listSender(),listCreator.listCreator());
        SwingUtilities.invokeLater(frame::open);
    }
}
