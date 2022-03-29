package Leyitner_lib;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class CardBox implements Serializable {
    public ConcurrentHashMap<String, String> box = new ConcurrentHashMap<>();

    public void printBox() {
        for (Map.Entry<String, String> entry : box.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
