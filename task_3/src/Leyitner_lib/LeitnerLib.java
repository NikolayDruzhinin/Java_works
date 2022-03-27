package Leyitner_lib;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class LeitnerLib implements Serializable {

    static final int BOX_NUM = 10;
    CardBox[] boxes = new CardBox[BOX_NUM];
    int status = 0;

    public LeitnerLib() {
        for (int i = 0; i < BOX_NUM; ++i)
            boxes[i] = new CardBox();
    }

    public LeitnerLib(LeitnerLib l) {
        for (CardBox box : boxes)
            for (CardBox inBox : l.boxes)
                box = inBox;
        this.status = l.status;
    }

    public void init(String fileName) {

        try (Scanner in = new Scanner(new FileReader(fileName, StandardCharsets.UTF_8))) {
            in.useDelimiter(":|;");
            while (in.hasNext()) {
                boxes[0].box.put(in.next().trim(),in.next().trim());
            }
            for (int i = 0; i < BOX_NUM; ++i)
            {
                System.out.println("Box " + (i+1));
                boxes[i].printBox();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printBoxes() {
        for (int i = 0; i < BOX_NUM; ++i) {
            System.out.println("Box #" + (i+1));
            boxes[i].printBox();
        }
    }

    public void start() {
        System.out.println("The Leitner program has started..." + "\n" +
                "Please, enter translation for following words:");
        Scanner in = new Scanner(System.in);
        for (int i = status; i < BOX_NUM; ++i){
            for (Map.Entry<String, String> entry : boxes[i].box.entrySet()) {
                System.out.print(entry.getKey() + " - ");
                String answer = in.nextLine();
                if (answer.isEmpty()) {
                    in.close();
                    System.out.println("Goodbye!");
                    status = i;
                    System.out.println("Saved cardbox: " + status);
                    return;
                }
                else if (entry.getValue().equals(answer)) {
                    System.out.println("You're right!");
                    if (i < 10) {
                        boxes[i].box.remove(entry.getKey());
                        boxes[i+1].box.put(entry.getKey(), entry.getValue());
                    }
                }
                else {
                    System.out.println("You're wrong!");
                    if (i > 0) {
                        boxes[i].box.remove(entry.getKey());
                        boxes[0].box.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }
}
