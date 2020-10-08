package com.all.in.one.pramod.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("Financial_Year")
    @Expose
    private String financial_Year;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFinancial_Year() {
        return financial_Year;
    }

    public void setFinancial_Year(String financial_Year) {
        this.financial_Year = financial_Year;
    }
}
