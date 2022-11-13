package de.hbrs.ia.model;

public class SocialEvaluation {

    private int id;
    private String targetName;
    private int targetValue;
    private int actualValue;
    private int bonus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public int getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(int targetValue) {
        this.targetValue = targetValue;
    }

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public SocialEvaluation() {
    }

    public SocialEvaluation(String targetName, int targetValue, int actualValue, int bonus) {
        this.targetName = targetName;
        this.targetValue = targetValue;
        this.actualValue = actualValue;
        this.bonus = bonus;
    }
}
