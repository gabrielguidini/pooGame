package list.transmiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainGUI extends JFrame {
    private Timer timer;
    private static final int INITIAL_TIME = 0;
    private int remainingTime = INITIAL_TIME;
    private JFrame frame;
    private JTextField tfWord,tfList, tfTimer;
    private JButton btEnter, btStart;
    private JLabel lbWords, lbTimer;
    private List<String> words = new ArrayList<>();

    public MainGUI()  {
        componentInitializer();
        definingEvents();
    }

    public void componentInitializer(){
        setTitle("POO game");
        setBounds(100,100,250,200);
        setLayout(null);

        //setting input textfield
        tfWord = new JTextField(5);
        tfWord.setBounds(100,10,120,27);
        btEnter = new JButton("Enviar");
        btEnter.setBounds(225,10,80,27);

        //setting up timmer and start button
        lbTimer = new JLabel("Tempo Restante:");
        lbTimer.setBounds(300,35,150,27);
        tfTimer = new JTextField();
        tfTimer.setBounds(335,55,40,30);
        btStart = new JButton("Começar");
        btStart.setBounds(300,90,100,27);


        //setting textfield and the labeling it
        lbWords = new JLabel("Palavras corretas: ");
        lbWords.setBounds(100,35,150,27);
        tfList = new JTextField(1);
        tfList.setBounds(100,55,150,200);
        tfList.setText("bomba");
        tfList.setEditable(false);

        //adding into jframe
        add(btStart);
        add(tfTimer);
        add(lbTimer);
        add(tfList);
        add(tfWord);
        add(btEnter);
        add(lbWords);
    }

    public void definingEvents(){
        tfWord.addActionListener(e -> words.add(tfWord.getText()));
        ActionListener actionListener = e -> {
            words.add(tfWord.getText());
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


        btStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfTimer.setEditable(false);
                timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateTimer();
                    }
                });
            }
        });
    }

    private void updateTimer() {
        remainingTime--;

        if (remainingTime >= 0) {
            tfTimer.setText(getFormattedTime(remainingTime));
        } else {
            timer.stop();
            lbTimer.setText("Tempo acabou");
        }
    }

    private String getFormattedTime(int seconds) {
        int minutes = seconds / 60;
        int secs = seconds % 60;
        //formating the numbers
        return String.format("%02d:%02d", minutes, secs);
    }

    public List<String> listSender() {
        return words;
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
