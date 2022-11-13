package de.hbrs.ia.controller;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.OrderEvaluation;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialEvaluation;

public class PrintFunctions {

    public static void printSalesMan(SalesMan sm) {
        System.out.println("Employee");
        System.out.println("↳ Name: " + sm.getFirstname() + " " + sm.getLastname());
        System.out.println("↳ ID: " + sm.getSid().toString());
    }

    public static void printEvaluationRecord(EvaluationRecord record) {
        System.out.println("Evaluation record");
        System.out.println("Name: " + CLI.managePersonal.readSalesMan(record.getEmployeeID()));
        System.out.println("Employee ID: " + record.getEmployeeID());
        System.out.println("Year of performance: " + record.getYear());
        printOrderEvaluations(record);
        printSocialEvaluations(record);
    }

    public static void printSocialEvaluations(EvaluationRecord record) {
        System.out.println("List of Social Evaluations");

        System.out.println("ID" +
                " | " + "Targetname" +
                " | " + "Target Value" +
                " | " + "Actual Value" +
                " | " + "Bonus");
        for(SocialEvaluation se : record.getSe()) {
            printSocialEvaluation(se);
        }
    }

    public static void printOrderEvaluation(OrderEvaluation oe) {
        System.out.println(oe.getId() +
                " | " + oe.getProductName() +
                " | " + oe.getClient() +
                " | " + oe.getClientRanking() +
                " | " + oe.getItems() +
                " | " + oe.getBonus());
    }

    public static void printOrderEvaluations(EvaluationRecord record) {
        System.out.println("List of Order Evaluations");

        System.out.println("ID" +
                " | " + "Name of Product" +
                " | " + "Client" +
                " | " + "Client Ranking" +
                " | " + "Items" +
                " | " + "Bonus");
        for(OrderEvaluation oe : record.getOe()) {
            printOrderEvaluation(oe);
        }
    }

    public static void printSocialEvaluation(SocialEvaluation se) {
        System.out.println(se.getId() +
                " | " + se.getTargetName() +
                " | " + se.getTargetValue() +
                " | " + se.getActualValue() +
                " | " + se.getBonus());
    }
}
