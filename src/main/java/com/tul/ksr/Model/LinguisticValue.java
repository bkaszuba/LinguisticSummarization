package com.tul.ksr.Model;

import com.tul.ksr.Model.DataUtils.FunctionType;

import java.util.List;

public class LinguisticValue {
    private String description;
    private List<Double> points;
    private FunctionType functionType;

    public LinguisticValue(String description, List<Double> points, FunctionType functionType) {
        this.description = description;
        this.points = points;
        this.functionType = functionType;
    }
}
