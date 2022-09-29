package com.chllng;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LocalDate d1 = LocalDate.now();
        String temp = d1 + ".txt";

        WorkWithFile day = new WorkWithFile(temp);

        WorkWithUser.menu(day);


    }

    
}
