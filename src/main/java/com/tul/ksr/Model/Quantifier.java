package com.tul.ksr.Model;

import com.tul.ksr.Model.DataUtils.FunctionType;
import com.tul.ksr.Model.DataUtils.QuantifierType;

import java.util.List;

public class Quantifier {
    private String description;
    private List<Double> points;
    private QuantifierType quantifierType;
    private FunctionType functionType;

    public Quantifier(String description, List<Double> points, QuantifierType quantifierType, FunctionType functionType) {
        this.description = description;
        this.points = points;
        this.quantifierType = quantifierType;
        this.functionType = functionType;
    }

    public String getDescription() {
        return description;
    }

    public List<Double> getPoints() {
        return points;
    }

    public QuantifierType getQuantifierType() {
        return quantifierType;
    }

    public FunctionType getFunctionType() {
        return functionType;
    }
}
