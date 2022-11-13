package de.hbrs.ia.restController;

import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.contract.ManagePersonalImpl;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("")
@ComponentScan("de/hbrs/ia/controller")
public class RestControllerImpl {

    private static final String template = "Hello, %s!";

    @Autowired
    ManagePersonal mp = new ManagePersonalImpl();

    @GetMapping("/salesMan/{id}")
    public SalesMan getSalesman(@PathVariable int id) {
        return mp.readSalesMan(id);
    }
    

    @GetMapping("/evaluationRecord/{id}")
    public EvaluationRecord getEvaluationRecord(@PathVariable int id) {
        return mp.readEvaluationRecords(id);
    }

    @PostMapping("/salesMan/")
    public String createSalesman(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int id) {
        SalesMan salesMan = new SalesMan(firstName, lastName, id);
        mp.createSalesMan(salesMan);
        return "New salesman with has been created successfully: " + salesMan;
    }

    @PostMapping("/evaluationRecord")
    public String createEvaluationRecord(@RequestParam int id, @RequestBody EvaluationRecord evaluationRecord) {
    mp.addPerformanceRecord(evaluationRecord, id);
    return "New evaluation record with has been created successfully: " + evaluationRecord;
}

    @PutMapping("/updateSalesMan/{id}/{newId}")
    public SalesMan updateSalesMan (@PathVariable int id, @PathVariable int newId) {
        SalesMan salesMan = mp.readSalesMan(id);
        mp.updateSalesmanId(salesMan, newId);
        return salesMan;
    }

    @PutMapping("/updateSalesMan/{id}/{newlastName}")
    public SalesMan updateSalesMan (@PathVariable int id, @PathVariable String newLastName) {
        SalesMan salesMan = mp.readSalesMan(id);
        mp.updateSalesmanLastName(salesMan, newLastName);
        return salesMan;
    }

    @DeleteMapping("/deleteSalesman/{id}")
    public void deleteSalesMan (@PathVariable int id) {
        mp.deleteOneSalesman(mp.readSalesMan(id));
    }

    @DeleteMapping("/deleteAllSalesmen")
    public void deleteAllSalesMen () {
        mp.deleteAllSalesmen();
    }

    @DeleteMapping("/deleteAllEvaluationRecords")
    public void deleteAllEvaluationRecords () {
        mp.deleteAllEvaluationRecords();
    }



}
