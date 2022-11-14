package de.hbrs.ia.model;


import org.bson.Document;

import java.util.List;

//@Entity
public class EvaluationRecord {
    //@Id
    private int employeeID;
    private int year;
    //@Transient
    private List<OrderEvaluation> oe;
    //@Transient
    private List<SocialEvaluation> se;

    public EvaluationRecord(int employeeID, int year, List<OrderEvaluation> oe, List<SocialEvaluation> se) {
        this.employeeID = employeeID;
        this.year = year;
        this.oe = oe;
        this.se = se;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<OrderEvaluation> getOe() {
        return oe;
    }

    public void setOe(List<OrderEvaluation> oe) {
        this.oe = oe;
    }

    public List<SocialEvaluation> getSe() {
        return se;
    }

    public void setSe(List<SocialEvaluation> se) {
        this.se = se;
    }

    public EvaluationRecord() {
    }

    public int generateID() {
        //Here we want to give a new id for a new Order or Social Evaluation and we want to increment
        int id = 0;
        for(OrderEvaluation oe: this.oe) {
            if(id <= oe.getId()) {
                id = oe.getId() + 1;
            }
        }
        for(SocialEvaluation se: this.se) {
            if(id <= se.getId()) {
                id = se.getId() + 1;
            }

        }

        return id;
    }

    public Document toDocument() {
        org.bson.Document document = new Document();
        document.append("employeeID", this.employeeID);
        document.append("year", this.year);
        document.append("OrderEvaluation", this.oe);
        document.append("SocialEvaluation", this.se);
        return document;
    }
}
