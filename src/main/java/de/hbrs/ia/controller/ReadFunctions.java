package de.hbrs.ia.controller;

import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ReadFunctions {

    public static SalesMan readSalesMan(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id from the Salesman you want to see");
        int sid = Integer.parseInt(reader.readLine());

        SalesMan sm = mp.readSalesMan(sid);

        return sm;
    }

    public static List<EvaluationRecord> readEvaluationRecords(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id of the employee you want to see");
        int id = Integer.parseInt(reader.readLine());

        return mp.readEvaluationRecords(id);
    }

    public static EvaluationRecord readSingleEvaluationRecord(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the employee id");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the year of the evaluation record");
        int year = Integer.parseInt(reader.readLine());

        return mp.readSingleEvaluationRecord(id, year);
    }
}
