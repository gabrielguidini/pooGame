package list.transmiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MainGUI extends JFrame {
    private Timer timer;
    private int remainingTime;
    private JTextField tfWord, tfTimer;
    private JTextArea taList,taWrongWords;
    private JButton btEnter, btStart;
    private JLabel lbTimer;
    private final List<String> inputtedWords = new ArrayList<>();
    private final ListCreator creator = new ListCreator();

    public MainGUI() throws FileNotFoundException {
        creator.creatingList();
        componentInitializer();
        definingEvents();
    }

    public void componentInitializer(){
        setTitle("POO game");
        setBounds(100,100,250,200);
        setLayout(null);

        //setting input textfield
        JLabel lbWord = new JLabel("Envie sua palavra aqui:");
        lbWord.setBounds(100,5,175,30);
        tfWord = new JTextField(5);
        tfWord.setBounds(100,30,120,27);
        tfWord.setEditable(false);
        btEnter = new JButton("Enviar");
        btEnter.setBounds(225,30,80,27);

        //setting up timmer and start button
        lbTimer = new JLabel("Tempo Restante:");
        lbTimer.setBounds(315,5,200,27);
        tfTimer = new JTextField();
        tfTimer.setBounds(315,30,55,28);
        btStart = new JButton("Começar");
        btStart.setBounds(375,30,95,27);


        //setting textarea and the labeling it
        JLabel lbWords = new JLabel("Palavras corretas:");
        lbWords.setBounds(100,55,140,27);
        taList = new JTextArea();
        taList.setBounds(100,75,130,150);
        taList.setEditable(false);
        JLabel lbWrongWords = new JLabel("Palavras erradas:");
        lbWrongWords.setBounds(250,55,140,27);
        taWrongWords = new JTextArea();
        taWrongWords.setBounds(250,75,130,150);

        //adding into jframe
        add(lbWrongWords);
        add(taWrongWords);
        add(btStart);
        add(tfTimer);
        add(lbTimer);
        add(taList);
        add(tfWord);
        add(btEnter);
        add(lbWords);
        add(lbWord);
    }

    public void definingEvents(){
        tfWord.addActionListener(e -> inputtedWords.add(tfWord.getText()));
        ActionListener actionListener = e -> {
            inputtedWords.add(tfWord.getText());
            tfWord.setText("");
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

        btStart.addActionListener(e -> {

            remainingTime = parseInt(tfTimer.getText());

            tfTimer.setEditable(false);

            tfWord.setEditable(true);

            timer = new Timer(1000, e1 -> updateTimer());

            timer.start();
        });
    }

    private void updateTimer() {
        remainingTime--;

        if (remainingTime >= 0) {
            tfTimer.setText(getFormattedTime(remainingTime));
        } else {

            timer.stop();

            StringBuilder displayText = new StringBuilder();

            for(String str : creator.verifyCorrectWords(inputtedWords)) {

                taList.setText(String.valueOf(displayText.append(str).append("\n")));

            }

            StringBuilder displayTextWrong = new StringBuilder();

            for (String str: creator.verifyWrongWords(inputtedWords)) {

                taWrongWords.setText(String.valueOf(displayTextWrong.append(str).append("\n")));

            }

            lbTimer.setText("TEMPO ACABOU!!!!!!!");
        }
    }

    private String getFormattedTime(int seconds) {
        int minutes = seconds / 60;

        int secs = seconds % 60;

        //formating the numbers

        return String.format("%02d:%02d", minutes, secs);
    }


    public void open() throws FileNotFoundException {

        JFrame frame = new MainGUI();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setBounds(50,50,500,300);

        frame.setLocation((screen.width - frame.getSize().width)/2,

                          (screen.height - frame.getSize().height)/2);

        frame.setVisible(true);

    }

}
