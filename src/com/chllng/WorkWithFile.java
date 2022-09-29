package com.chllng;

import java.io.*;
import java.util.Scanner;

public class WorkWithFile extends CreatePushPerDay {
    private File day;
    private int total;

    public WorkWithFile(String date) {
        super(date);
        day = getDayReport();
    }


    public void setDay(File day) {
        this.day = day;
    }

    public void addPushUps(int amount) {
        FileWriter f1;
        try {

            f1 = new FileWriter(day, true);
            f1.write(amount + "\n");
            f1.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getTodaysTotal(File tempDay){
        int i = 0;

        try {
            FileReader f1 = new FileReader(tempDay);
            Scanner scanner = new Scanner(f1);
            while(scanner.hasNextInt()){
                i += scanner.nextInt();
                //System.out.println(i);
            }
            f1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }



}
