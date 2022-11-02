package de.hbrs.ia.controller;

import de.hbrs.ia.contract.ManagePersonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;

public class DeleteFunctions {

    public static void deleteSalesman(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id of the employee you want to delete");
        int id = reader.read();

        if (mp.readSalesMan(id) != null) {
            mp.deleteOneSalesman(mp.readSalesMan(id));
            System.out.println("Employee was successfully deleted");
        } else {
            System.out.println("There is no employee with the id: " + id);
        }

        // Hier stimmt noch etwas nicht, muss noch geupdated werden!
    }

    public static void deleteAllSalesMen(BufferedReader reader, ManagePersonal mp) throws IOException {
        mp.deleteAllSalesmen();
        System.out.println("All employees were successfully deleted.");
    }

    public static void deleteEvaluationrecord(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id of the employee you want to delete from");
        int id = reader.read();
        System.out.println("Please enter the year you want to delete from");
        int year = reader.read();

        //Hier fehlt noch was
    }

    public static void deleteAllEvaluationRecords(BufferedReader reader, ManagePersonal mp) {
        mp.deleteAllEvaluationRecords();
        System.out.println("All evaluation records were successfully deleted.");
    }
}
