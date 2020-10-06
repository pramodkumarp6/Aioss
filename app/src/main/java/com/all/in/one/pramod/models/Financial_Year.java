package com.all.in.one.pramod.models;

public class Financial_Year {

    private String  id ;
    private String Financial_Year;

    public Financial_Year(String id, String financial_Year) {
        this.id = id;
        Financial_Year = financial_Year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFinancial_Year() {
        return Financial_Year;
    }

    public void setFinancial_Year(String financial_Year) {
        Financial_Year = financial_Year;
    }
}
