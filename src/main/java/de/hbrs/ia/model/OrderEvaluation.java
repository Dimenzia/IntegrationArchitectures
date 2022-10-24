package de.hbrs.ia.model;

public class OrderEvaluation {
    private String productName;
    private String client;
    private String clientRanking;
    private int items;
    private int bonus;

    public OrderEvaluation() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getClientRanking() {
        return clientRanking;
    }

    public void setClientRanking(String clientRanking) {
        this.clientRanking = clientRanking;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public OrderEvaluation(String productName, String client, String clientRanking, int items, int bonus) {
        this.productName = productName;
        this.client = client;
        this.clientRanking = clientRanking;
        this.items = items;
        this.bonus = bonus;
    }
}
