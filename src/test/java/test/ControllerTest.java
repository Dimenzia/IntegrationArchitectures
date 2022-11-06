package test;


import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.contract.ManagePersonalImpl;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.OrderEvaluation;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.model.SocialEvaluation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ControllerTest {

    static ManagePersonal mp = new ManagePersonalImpl();

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

    @AfterEach
    public void tearDown() {
    mp.deleteAllSalesmen();
    mp.deleteAllEvaluationRecords();
    }

    SalesMan salesman = new SalesMan("Max", "Mustermann", 1);

    EvaluationRecord evaluationRecord = new EvaluationRecord(1, 2022, oetest, setest);

    @Test
    public void createSalesmanTest() {
        SalesMan salesman = new SalesMan("Max", "Mustermann", 1);
        mp.createSalesMan(salesman);
        Assertions.assertEquals(salesman, mp.readSalesMan(1));
    }

    @Test
    public void addPerformanceRecordTest() {
        EvaluationRecord evaluationRecord = new EvaluationRecord(1, 2022, oetest, setest);
        mp.addPerformanceRecord(evaluationRecord, 1);
        Assertions.assertEquals(evaluationRecord, mp.readEvaluationRecords(1));
    }

    @Test
    public void readSalesManTest() {
        mp.createSalesMan(salesman);
        Assertions.assertEquals(salesman, mp.readSalesMan(1));
    }

    @Test
    public void readSEvaluationRecordTest() {
        mp.addPerformanceRecord(evaluationRecord, 1);
        Assertions.assertEquals(evaluationRecord, mp.readEvaluationRecords(1));
    }

    @Test
    public void updateSalesManTest() {
        mp.createSalesMan(salesman);
        SalesMan salesmanTest = salesman;
        salesmanTest.setLastname("Baggins");

        //Test for updating last name
        mp.updateSalesmanLastName(salesman, "Baggins");
        Assertions.assertEquals(salesmanTest, mp.readSalesMan(1));

        //Test for altering id
        salesmanTest.setSid(2);
        mp.updateSalesmanId(salesman, 2);
        Assertions.assertEquals(salesmanTest, mp.readSalesMan(2));
    }

    @Test
    public void deleteSalesmanTest() {
        ManagePersonal mpTemp = mp;
        Assertions.assertEquals(mpTemp, mp);
        mp.createSalesMan(salesman);
        Assertions.assertNotEquals(mpTemp, mp);

        //deleteOneSalesman
        mp.deleteOneSalesman(salesman);
        Assertions.assertEquals(mpTemp, mp);

        //deleteAllSalesmen
        SalesMan salesman2 = new SalesMan("Günther", "Müller", 2);
        SalesMan salesman3 = new SalesMan("Peppa", "Pig", 3);

        mp.createSalesMan(salesman);
        mp.createSalesMan(salesman2);
        mp.createSalesMan(salesman3);
        mp.deleteAllSalesmen();
        Assertions.assertEquals(mpTemp, mp);
    }

    @Test
    public void deleteAllEvaluationRecords() {
        ManagePersonal mpTemp = mp;
        Assertions.assertEquals(mpTemp, mp);
        mp.createSalesMan(salesman);
        mp.addPerformanceRecord(evaluationRecord, 1);
        mp.deleteAllEvaluationRecords();
        Assertions.assertEquals(mpTemp, mp);
    }






}
