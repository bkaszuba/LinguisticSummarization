package com.tul.ksr.Fuzzy.Functions;

public class TrapezoidalFunction implements FuzzyFunction {
    double a;
    double b;
    double c;
    double d;

    public TrapezoidalFunction(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double getMembership(double x) {
        return Math.max(Math.min(Math.min((x - a) / (b - a), 1), (d - x) / (d - c)), 0);
    }
}
