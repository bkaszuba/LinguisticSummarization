package com.tul.ksr;

import com.tul.ksr.Fuzzy.Operations.GeorgeCalculator;
import com.tul.ksr.Fuzzy.Operations.QualityMeasures;
import com.tul.ksr.Fuzzy.Operations.YagerCalculator;
import com.tul.ksr.Model.*;

import java.util.ArrayList;
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

        List<LinguisticValue> severalLinguisticValues = new ArrayList<>();
        severalLinguisticValues.add(linguisticValues.get(1));
        severalLinguisticValues.add(linguisticValues.get(2));
        //severalLinguisticValues.add(linguisticValues.get(3));

        List<Quantifier> severalQuantifiers = new ArrayList<>();
        severalQuantifiers.add(quantifierList.get(6));
        severalQuantifiers.add(quantifierList.get(7));
        severalQuantifiers.add(quantifierList.get(8));

        List<Player> players = DataParser.createPlayerList();
        List<Player> playerTest = players.subList(0, 10);
        QualityMeasures qualityMeasures = new QualityMeasures(severalLinguisticValues, severalQuantifiers, playerTest);
        qualityMeasures.T1();
//        YagerCalculator yagerCalculator = new YagerCalculator(severalQuantifiers, severalLinguisticValues, playerTest);
//        yagerCalculator.calculateYager();
//
//        GeorgeCalculator georgeCalculator = new GeorgeCalculator(severalQuantifiers, severalLinguisticValues, players);
//        georgeCalculator.calculateGeorge();
    }
}
