package Leitner_main;

import Leyitner_lib.LeitnerLib;
import Leyitner_lib.MyException;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LeitnerMain {
        public static void main(String[] args) {

        try (Scanner in = new Scanner(System.in)){
            System.out.println("Please, choose the operation:\n" +
                    "read from file(1), load data(2), exit(3)");
            int operation = in.nextInt();

            LeitnerLib learnProc = new LeitnerLib();
            System.out.println("For reading data from file use '.txt' " +
                    "file extension, for loading data - '.out'");
            System.out.println("Please, enter filename");
            String inFile = in.next();
            switch (operation) {
                case 1:
                    if (!inFile.endsWith(".txt"))
                        throw new MyException(MyException.errorCodes.INVALID_FILE_NAME);
                    learnProc.init(inFile);
                    learnProc.start();
                    break;
                case 2:
                    if (!inFile.endsWith(".out"))
                        throw new MyException(MyException.errorCodes.INVALID_FILE_NAME);
                    learnProc = readStats(inFile);
                    learnProc.printBoxes();
                    learnProc.start();
                    break;
                case 3:
                    break;
                default:
                    throw new MyException(MyException.errorCodes.INVALID_OPERATION_INPUT);
            }

            System.out.println("To save data enter filename with '.out' extension or enter 'exit'");
            String outFile = in.next();
            if (!outFile.equals("exit")) {
                if (!outFile.endsWith(".out"))
                    throw new MyException(MyException.errorCodes.INVALID_FILE_NAME);
                saveStatus(learnProc, outFile);
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (MyException e) {
            System.out.println(e);
        }
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
            return (LeitnerLib) objIn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
