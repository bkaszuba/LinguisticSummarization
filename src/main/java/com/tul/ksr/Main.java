package com.tul.ksr;

import com.tul.ksr.Fuzzy.Functions.TrapezoidalFunction;
import com.tul.ksr.Fuzzy.Functions.TriangularFunction;
import com.tul.ksr.Fuzzy.Operations.OperationManager;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        TriangularFunction trian1 = new TriangularFunction(new ArrayList<>(asList(0.0, 4.0, 8.0)));
        System.out.println(trian1.getMembership(4));
        TrapezoidalFunction trap = new TrapezoidalFunction(new ArrayList<>(asList(0.0, 2.0, 4.0, 6.0)));
        System.out.println(trap.getMembership(5));

        TriangularFunction trian2 = new TriangularFunction(new ArrayList<>(asList(2.0, 6.0, 10.0)));
        OperationManager operation = new OperationManager(asList(trian1, trian2));
        System.out.println(operation.getIntersectionMembership(7));

    }
}
