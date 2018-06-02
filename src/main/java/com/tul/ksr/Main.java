package com.tul.ksr;

import com.tul.ksr.Fuzzy.Operations.YagerCalculator;
import com.tul.ksr.Model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
//        TriangularFunction trian1 = new TriangularFunction(new ArrayList<>(asList(0.0, 4.0, 8.0)));
//        System.out.println(trian1.getMembership(4));
//        TrapezoidalFunction trap = new TrapezoidalFunction(new ArrayList<>(asList(0.0, 2.0, 4.0, 6.0)));
//        System.out.println(trap.getMembership(5));
//
//        TriangularFunction trian2 = new TriangularFunction(new ArrayList<>(asList(2.0, 6.0, 10.0)));
//        OperationManager operation = new OperationManager(asList(trian1, trian2));
//        System.out.println(operation.getIntersectionMembership(7));
        DataCreator dataCreator = new DataCreator();
        List<Quantifier> quantifierList = dataCreator.createQuantifiers();
        List<LinguisticValue> linguisticValues = dataCreator.createLinguisticValue();
        List<Player> players = DataParser.createPlayerList();
        YagerCalculator yagerCalculator = new YagerCalculator(quantifierList.get(4), linguisticValues.get(2), players);
        yagerCalculator.calculateYager();
        YagerCalculator yagerCalculator1 = new YagerCalculator(quantifierList.get(4), linguisticValues.get(3), players);
        yagerCalculator1.calculateYager();
        YagerCalculator yagerCalculator2 = new YagerCalculator(quantifierList.get(4), linguisticValues.get(4), players);
        yagerCalculator2.calculateYager();
    }
}
