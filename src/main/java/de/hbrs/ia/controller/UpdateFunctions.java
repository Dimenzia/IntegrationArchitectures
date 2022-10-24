package de.hbrs.ia.controller;

import de.hbrs.ia.contract.ManagePersonal;

import java.io.BufferedReader;
import java.io.IOException;

public class UpdateFunctions {

    public static void updateSalesman(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id of the employee you want to update");
        int id = reader.read();

        //Hier fehlt noch was
    }

    public static void updateEvaluationrecord(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id of the employee you want to update their evaluation record");
            int id = reader.read();

            //Hier fehlt noch was

        /*
        System.out.println("Please enter the productname");
        String productName = reader.readLine();
        System.out.println("Please enter the client Name");
        String client = reader.readLine();
        System.out.println("Please enter the ranking of the client");
        String clientRanking = reader.readLine();
        System.out.println("Please enter the items");
        int items = reader.read();
        System.out.println("Please enter the order evaluation bonus");
        int oeBonus = reader.read();
        System.out.println("Please enter the name of the target");
        String targetName = reader.readLine();
        System.out.println("Please enter the value of the target");
        int targetValue = reader.read();
        System.out.println("Please enter the actual value of the target");
        int actualValue = reader.read();
        System.out.println("Please enter the social evaluation bonus");
        int seBonus = reader.read();
         */
    }
}
