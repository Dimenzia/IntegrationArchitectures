package de.hbrs.ia.contract;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import java.util.List;

public interface ManagePersonal {

    public void createSalesMan( SalesMan record );

    public void addPerformanceRecord( EvaluationRecord record , int sid );

    public SalesMan readSalesMan( int sid );

    public List<SalesMan> querySalesMan(String attribute , String key );

    public List<EvaluationRecord> readEvaluationRecords(int sid );

    public EvaluationRecord readSingleEvaluationRecord(int id, int year);

    public void updateSalesmanLastName (SalesMan record, String newLastName);

    public void updateSalesmanId (SalesMan record, Integer newId);

    public void updateEvaluationRecord(EvaluationRecord record);

    public void deleteOneEvaluationRecord(EvaluationRecord record);

    public void deleteOneSalesman(SalesMan salesMan);

    public void deleteAllSalesmen();

    public void deleteAllEvaluationRecords();
}
