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
import java.util.ArrayList;
import java.util.List;

public class CLI {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ManagePersonal managePersonal = new ManagePersonalImpl();

    public static void main(String[] args) throws IOException {
        // SalesMan test = new SalesMan("Darline", "Albus", 1);
        // managePersonal.createSalesMan(test);
        List<OrderEvaluation> oetest = List.of(
                new OrderEvaluation(
                        "HooverGo",
                        "Telekom",
                        "Exzellent",
                        10,
                        200
                ));

        List<SocialEvaluation> setest = List.of(
                new SocialEvaluation(
                        "leadership",
                        4,
                        4,
                        10
                ));

        EvaluationRecord test = new EvaluationRecord(1, 2022, oetest, setest);
        managePersonal.addPerformanceRecord(test, 1);
        while (true) {
            read();
        }
    }

    public static String read() throws IOException {
        String ausgabe = reader.readLine();
        return ausgabe;
    }
}
