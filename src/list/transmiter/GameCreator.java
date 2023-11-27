package list.transmiter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GameCreator {
    private static Timer timer = new Timer();
    private Long time;
    private List<String> verifiedWords;

    public GameCreator(Long time) {
        this.time = time*60;
    }
    public List<String> createLists() throws FileNotFoundException {
        File file = new File("/home/guidini/Desktop/bombas/palavras");
        Scanner sc = new Scanner(file);
        List<String> list = new ArrayList<>();
        while(sc.hasNext()){
            list.add(sc.nextLine());
            if(list.size() > 20) {
                break;
            }
        }
        sc.close();
        return list;
    }
    public long countDownTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(time>0){
                    time--;
                }else{
                    System.out.println("Acabou o tempo!!");
                    timer.cancel();
                }
            }
        },1000,1000);
        return time;
    }

    public List<String> verifyWords(List<String> allWords, List<String> wordsWritten){
        for (String e: allWords) {
            if(e.charAt(0) == wordsWritten.get(0).charAt(0)){
                verifiedWords.add(e);
            }
        }

        return verifiedWords;
    }

}
