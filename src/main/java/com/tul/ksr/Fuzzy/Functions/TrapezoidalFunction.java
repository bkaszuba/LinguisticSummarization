package com.tul.ksr.Fuzzy.Functions;

import java.util.LinkedList;
import java.util.List;

public class TrapezoidalFunction implements FuzzyFunction {
    private List<Double> points;


    public TrapezoidalFunction(List<Double> pointsList) {
        points = new LinkedList<>(pointsList);
    }

    @Override
    public double getMembership(double x) {
        return Math.max(Math.min(Math.min((x - points.get(0)) / (points.get(1) - points.get(0)), 1), (points.get(3) - x) / (points.get(3) - points.get(2))), 0);
    }
}
