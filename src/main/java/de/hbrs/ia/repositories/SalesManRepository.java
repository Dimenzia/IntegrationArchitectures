package de.hbrs.ia.repositories;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesManRepository extends MongoRepository<SalesMan, String> {

    SalesMan findById(int id);
    void deleteSalesManById(int id);
    void deleteAllBy(int id);
}
