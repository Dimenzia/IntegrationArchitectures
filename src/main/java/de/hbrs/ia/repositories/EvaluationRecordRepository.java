package de.hbrs.ia.repositories;

import de.hbrs.ia.model.EvaluationRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRecordRepository extends MongoRepository<EvaluationRecord, Integer> {

    EvaluationRecord findById(int id);
    void deleteEvaluationRecordById(int id);
    void deleteAllBy(int id);
}
