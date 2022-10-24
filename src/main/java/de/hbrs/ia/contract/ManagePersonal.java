package de.hbrs.ia.contract;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import java.util.List;

public interface ManagePersonal {

    public void createSalesMan( SalesMan record );

    public void addPerformanceRecord( EvaluationRecord record , int sid );

    public SalesMan readSalesMan( int sid );

    public List<SalesMan> querySalesMan(String attribute , String key );

    public EvaluationRecord readEvaluationRecords(int sid );

}
