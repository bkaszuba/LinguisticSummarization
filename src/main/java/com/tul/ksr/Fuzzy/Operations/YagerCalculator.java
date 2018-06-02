package com.tul.ksr.Fuzzy.Operations;

import com.tul.ksr.Fuzzy.Functions.TriangularFunction;
import com.tul.ksr.Model.LinguisticValue;
import com.tul.ksr.Model.Player;
import com.tul.ksr.Model.Quantifier;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class YagerCalculator {
    List<Quantifier> quantifiers;
    List<LinguisticValue> linguisticValues;
    List<Player> players;

    public YagerCalculator(List<Quantifier> quantifier, List<LinguisticValue> linguisticValue, List<Player> players) {
        this.quantifiers = quantifier;
        this.linguisticValues = linguisticValue;
        this.players = players;
    }

    public void calculateYager() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (Quantifier quantifier : quantifiers) {
            for (LinguisticValue linguisticValue : linguisticValues) {
                calculateYagerForEachLinguisticValue(quantifier, linguisticValue);
            }
        }
    }

    private void calculateYagerForEachLinguisticValue(Quantifier quantifier, LinguisticValue linguisticValue) throws InvocationTargetException, IllegalAccessException {
        System.out.print(quantifier.getDescription() + " ");
        System.out.print(linguisticValue.getDescription() + " ");
        TriangularFunction triangularFunctionQuantifiers = new TriangularFunction(quantifier.getPoints());
        TriangularFunction triangularFunctionLinguisticValues = new TriangularFunction(linguisticValue.getPoints());
        double cardinalValue = 0.0;
        for (Player player : players) {
            cardinalValue += getMembershipValue(triangularFunctionLinguisticValues, player, linguisticValue);
        }
        System.out.printf("%.2f", cardinalValue);
        System.out.print(" ");
        System.out.printf("%.2f", triangularFunctionQuantifiers.getMembership(cardinalValue));
        System.out.println();
    }

    private double getMembershipValue(TriangularFunction triangularFunctionLinguisticValues, Player player, LinguisticValue linguisticValue) throws InvocationTargetException, IllegalAccessException {
        return triangularFunctionLinguisticValues.getMembership(getValue(player, linguisticValue));
    }

    private int getValue(Player player, LinguisticValue linguisticValue) throws InvocationTargetException, IllegalAccessException {
        return (int) linguisticValue.getMethod().invoke(player);
    }
}
