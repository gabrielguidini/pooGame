import list.transmiter.GameCreator;
import list.transmiter.GameGUI;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quanto tempo, em minutos, você quer para digitar as palavras?");
        Long minutes = sc.nextLong();
        GameCreator gameCreator = new GameCreator(minutes);
        List<String> allWords = gameCreator.createLists();

        System.out.println("Comece a digitar as palavras: ");
        List<String> wordsWritten = new ArrayList<>();
        do{
            String word = sc.nextLine();
            wordsWritten.add(word);
            System.out.println(wordsWritten);
        }while(gameCreator.countDownTimer() != 0);
    }
}
