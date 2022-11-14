package de.hbrs.ia.restController;

import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.contract.ManagePersonalImpl;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.repositories.EvaluationRecordRepository;
import de.hbrs.ia.repositories.SalesManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class RestControllerImpl {

    private static final String template = "Hello, %s!";

    @Autowired
    ManagePersonal mp = new ManagePersonalImpl();

    @Autowired
    private SalesManRepository salesManRepository;

    @Autowired
    private EvaluationRecordRepository evaluationRecordRepository;

    @GetMapping("/salesMan/{id}")
    public SalesMan getSalesman(@PathVariable int id) {
        return salesManRepository.findById(id);
    }
    

    @GetMapping("/evaluationRecord/{id}/{year}")
    public EvaluationRecord getEvaluationRecord(@PathVariable int id, @PathVariable int year) {
        return evaluationRecordRepository.findById(id);
        //return mp.readSingleEvaluationRecord(id, year);
    }

    @PostMapping("/salesMan/")
    public String createSalesman(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int id) {
        SalesMan salesMan = new SalesMan(firstName, lastName, id);
        mp.createSalesMan(salesMan);
        salesManRepository.save(salesMan);
        return "New salesman with has been created successfully: " + salesMan;
    }

    @PostMapping("/evaluationRecord")
    public String createEvaluationRecord(@RequestParam int id, @RequestBody EvaluationRecord evaluationRecord) {
    mp.addPerformanceRecord(evaluationRecord, id);
    evaluationRecordRepository.save(evaluationRecord);
    return "New evaluation record with has been created successfully: " + evaluationRecord;
}

    @PutMapping("/updateSalesMan/{id}/{newId}")
    public SalesMan updateSalesMan (@PathVariable int id, @PathVariable int newId) {
        SalesMan salesMan = mp.readSalesMan(id);
        mp.updateSalesmanId(salesMan, newId);
        salesManRepository.save(salesMan);
        return salesMan;
    }

    @PutMapping("/updateSalesMan/{id}/{newlastName}")
    public SalesMan updateSalesMan (@PathVariable int id, @PathVariable String newLastName) {
        SalesMan salesMan = mp.readSalesMan(id);
        mp.updateSalesmanLastName(salesMan, newLastName);
        salesManRepository.save(salesMan);
        return salesMan;
    }

    @DeleteMapping("/deleteSalesman/{id}")
    public void deleteSalesMan (@PathVariable int id) {
        mp.deleteOneSalesman(mp.readSalesMan(id));
        salesManRepository.deleteSalesManById(id);
    }

    @DeleteMapping("/deleteAllSalesmen")
    public void deleteAllSalesMen () {
        mp.deleteAllSalesmen();
        salesManRepository.deleteAll();
    }

    @DeleteMapping("/deleteAllEvaluationRecords")
    public void deleteAllEvaluationRecords () {
        mp.deleteAllEvaluationRecords();
        evaluationRecordRepository.deleteAll();
    }



}
