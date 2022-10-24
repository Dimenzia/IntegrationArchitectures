package de.hbrs.ia.controller;

import de.hbrs.ia.contract.ManagePersonal;

import java.io.BufferedReader;
import java.io.IOException;

public class DeleteFunctions {

    public static void deleteSalesman(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id of the employee you want to delete");
        int id = reader.read();

        //Hier fehlt noch was
    }

    public static void deleteEvaluationrecord(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id of the employee you want to delete from");
        int id = reader.read();
        System.out.println("Please enter the year you want to delete from");
        int year = reader.read();

        //Hier fehlt noch was
    }
}
