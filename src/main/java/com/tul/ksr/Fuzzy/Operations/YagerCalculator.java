package com.tul.ksr.Fuzzy.Operations;

import com.tul.ksr.Fuzzy.Functions.TriangularFunction;
import com.tul.ksr.Model.LinguisticValue;
import com.tul.ksr.Model.Player;
import com.tul.ksr.Model.Quantifier;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class YagerCalculator {
    Quantifier quantifier;
    LinguisticValue linguisticValue;
    List<Player> players;

    public YagerCalculator(Quantifier quantifier, LinguisticValue linguisticValue, List<Player> players) {
        this.quantifier = quantifier;
        this.linguisticValue = linguisticValue;
        this.players = players;
    }

    public double calculateYager() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println(quantifier.getDescription());
        System.out.println(linguisticValue.getDescription());
        TriangularFunction triangularFunctionQuantifiers = new TriangularFunction(quantifier.getPoints());
        TriangularFunction triangularFunctionLinguisticValues = new TriangularFunction(linguisticValue.getPoints());
        double cardinalValue = 0.0;
        for (Player player : players) {
            cardinalValue += getMembershipValue(triangularFunctionLinguisticValues, player);
        }
        System.out.println(cardinalValue);
        System.out.println(triangularFunctionQuantifiers.getMembership(cardinalValue));
        return triangularFunctionQuantifiers.getMembership(cardinalValue);
    }

    private double getMembershipValue(TriangularFunction triangularFunctionLinguisticValues, Player player) throws InvocationTargetException, IllegalAccessException {
        return triangularFunctionLinguisticValues.getMembership(getValue(player));
    }

    private int getValue(Player player) throws InvocationTargetException, IllegalAccessException {
        return (int) linguisticValue.getMethod().invoke(player);
    }
}
