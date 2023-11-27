package list.transmiter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListCreator {
    private final File file = new File("/home/guidini/Desktop/bombas/palavras");
    private final Scanner sc = new Scanner(file);
    private final List<String> wordList= new ArrayList<>();
    private final List<String> correctList = new ArrayList<>();

    public ListCreator() throws FileNotFoundException {
    }

    public List<String> listCreator() {
        while(sc.hasNext()){
            wordList.add(sc.nextLine());
            for (String e: wordList) {
                if(e.length()>=4){
                    correctList.add(e);
                }
            }

            if(correctList.size()>10){
                break;
            }
        }

        System.out.println(correctList + "\n"+ correctList.size());
        return correctList;
    }

}
