package de.hbrs.ia.restController;

import de.hbrs.ia.contract.ManagePersonal;
import de.hbrs.ia.contract.ManagePersonalImpl;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import de.hbrs.ia.repositories.EvaluationRecordRepository;
import de.hbrs.ia.repositories.SalesManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


@RestController
@RequestMapping("/api")
@ComponentScan
public class RestControllerImpl {

    private static final String template = "Hello, %s!";

    static ManagePersonal mp = new ManagePersonalImpl();

    @Autowired
    private SalesManRepository salesManRepository = new SalesManRepository(){

        @Override
        public <S extends SalesMan> S save(S entity) {
            mp.createSalesMan(entity);
            return null;
        }

        @Override
        public Optional<SalesMan> findById(Integer integer) {
            return Optional.ofNullable(mp.readSalesMan((int) integer));
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }


        @Override
        public <S extends SalesMan> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<SalesMan> findAll() {
            return null;
        }

        @Override
        public Iterable<SalesMan> findAllById(Iterable<Integer> integers) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {
            mp.deleteOneSalesman(mp.readSalesMan(integer));
        }

        @Override
        public void delete(SalesMan entity) {
            mp.deleteOneSalesman(entity);
        }

        @Override
        public void deleteAllById(Iterable<? extends Integer> integers) {
        }

        @Override
        public void deleteAll(Iterable<? extends SalesMan> entities) {
            mp.deleteAllSalesmen();
        }

        @Override
        public void deleteAll() {
            mp.deleteAllSalesmen();
        }

        @Override
        public List<SalesMan> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<SalesMan> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends SalesMan> S insert(S entity) {
            mp.createSalesMan(entity);
            return entity;
        }

        @Override
        public <S extends SalesMan> List<S> insert(Iterable<S> entities) {
            return null;
        }

        @Override
        public <S extends SalesMan> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends SalesMan> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends SalesMan> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends SalesMan> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends SalesMan> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends SalesMan> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends SalesMan, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }

        @Override
        public SalesMan findById(int id) {
            return mp.readSalesMan(id);
        }

        @Override
        public void deleteSalesManById(int id) {
            mp.deleteOneSalesman(mp.readSalesMan(id));
        }

        @Override
        public void deleteAllBy(int id) {
            mp.deleteAllSalesmen();
        }
    };

    @Autowired
    private EvaluationRecordRepository evaluationRecordRepository;

    @GetMapping("/salesMan/{id}")
    public SalesMan getSalesman(@PathVariable int id) {
        if (salesManRepository.findById(id) == null) {
            return mp.readSalesMan(id);
        } else {
        return salesManRepository.findById(id);}
    }
    

    @GetMapping("/evaluationRecord/{id}/{year}")
    public EvaluationRecord getEvaluationRecord(@PathVariable int id, @PathVariable int year) {
        if (!(evaluationRecordRepository.findById(id) instanceof EvaluationRecord)) {
            return mp.readSingleEvaluationRecord(id, year);
        } else {
            return evaluationRecordRepository.findById(id);
        } //return mp.readSingleEvaluationRecord(id, year);
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
