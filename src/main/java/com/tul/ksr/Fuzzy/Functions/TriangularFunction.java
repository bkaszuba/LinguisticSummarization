package com.tul.ksr.Fuzzy.Functions;

import java.util.LinkedList;
import java.util.List;

public class TriangularFunction implements FuzzyFunction {
    private List<Double> points;


    public TriangularFunction(List<Double> pointsList) {
        points = new LinkedList<>(pointsList);
    }

    @Override
    public double getMembership(double x) {
        return Math.max(Math.min((x - points.get(0)) / (points.get(1) - points.get(0)), (points.get(2) - x) / (points.get(2) - points.get(1))), 0);
    }
}
