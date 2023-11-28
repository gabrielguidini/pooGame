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

    public ListCreator() throws FileNotFoundException {}

    public void creatingList() {
        while(sc.hasNext()){
            wordList.add(sc.nextLine());
        }
        for (String e: wordList) {
            if(e.length()>=4){
                correctList.add(e);
            }
        }
    }

    public List<String> verifyCorrectWords(List<String> listToVerify){
        List<String> verifiedList = new ArrayList<>();

        char firstLetter = listToVerify.get(0).charAt(0);

        for (String str : listToVerify) {

            if(firstLetter == str.charAt(0)) {

                if(correctList.contains(str)) {

                    if(!verifiedList.contains(str)){

                        verifiedList.add(str);

                    }

                }

            }

        }

        return verifiedList;
    }

    public List<String> verifyWrongWords(List<String> listToVerify) {

        List<String> verifiedList = new ArrayList<>();

        for (String str : listToVerify){

            if(!wordList.contains(str)){

                verifiedList.add(str);

            }

        }

        return verifiedList;
    }

}
