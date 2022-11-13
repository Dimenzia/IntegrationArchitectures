package de.hbrs.ia.controller;

import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.contract.ManagePersonalImpl;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.OrderEvaluation;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialEvaluation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class AddFunctions {

    public static void addingSalesman(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the firstname of the Salesman");
        String firstName = reader.readLine();
        System.out.println("Please enter the Lastname of the Salesman");
        String lastName = reader.readLine();
        System.out.println("Please enter the id of the Salesman");
        int id = Integer.parseInt(reader.readLine());
        SalesMan sm = new SalesMan(firstName, lastName, id);
        mp.createSalesMan(sm);
        System.out.println("Salesman was successfully added");
    }

    public static EvaluationRecord addingEvaluationRecord(BufferedReader reader, ManagePersonal mp) throws IOException {
        System.out.println("Please enter the id of the employee");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the current year");
        int year = Integer.parseInt(reader.readLine());


        List<OrderEvaluation> oe = List.of();
        List<SocialEvaluation> se = List.of();

        EvaluationRecord evaluationRecord = new EvaluationRecord(id, year, oe, se);
        mp.addPerformanceRecord(evaluationRecord, id);

        return evaluationRecord;
    }
}
