package com.tul.ksr.Model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.tul.ksr.Model.DataUtils.FunctionType.TRAPEZOID;
import static com.tul.ksr.Model.DataUtils.FunctionType.TRIANGLE;
import static com.tul.ksr.Model.DataUtils.QuantifierType.ABSOLUTE;
import static com.tul.ksr.Model.DataUtils.QuantifierType.RELATIVE;
import static java.util.Arrays.asList;

public class DataCreator {
    public List<Quantifier> createQuantifiers() {
        List<Quantifier> quantifiers = new ArrayList<>();
        quantifiers.add(new Quantifier("Mało", createPointsList(0.0, 0.1, 0.2), RELATIVE, TRIANGLE));
        quantifiers.add(new Quantifier("Połowa", createPointsList(0.4, 0.5, 0.6), RELATIVE, TRIANGLE));
        quantifiers.add(new Quantifier("Dużo", createPointsList(0.5, 0.8, 1.0, 1.0), RELATIVE, TRAPEZOID));
        quantifiers.add(new Quantifier("Około 2000", createPointsList(1000.0, 2000.0, 3000.0), ABSOLUTE, TRIANGLE));
        quantifiers.add(new Quantifier("Około 4000", createPointsList(3000.0, 4000.0, 5000.0), ABSOLUTE, TRIANGLE));
        quantifiers.add(new Quantifier("Około 6000", createPointsList(5000.0, 6000.0, 7000.0), ABSOLUTE, TRIANGLE));
        //TEST
        quantifiers.add(new Quantifier("SOME", createPointsList(0.1,0.2, 0.3, 0.4), RELATIVE, TRAPEZOID));
        quantifiers.add(new Quantifier("ABOUT HALF", createPointsList(0.3,0.4,0.5,0.6), RELATIVE, TRAPEZOID));
        quantifiers.add(new Quantifier("A LOT", createPointsList(0.5,0.6,0.9,1.1), RELATIVE, TRAPEZOID));
        return quantifiers;
    }

    public List<LinguisticValue> createLinguisticValue() throws NoSuchMethodException {
        List<LinguisticValue> linguisticValues = new ArrayList<>();
        linguisticValues.add(new LinguisticValue("WEIGHT A LOT", createPointsList(165.0, 190.0, 230.0), TRIANGLE, getMethod("getWeight")));
        linguisticValues.add(new LinguisticValue("WEIGHT LITTLE", createPointsList(153.0, 165.0, 195.0, 210.0), TRAPEZOID, getMethod("getWeight")));
        linguisticValues.add(new LinguisticValue("WEIGHT A LOT", createPointsList(180.0, 210.0, 225.0, 240.0), TRAPEZOID, getMethod("getWeight")));
        linguisticValues.add(new LinguisticValue("o niskiej wadze", createPointsList(125.0, 140.0, 150.0), TRIANGLE, getMethod("getWeight")));
        linguisticValues.add(new LinguisticValue("o wysokiej wadze", createPointsList(240.0, 250.0, 265.0), TRIANGLE, getMethod("getWeight")));
        linguisticValues.add(new LinguisticValue("niskiego wzrostu", createPointsList(61.0, 65.0, 69.0), TRIANGLE, getMethod("getHeight")));
        linguisticValues.add(new LinguisticValue("średniego wzrostu", createPointsList(68.0, 73.0, 77.0), TRIANGLE, getMethod("getHeight")));
        linguisticValues.add(new LinguisticValue("wysokiego wzrostu", createPointsList(77.0, 80.0, 84.0), TRIANGLE, getMethod("getHeight")));
        linguisticValues.add(new LinguisticValue("małej ilości goli", createPointsList(0.0, 40.0, 80.0), TRIANGLE, getMethod("getGoals")));
        linguisticValues.add(new LinguisticValue("średnia ilość goli", createPointsList(80.0, 110.0, 140.0), TRIANGLE, getMethod("getGoals")));
        linguisticValues.add(new LinguisticValue("dużej ilości goli", createPointsList(140.0, 170.0, 200.0), TRIANGLE, getMethod("getGoals")));
        linguisticValues.add(new LinguisticValue("w młodym wieku", createPointsList(1940.0, 1965.0, 1993.0), TRIANGLE, getMethod("getBirthYear")));
        linguisticValues.add(new LinguisticValue("w starszym wieku", createPointsList(1841.0, 1890.0, 1940.0), TRIANGLE, getMethod("getBirthYear")));
        return linguisticValues;
    }

    private List<Double> createPointsList(double a, double b, double c) {
        return new ArrayList<>(asList(a, b, c));
    }

    private List<Double> createPointsList(double a, double b, double c, double d) {
        return new ArrayList<>(asList(a, b, c, d));
    }

    private Method getMethod(String name) throws NoSuchMethodException {
        return Player.class.getMethod(name);
    }
}
