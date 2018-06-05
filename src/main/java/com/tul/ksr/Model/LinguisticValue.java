package com.tul.ksr.Model;

import com.tul.ksr.Fuzzy.Functions.FuzzyFunction;
import com.tul.ksr.Fuzzy.Functions.TrapezoidalFunction;
import com.tul.ksr.Fuzzy.Functions.TriangularFunction;
import com.tul.ksr.Model.DataUtils.FunctionType;

import java.lang.reflect.Method;
import java.util.List;

public class LinguisticValue {
    private String description;
    private List<Double> points;
    private FunctionType functionType;
    private Method method;
    private FuzzyFunction fuzzyFunction;

    public LinguisticValue(String description, List<Double> points, FunctionType functionType, Method method) {
        this.description = description;
        this.points = points;
        this.functionType = functionType;
        this.method = method;
        switch (functionType) {
            case TRIANGLE:
                this.fuzzyFunction = new TriangularFunction(this.getPoints());
                break;
            case TRAPEZOID:
                this.fuzzyFunction = new TrapezoidalFunction(this.getPoints());
                break;
        }
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

    public FuzzyFunction getFuzzyFunction() {
        return fuzzyFunction;
    }
}
