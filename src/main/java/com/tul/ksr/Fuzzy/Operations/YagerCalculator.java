package com.tul.ksr.Fuzzy.Operations;

import com.tul.ksr.Fuzzy.Functions.TriangularFunction;
import com.tul.ksr.Model.LinguisticValue;
import com.tul.ksr.Model.Player;
import com.tul.ksr.Model.Quantifier;

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

    public double calculateYager() {
        //FIXME Tutaj jest przykład jak to działa, potem ogarnę, żeby był uniwersalny
        double result = 0.0;
        System.out.println(quantifier.getDescription());
        System.out.println(linguisticValue.getDescription());
        TriangularFunction triangularFunctionQuantifiers = new TriangularFunction(quantifier.getPoints());
        TriangularFunction triangularFunctionLinguisticValues = new TriangularFunction(linguisticValue.getPoints());
        Double cardinalValue = players.stream()
                .map(Player::getHeight)
                .map(player -> triangularFunctionLinguisticValues.getMembership(player))
                .reduce(0.0, Double::sum);
        triangularFunctionQuantifiers.getMembership(cardinalValue);
        System.out.println(triangularFunctionQuantifiers.getMembership(cardinalValue));
        return result;
    }
}
