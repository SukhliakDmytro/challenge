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

    public static String[] getTodaysTotal(File tempDay){
        int i = 0;
        int repeats = 0;
        String[] totalDay = new String[2];

        try {
            FileReader f1 = new FileReader(tempDay);
            Scanner scanner = new Scanner(f1);
            while(scanner.hasNextInt()){
                i += scanner.nextInt();
                repeats ++;
                //System.out.println(i);
            }
            f1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        totalDay[0] = String.valueOf(i);
        totalDay[1] = String.valueOf(repeats);
        return totalDay;
    }





}
