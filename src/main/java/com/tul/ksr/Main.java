package com.tul.ksr;

import com.tul.ksr.Fuzzy.Functions.MonotonicFunction;
import com.tul.ksr.Fuzzy.Functions.TrapezoidalFunction;
import com.tul.ksr.Fuzzy.Functions.TriangularFunction;
import com.tul.ksr.Fuzzy.Operations.OperationManager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TriangularFunction trian1 = new TriangularFunction(0, 4, 8);
        System.out.println(trian1.getMembership(4));
        TrapezoidalFunction trap = new TrapezoidalFunction(0,2,4,6);
        System.out.println(trap.getMembership(5));

        TriangularFunction trian2 = new TriangularFunction(2, 6, 10);
        OperationManager operation = new OperationManager(Arrays.asList(trian1, trian2));
        System.out.println(operation.getIntersectionMembership(7));
    }
}
