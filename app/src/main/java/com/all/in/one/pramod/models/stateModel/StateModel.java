package com.all.in.one.pramod.models.stateModel;

import com.all.in.one.pramod.models.finacal.Datum;

import java.util.List;

public class StateModel {
    private Integer status;

    public List<StateData> getData() {
        return data;
    }

    public void setData(List<StateData> data) {
        this.data = data;
    }

    private List<StateData> data = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
