package list.transmiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainGUI extends JFrame {
    private JFrame frame;
    private JTextField tfWord;
    private JButton btEnter, btExit;
    private JLabel lbWords;
    private Container container;
    private List<String> words = new ArrayList<>();

    public MainGUI() {
        componentInitializer();
        definingEvents();
    }

    public void componentInitializer(){
        setTitle("POO game");
        container = getContentPane();
        setBounds(100,100,250,200);
        setLayout(null);

        tfWord = new JTextField(5);
        tfWord.setBounds(100,10,120,30);
        btEnter = new JButton("Enter");
        btEnter.setBounds(225,10,80,30);
        lbWords = new JLabel("Palavras corretas: ");
        lbWords.setBounds(100,35,150,30);

        add(tfWord);
        add(btEnter);
        add(lbWords);
    }

    public void definingEvents(){
        tfWord.addActionListener(e -> words.add(tfWord.getText()));
        ActionListener actionListener = e -> {
            words.add(tfWord.getText());
            System.out.println("teste: " + words);
        };

        btEnter.addActionListener(actionListener);
        Action enterAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.actionPerformed(e);
            }
        };
        tfWord.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "enterAction");
        tfWord.getActionMap().put("enterAction", enterAction);


    }

    public void open() {
        frame = new MainGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(50,50,500,300);
        frame.setLocation((screen.width - frame.getSize().width)/2,
                          (screen.height - frame.getSize().height)/2);
        frame.setVisible(true);
    }
}
