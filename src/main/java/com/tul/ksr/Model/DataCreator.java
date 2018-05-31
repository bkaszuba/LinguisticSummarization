package com.tul.ksr.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.tul.ksr.Model.DataUtils.FunctionType.TRAPEZOID;
import static com.tul.ksr.Model.DataUtils.FunctionType.TRIANGLE;
import static com.tul.ksr.Model.DataUtils.QuantifierType.ABSOLUTE;
import static com.tul.ksr.Model.DataUtils.QuantifierType.RELATIVE;
import static java.util.Arrays.asList;

public class DataCreator {
    public static List<Quantifier> createQuantifiers() {
        List<Quantifier> quantifiers = new ArrayList<>();
        quantifiers.add(new Quantifier("Mało", new ArrayList<>(asList(0.0, 0.0, 0.05)), RELATIVE, TRIANGLE));
        quantifiers.add(new Quantifier("Połowa", new ArrayList<>(asList(0.4, 0.5, 0.6)), RELATIVE, TRIANGLE));
        quantifiers.add(new Quantifier("Dużo", new ArrayList<>(asList(0.5, 0.8, 1.0, 1.0)), RELATIVE, TRAPEZOID));
        quantifiers.add(new Quantifier("Około 2000", new ArrayList<>(asList(1500.0, 2000.0, 2500.0)), ABSOLUTE, TRIANGLE));
        quantifiers.add(new Quantifier("Około 5000", new ArrayList<>(asList(4500.0, 5000.0, 5500.0)), ABSOLUTE, TRIANGLE));
        quantifiers.add(new Quantifier("Około 7000", new ArrayList<>(asList(6500.0, 7000.0, 7500.0)), ABSOLUTE, TRIANGLE));
        return quantifiers;
    }

    public static List<LinguisticValue> createLinguisticValue() {
        List<LinguisticValue> linguisticValues = new ArrayList<>();
        linguisticValues.add(new LinguisticValue("o niskiej wadze", new ArrayList<>(asList(125.0, 140.0, 150.0)), TRIANGLE));
        linguisticValues.add(new LinguisticValue("o wysokiej wadze", new ArrayList<>(asList(240.0, 250.0, 265.0)), TRIANGLE));
        linguisticValues.add(new LinguisticValue("niskiego wzrostu", new ArrayList<>(asList(63.0, 63.0, 67.0)), TRIANGLE));
        linguisticValues.add(new LinguisticValue("średniego wzrostu", new ArrayList<>(asList(67.0, 70.0, 74.0)), TRIANGLE));
        linguisticValues.add(new LinguisticValue("wysokiego wzrostu", new ArrayList<>(asList(74.0, 83.0, 83.0)), TRIANGLE));
        linguisticValues.add(new LinguisticValue("małej ilości goli", new ArrayList<>(asList(0.0, 40.0, 80.0)), TRIANGLE));
        linguisticValues.add(new LinguisticValue("średnia ilość goli", new LinkedList<>(asList(80.0, 110.0, 140.0)), TRIANGLE));
        linguisticValues.add(new LinguisticValue("dużej ilości goli", new ArrayList<>(asList(140.0, 170.0, 200.0)), TRIANGLE));
        linguisticValues.add(new LinguisticValue("w młodym wieku", new ArrayList<>(asList(1940.0, 1965.0, 1993.0)), TRIANGLE));
        linguisticValues.add(new LinguisticValue("w starszym wieku", new ArrayList<>(asList(1841.0, 1890.0, 1940.0)), TRIANGLE));
        return linguisticValues;
    }
}
