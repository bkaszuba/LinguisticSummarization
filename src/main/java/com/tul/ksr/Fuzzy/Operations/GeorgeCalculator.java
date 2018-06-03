package com.tul.ksr.Fuzzy.Operations;

import com.tul.ksr.Fuzzy.Functions.TriangularFunction;
import com.tul.ksr.Model.LinguisticValue;
import com.tul.ksr.Model.Player;
import com.tul.ksr.Model.Quantifier;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static com.tul.ksr.Model.DataUtils.QuantifierType.RELATIVE;

public class GeorgeCalculator {
    List<Quantifier> quantifiers;
    List<LinguisticValue> linguisticValues;
    List<Player> players;

    public GeorgeCalculator(List<Quantifier> quantifier, List<LinguisticValue> linguisticValue, List<Player> players) {
        this.quantifiers = quantifier;
        this.linguisticValues = linguisticValue;
        this.players = players;
    }

    public void calculateGeorge() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        for (Quantifier quantifier : quantifiers) {
            System.out.print(quantifier.getDescription() + " jest ");
            for (LinguisticValue linguisticValue : linguisticValues) {
                System.out.print(linguisticValue.getDescription() + " ");
            }
            TriangularFunction triangularFunctionQuantifiers = new TriangularFunction(quantifier.getPoints());
            double cardinalValue = 0.0;
            for (Player player : players) {
                cardinalValue += calculateGeorgeForEachPlayer(player);
            }
            if (quantifier.getQuantifierType().equals(RELATIVE)) {
                System.out.printf("%.2f", triangularFunctionQuantifiers.getMembership(cardinalValue / players.size()));
            } else {
                System.out.printf("%.2f", triangularFunctionQuantifiers.getMembership(cardinalValue));
            }
            System.out.println();
        }
    }

    private double calculateGeorgeForEachPlayer(Player player) throws InvocationTargetException, IllegalAccessException {
        double minValue = 0.0;
        for (LinguisticValue linguisticValue : linguisticValues) {
            TriangularFunction triangularFunctionLinguisticValues = new TriangularFunction(linguisticValue.getPoints());
            if (getMembershipValue(triangularFunctionLinguisticValues, player, linguisticValue) < minValue) {
                minValue = getMembershipValue(triangularFunctionLinguisticValues, player, linguisticValue);
            }
        }
        return minValue;
    }

    private double getMembershipValue(TriangularFunction triangularFunctionLinguisticValues, Player player, LinguisticValue linguisticValue) throws InvocationTargetException, IllegalAccessException {
        return triangularFunctionLinguisticValues.getMembership(getValue(player, linguisticValue));
    }

    private int getValue(Player player, LinguisticValue linguisticValue) throws InvocationTargetException, IllegalAccessException {
        return (int) linguisticValue.getMethod().invoke(player);
    }
}
