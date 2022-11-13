package de.hbrs.ia.controller;

import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.contract.ManagePersonalImpl;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.OrderEvaluation;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialEvaluation;
/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

//@SpringBootApplication
//@AutoConfiguration
public class CLI {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ManagePersonal managePersonal = new ManagePersonalImpl();

    public static void main(String[] args) throws IOException {
        //SpringApplication.run(CLI.class, args);

        System.out.println("Welcome to the evaluation record system! Please enter help to see all commands");
        while (true) {
            executeCommand(read());
        }
    }

    public static String read() throws IOException {
        System.out.print(">> ");
        String ausgabe = reader.readLine();
        return ausgabe;
    }

    public static void executeCommand(String command) throws IOException {

        if(Objects.equals(command, "help")) {
            System.out.println("Available Commands: add (salesman/evaluationrecord), read (salesman/evaluationrecord), update (salesman/evaluationrecord), delete (salesman/evaluationrecord)");
        }

        if(Objects.equals(command, "add salesman")) {
            AddFunctions.addingSalesman(reader, managePersonal);
        }

        if(Objects.equals(command, "read salesman")) {
            SalesMan sm = ReadFunctions.readSalesMan(reader, managePersonal);
            if (sm != null) {
                PrintFunctions.printSalesMan(sm);
            } else {
                System.out.println("Employee does not exist");
            }
        }

        if(Objects.equals(command, "update salesman")) {
            System.out.println("Please enter the id of the employee you want to update");
            int id = Integer.parseInt(reader.readLine());;
            SalesMan sm = managePersonal.readSalesMan(id);
            System.out.println("What do u want to update? (available options: id or last name)");
            String response = reader.readLine();

            if(Objects.equals(response, "id")) {
                UpdateFunctions.updateSalesmanID(reader, managePersonal, id);
            }

            else if(Objects.equals(response, "last name")) {
                UpdateFunctions.updateSalesmanLastName(reader, managePersonal, id);
            }

            else {
                System.out.println("Invalid input");
            }
        }

        if(Objects.equals(command, "delete salesman")) {
            DeleteFunctions.deleteSalesman(reader, managePersonal);
        }

        if(Objects.equals(command, "delete all salesmen")) {
            DeleteFunctions.deleteAllSalesMen(reader, managePersonal);
        }

        if(Objects.equals(command, "add evaluationrecord")) {
            EvaluationRecord record = AddFunctions.addingEvaluationRecord(reader, managePersonal);
            UpdateFunctions.updateEvaluationrecord(reader, managePersonal, record);
            System.out.println("Evaluationrecord was successfully added");
        }

        if(Objects.equals(command, "read evaluationrecord")) {
            EvaluationRecord record = ReadFunctions.readSingleEvaluationRecord(reader, managePersonal);
            PrintFunctions.printEvaluationRecord(record);
        }

        if(Objects.equals(command, "read list of evaluationrecords")) {
            List<EvaluationRecord> list = ReadFunctions.readEvaluationRecords(reader, managePersonal);
            for(EvaluationRecord record : list) {
                PrintFunctions.printEvaluationRecord(record);
            }
        }

        if(Objects.equals(command, "update evaluationrecord")) {
            EvaluationRecord record = ReadFunctions.readSingleEvaluationRecord(reader, managePersonal);
            UpdateFunctions.updateEvaluationrecord(reader, managePersonal, record);
        }

        if(Objects.equals(command, "delete evaluationrecord")) {
            DeleteFunctions.deleteEvaluationrecord(reader, managePersonal);
        }

        if(Objects.equals(command, "delete all evaluationrecords")) {
            DeleteFunctions.deleteAllEvaluationRecords(reader, managePersonal);

            //Wird noch nicht aus der Datenbank gelöscht, muss noch gefixed werden
        }
    }
}
