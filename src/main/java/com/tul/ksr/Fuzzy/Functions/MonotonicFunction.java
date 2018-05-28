package com.tul.ksr.Fuzzy.Functions;

public class MonotonicFunction implements FuzzyFunction {
    private double a;
    private double b;

    public MonotonicFunction(double a, double b) {
        this.a = a;
        this.b = b;
    }

    //TODO Implement
    @Override
    public double getMembership(double x) {
        return 0;
    }
}
