package com.chllng;

import java.io.File;
import java.io.IOException;

public class CreatePushPerDay {
    private static File dayReport;

    public CreatePushPerDay(String date) {

        boolean created;

        dayReport = new File("C:\\Users\\PC\\IdeaProjects\\daily\\challenge\\lib", date);

        try {
            created = dayReport.createNewFile();
            //System.out.println(created);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getDayReport() {
        return dayReport;
    }
}
