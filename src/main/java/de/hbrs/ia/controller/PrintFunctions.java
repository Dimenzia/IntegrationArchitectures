package de.hbrs.ia.controller;

import de.hbrs.ia.model.SalesMan;

public class PrintFunctions {

    public static void printSalesMan(SalesMan sm) {
        System.out.println("Employee");
        System.out.println(" Name: " + sm.getFirstname() + " " + sm.getLastname());
        System.out.println(" ID: " + sm.getSid().toString());
    }
}
