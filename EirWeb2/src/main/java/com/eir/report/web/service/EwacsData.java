package com.eir.report.web.service;

import java.util.List;

public class EwacsData {
    private String name;
    private List<Long> bmIdList;

    public EwacsData(String name, List<Long> bmIdList) {
        this.name = name;
        this.bmIdList = bmIdList;
    }

    public String getName() {
        return name;
    }

    public List<Long> getBmIdList() {
        return bmIdList;
    }
}
