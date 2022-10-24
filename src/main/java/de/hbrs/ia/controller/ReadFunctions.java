package de.hbrs.ia.controller;

import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.model.SalesMan;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFunctions {

    public static void readSalesMan(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id from the Salesman you want to see");
        int sid = Integer.parseInt(reader.readLine());

        SalesMan sm = mp.readSalesMan(sid);
        if (sm != null) {
            PrintFunctions.printSalesMan(sm);
        } else {
            System.out.println("Employee with ID " + sid + " does not exist");
        }
    }

    public static void readEvaluationRecords(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id of the employee you want to see");
        int id = Integer.parseInt(reader.readLine());

        mp.readEvaluationRecords(id);
    }
}
