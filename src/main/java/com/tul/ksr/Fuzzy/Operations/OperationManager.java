package com.tul.ksr.Fuzzy.Operations;

import com.tul.ksr.Fuzzy.Functions.FuzzyFunction;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OperationManager {
    List<FuzzyFunction> functions;

    public OperationManager(List<FuzzyFunction> functions) {
        this.functions = functions;
    }

    public double getUnionMembership(double x) {
        return Collections.max(getAllMembershipValues(x));
    }

    public double getIntersectionMembership(double x) {
        return Collections.min(getAllMembershipValues(x));
    }

    private List<Double> getAllMembershipValues(double x) {
        return functions.stream()
                .map(f -> f.getMembership(x))
                .collect(Collectors.toList());
    }

   //TODO Complement membership value
}
