package com.tul.ksr.Fuzzy.Operations;

import com.tul.ksr.Fuzzy.Functions.FuzzyFunction;
import com.tul.ksr.Fuzzy.Functions.TriangularFunction;
import com.tul.ksr.Model.LinguisticValue;
import com.tul.ksr.Model.Player;
import com.tul.ksr.Model.Quantifier;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaszuba on 05.06.2018.
 */
public class QualityMeasures {
    private List<LinguisticValue> linguisticValues;
    private List<Quantifier> quantifiers;
    private List<Player> players;

    public QualityMeasures(List<LinguisticValue> linguisticValues, List<Quantifier> quantifiers, List<Player> players) {
        this.linguisticValues = linguisticValues;
        this.quantifiers = quantifiers;
        this.players = players;
    }

    public void T1() {
        for (LinguisticValue linguisticValue: linguisticValues) {
            double cardinalNumber = getCardinalNumber(linguisticValue);
            SummarizationAnswer finalAnswer = new SummarizationAnswer("test", 0.0);
            for (Quantifier quantifier : quantifiers) {
                String sentence  = quantifier.getDescription() + " players " + linguisticValue.getDescription();
                Double precision = quantifier.getFuzzyFunction().getMembership(cardinalNumber / players.size());
                SummarizationAnswer answer = new SummarizationAnswer(sentence, precision);
                if(answer.getQuality() > finalAnswer.getQuality()) {
                    finalAnswer = answer;
                }
            }
            System.out.println(finalAnswer);
        }
    }

    //Cardinal number of linguistic value
    private double getCardinalNumber(LinguisticValue linguisticValue) {
        double cardinalNumber = 0;
        for (Player player: this.players) {
            double value = getMembershipValue(linguisticValue, player);
            if(value > 0)
                cardinalNumber += value;
        }
        return cardinalNumber;
    }

    private double getMembershipValue(LinguisticValue linguisticValue, Player player) {
        return linguisticValue.getFuzzyFunction().getMembership(getValue(player, linguisticValue));
    }

    private int getValue(Player player, LinguisticValue linguisticValue) {
        try {
            return (int) linguisticValue.getMethod().invoke(player);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return 0;
    }
}


