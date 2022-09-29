package com.chllng;

import java.io.File;
import java.util.Scanner;

public class WorkWithUser {

    public static int inputDef(){
        Scanner scanner = new Scanner(System.in);

        while(!scanner.hasNextInt()){
            System.out.println("It's not an integer");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void menu(WorkWithFile day){

        int choice;

        while(true) {
            System.out.print("Enter an option: \n1. Add amount to today\n2. Get an amount of today's push-ups");
            System.out.println("\n3. Get an amount of all push-ups by this time\n0. Exit");
            System.out.print(">  ");
            choice = inputDef();

            switch (choice) {
                case 1:{
                    System.out.print("\nEnter amount of push-ups:  ");
                    day.addPushUps(inputDef());
                    break;
                }

                case 2:{
                    System.out.println("You made " + day.getTodaysTotal(day.getDayReport())[0] + " push-ups in " + WorkWithFile.getTodaysTotal(day.getDayReport())[1] + " repeats. Keep Going!\n");
                    break;
                }

                case 3:{
                    getAllStats();
                    break;
                }

                case 0:{
                    System.exit(0);
                }
            }
        }
    }

    public static void getAllStats() {
        File directory = new File("C:\\Users\\PC\\IdeaProjects\\daily\\challenge\\lib");

        if(directory.isDirectory()) {
            File[] allDays = directory.listFiles();
            int sum = 0;
            int repeats = 0;
            if(allDays != null) {

                for(int i = 0; i < allDays.length; i++) {
                    System.out.println(allDays[i].getName() + ":  " + WorkWithFile.getTodaysTotal(allDays[i])[0]);
                    sum += Integer.parseInt(WorkWithFile.getTodaysTotal(allDays[i])[0]);
                    repeats += Integer.parseInt(WorkWithFile.getTodaysTotal(allDays[i])[1]);
                }
                System.out.println("\nYou made " + sum + " push-ups in " + allDays.length + " days. Keep going!\n");
                System.out.println("Average amount of push-ups per day: " + sum / allDays.length + "");
                System.out.println("Average amount of push-ups per repeat: " + sum / repeats + "");
                System.out.println("You need to do " + (10000 - sum) + " more push-ups in " + (30 - allDays.length) + " days to complete the challenge");
                System.out.println("It's " + (10000 - sum) / (30 - allDays.length) + " push-ups per day\n");
            }

        } else {
            System.out.println("The directory is empty or it's path is wrong\n");
        }
    }
}
