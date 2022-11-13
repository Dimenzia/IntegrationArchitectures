package de.hbrs.ia.controller;

import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.model.EvaluationRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;

public class DeleteFunctions {

    public static void deleteSalesman(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id of the employee you want to delete");
        int id = Integer.parseInt(reader.readLine());

        if (mp.readSalesMan(id) != null) {
            mp.deleteOneSalesman(mp.readSalesMan(id));
            System.out.println("Employee was successfully deleted");
        } else {
            System.out.println("There is no employee with the id: " + id);
        }
    }

    public static void deleteAllSalesMen(BufferedReader reader, ManagePersonal mp) throws IOException {
        mp.deleteAllSalesmen();
        System.out.println("All employees were successfully deleted.");
    }

    public static void deleteEvaluationrecord(BufferedReader reader, ManagePersonal mp) throws IOException {
        EvaluationRecord record = ReadFunctions.readSingleEvaluationRecord(reader, mp);

        mp.deleteOneEvaluationRecord(record);
    }

    public static void deleteAllEvaluationRecords(BufferedReader reader, ManagePersonal mp) {
        mp.deleteAllEvaluationRecords();
        System.out.println("All evaluation records were successfully deleted.");
    }

    public static void deleteOrderEvaluation(EvaluationRecord record, int id) {
        record.getOe().removeIf(orderEvaluation -> orderEvaluation.getId() == id);

    }

    public static void deleteSocialEvaluation(EvaluationRecord record, int id) {
        record.getSe().removeIf(socialEvaluation -> socialEvaluation.getId() == id);
    }
}
