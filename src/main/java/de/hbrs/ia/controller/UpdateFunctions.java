package de.hbrs.ia.controller;

import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.OrderEvaluation;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialEvaluation;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UpdateFunctions {

    public static void updateSalesmanLastName(BufferedReader reader, ManagePersonal mp, int id) throws IOException {
        SalesMan sm = mp.readSalesMan(id);
        System.out.println("What is the new last name of the employee?");
        String newLastName = reader.readLine();
        mp.updateSalesmanLastName(sm, newLastName);
        System.out.println("Employee successfully updated");
        PrintFunctions.printSalesMan(sm);
    }

    public static void updateSalesmanID(BufferedReader reader, ManagePersonal mp, int id) throws IOException {
        SalesMan sm = mp.readSalesMan(id);
        System.out.println("What is the new id of the employee?");
        int newID = Integer.parseInt(reader.readLine());;
        mp.updateSalesmanId(sm, newID);
        System.out.println("Employee successfully updated");
        PrintFunctions.printSalesMan(sm);
    }

    public static void updateEvaluationrecord(BufferedReader reader, ManagePersonal mp, EvaluationRecord record) throws IOException {

        while(true) {
            System.out.println("What do u want to do? \n" +
                    "Available actions are: \n" +
                    "-> add order evaluation, \n" +
                    "-> add social performance evaluation, \n" +
                    "-> delete order evaluation, \n" +
                    "-> delete social performance evaluation, \n" +
                    "-> exit");

            String response = reader.readLine();

            if (Objects.equals(response, "add order evaluation")) {
                OrderEvaluation oe = new OrderEvaluation();

                System.out.println("Please enter the productname");
                String productName = reader.readLine();
                oe.setProductName(productName);

                System.out.println("Please enter the client Name");
                String client = reader.readLine();
                oe.setClient(client);

                System.out.println("Please enter the ranking of the client");
                String clientRanking = reader.readLine();
                oe.setClientRanking(clientRanking);

                System.out.println("Please enter the items");
                int items = Integer.parseInt(reader.readLine());
                oe.setItems(items);

                System.out.println("Please enter the order evaluation bonus");
                int oeBonus = Integer.parseInt(reader.readLine());
                oe.setBonus(oeBonus);

                oe.setId(record.generateID());
                List<OrderEvaluation> list = new ArrayList<OrderEvaluation>(record.getOe());
                list.add(oe);
                record.setOe(list);

            } else if (Objects.equals(response, "add social performance evaluation")) {
                SocialEvaluation se = new SocialEvaluation();

                System.out.println("Please enter the name of the target");
                String targetName = reader.readLine();
                se.setTargetName(targetName);

                System.out.println("Please enter the value of the target");
                int targetValue = Integer.parseInt(reader.readLine());
                se.setTargetValue(targetValue);

                System.out.println("Please enter the actual value of the target");
                int actualValue = Integer.parseInt(reader.readLine());
                se.setActualValue(actualValue);

                System.out.println("Please enter the social evaluation bonus");
                int seBonus = Integer.parseInt(reader.readLine());
                se.setBonus(seBonus);

                se.setId(record.generateID());
                List<SocialEvaluation> list = new ArrayList<SocialEvaluation>(record.getSe());
                list.add(se);
                record.setSe(list);

            } else if (Objects.equals(response, "delete order evaluation")) {
                PrintFunctions.printOrderEvaluations(record);

                System.out.println("Please enter the id of the record you want to delete");
                int id = Integer.parseInt(reader.readLine());
                DeleteFunctions.deleteOrderEvaluation(record, id);

            } else if (Objects.equals(response, "delete social performance evaluation")) {
                PrintFunctions.printSocialEvaluations(record);

                System.out.println("Please enter the id of the record you want to delete");
                int id = Integer.parseInt(reader.readLine());
                DeleteFunctions.deleteSocialEvaluation(record, id);

            } else if (Objects.equals(response, "exit")) {

                mp.updateEvaluationRecord(record);
                break;

            } else {
                System.out.println("Input wasn't correct, please check the available inputs!");
            }

        }
    }
}
