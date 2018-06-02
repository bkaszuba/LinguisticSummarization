package com.tul.ksr.Model;

import com.tul.ksr.Model.DataUtils.FunctionType;

import java.lang.reflect.Method;
import java.util.List;

public class LinguisticValue {
    private String description;
    private List<Double> points;
    private FunctionType functionType;
    private Method method;

    public LinguisticValue(String description, List<Double> points, FunctionType functionType, Method method) {
        this.description = description;
        this.points = points;
        this.functionType = functionType;
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }

    public String getDescription() {
        return description;
    }

    public List<Double> getPoints() {
        return points;
    }

    public FunctionType getFunctionType() {
        return functionType;
    }
}
