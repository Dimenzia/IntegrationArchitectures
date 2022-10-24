package de.hbrs.ia.contract;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.OrderEvaluation;
import de.hbrs.ia.model.SocialEvaluation;
import de.hbrs.ia.model.SalesMan;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.all;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ManagePersonalImpl implements ManagePersonal {

    static CodecRegistry pojoCodecRegistry = fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder()
                    .register(OrderEvaluation.class)
                    .register(EvaluationRecord.class)
                    .register(SocialEvaluation.class)
                    .register(SalesMan.class)
                    .build()));
    static MongoClient mongoClient = new MongoClient();
    static MongoDatabase database = mongoClient.getDatabase("local").withCodecRegistry(pojoCodecRegistry);

    public void createSalesMan( SalesMan record ) {
        MongoCollection<SalesMan> collection = database.getCollection("salesman", SalesMan.class);
        collection.insertOne(record);
    }

    public void addPerformanceRecord(EvaluationRecord record , int sid ) {
        MongoCollection<EvaluationRecord> collection = database.getCollection("evaluationrecord", EvaluationRecord.class);
        record.setEmployeeID(sid);
        collection.insertOne(record);
    }

    public SalesMan readSalesMan( int sid ) {
        MongoCollection<SalesMan> collection = database.getCollection("salesman", SalesMan.class);
        return collection.find(eq("sid", sid)).first();
    }

    public List<SalesMan> querySalesMan(String attribute , String key ) {
        MongoCollection<SalesMan> collection = database.getCollection("salesman", SalesMan.class);
        return collection.find(eq(attribute, key)).into(new ArrayList<SalesMan>());
    }

    public EvaluationRecord readEvaluationRecords(int sid ) {
        MongoCollection<EvaluationRecord> collection = database.getCollection("evaluationrecord", EvaluationRecord.class);
        return null;
    }

    public void updateSalesmanLastName (SalesMan record, String newLastName) {
        MongoCollection<SalesMan> collection = database.getCollection("salesman", SalesMan.class);
        SalesMan temp = record;
        temp.setLastname(newLastName);
        collection.deleteOne(record.toDocument());
        collection.insertOne(temp);
    }

    public void updateSalesmanId (SalesMan record, Integer newId) {
        MongoCollection<SalesMan> collection = database.getCollection("salesman", SalesMan.class);
        SalesMan temp = record;
        temp.setSid(newId);
        collection.deleteOne(record.toDocument());
        collection.insertOne(temp);
    }

    public SalesMan deleteOneSalesman (SalesMan salesMan) {
        MongoCollection<SalesMan> collection = database.getCollection("salesman", SalesMan.class);
        //SalesMan salesMan = collection.find(id = salesManId);
        collection.findOneAndDelete(salesMan.toDocument());
        return salesMan;
    }

    public void deleteAllSalesmen() {
        MongoCollection<SalesMan> collection = database.getCollection("salesman", SalesMan.class);
        collection.drop();
    }

    public void deleteAllEvaluationRecords() {
        MongoCollection<EvaluationRecord> collection = database.getCollection("evaluationRecord", EvaluationRecord.class);
        collection.drop();
    }
}
