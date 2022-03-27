package Leitner_main;

import Leyitner_lib.LeitnerLib;
import java.io.*;
import java.util.Scanner;

public class LeitnerMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please, choose the operation:\n" +
                "read from file(1), load data(2), exit(3)");
        int operation = in.nextInt();
        LeitnerLib learnProc = new LeitnerLib();
        switch(operation) {
            case 1:
                learnProc.init("in.txt");
                learnProc.start();
                break;
            case 2:
                learnProc = readStats("leitner.out");
                learnProc.printBoxes();
                learnProc.start();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid operation");
        }
        saveStatus(learnProc, "leitner.out");
        in.close();
    }

    public static void saveStatus(LeitnerLib obj, String fName) {
        try(ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(fName))) {
            objOut.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LeitnerLib readStats(String fName) {
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fName))) {
            LeitnerLib res = (LeitnerLib) objIn.readObject();
            return res;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
