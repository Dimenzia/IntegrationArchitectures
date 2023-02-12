package de.hbrs.ia.controller;

import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.contract.ManagePersonalImpl;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@ComponentScan
public class RestControllerImpl {

    static ManagePersonal mp = new ManagePersonalImpl();


    @GetMapping("/salesman/{id}")
    public SalesMan getSalesman(@PathVariable int id) {
            return mp.readSalesMan(id);
    }
    

    @GetMapping("/evaluationRecord/{id}/{year}")
    public EvaluationRecord getEvaluationRecord(@PathVariable int id, @PathVariable int year) {
            return mp.readSingleEvaluationRecord(id, year);

    }

    @PostMapping("/salesman/")
    public String createSalesman(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int id) {
        SalesMan salesMan = new SalesMan(firstName, lastName, id);
        mp.createSalesMan(salesMan);
        return "New salesman with id " + id + " has been created successfully: " + salesMan.toDocument();
    }

    @PostMapping("/evaluationRecord")
    public String createEvaluationRecord(@RequestParam int id, @RequestBody EvaluationRecord evaluationRecord) {
    mp.addPerformanceRecord(evaluationRecord, id);
    return "New evaluation record has been created successfully: " + evaluationRecord.toDocument();
}
/*
    @PutMapping("/updateSalesman/{id}/{newId}")
    public SalesMan updateSalesMan (@PathVariable int id, @PathVariable int newId) {
        SalesMan salesMan = mp.readSalesMan(id);
        mp.updateSalesmanId(salesMan, newId);
        salesManRepository.save(salesMan);
        return salesMan;
    } **/

    @PutMapping("/updateSalesman/{id}/{newLastName}")
    public SalesMan updateSalesMan (@PathVariable int id, @PathVariable String newLastName) {
        SalesMan salesMan = mp.readSalesMan(id);
        mp.updateSalesmanLastName(salesMan, newLastName);
        return salesMan;
    }

    @DeleteMapping("/deleteSalesman/{id}")
    public String deleteSalesMan (@PathVariable int id) {
       SalesMan salesMan = mp.readSalesMan(id);
        mp.deleteOneSalesman(mp.readSalesMan(id));
        return "The following salesman has been deleted: " + salesMan.toDocument();
    }

    @DeleteMapping("/deleteAllSalesmen")
    public String deleteAllSalesMen () {
        mp.deleteAllSalesmen();
        return "There are no more salesmen in the database.";
    }

    @DeleteMapping("/deleteAllEvaluationRecords")
    public String deleteAllEvaluationRecords () {
        mp.deleteAllEvaluationRecords();
        return "There are no more evaluation records in the database.";
    }



}
