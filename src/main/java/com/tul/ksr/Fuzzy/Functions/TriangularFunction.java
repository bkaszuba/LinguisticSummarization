package com.tul.ksr.Fuzzy.Functions;

public class TriangularFunction implements FuzzyFunction {
    private double a;
    private double b;
    private double c;

    public TriangularFunction(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getMembership(double x) {
        return Math.max(Math.min((x - a) / (b - a), (c - x) / (c - b)), 0);
    }
}
