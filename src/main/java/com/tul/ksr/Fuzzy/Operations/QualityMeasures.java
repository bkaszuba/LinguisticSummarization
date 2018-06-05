package com.tul.ksr.Fuzzy.Operations;

import com.tul.ksr.Model.LinguisticValue;
import com.tul.ksr.Model.Player;
import com.tul.ksr.Model.Quantifier;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by Kaszuba on 05.06.2018.
 */
public class QualityMeasures {
    private List<LinguisticValue> linguisticValues;
    private List<Quantifier> quantifiers;
    private List<Player> players;
    private Map<String, Double> answers;
    private double[] weights;

    public QualityMeasures(List<LinguisticValue> linguisticValues, List<Quantifier> quantifiers, List<Player> players) {
        this.linguisticValues = linguisticValues;
        this.quantifiers = quantifiers;
        this.players = players;
        this.answers = new HashMap<>();
        weights = new double[] {1};
    }

    public void getQuality() {
        for (LinguisticValue linguisticValue : linguisticValues) {
            answers.clear();
            for (Quantifier quantifier : quantifiers) {
                String sentence = quantifier.getDescription() + " players " + linguisticValue.getDescription();
                answers.put(sentence, getAllQualityMeasuresValue(linguisticValue, quantifier));
                System.out.println(sentence + " [" + getAllQualityMeasuresValue(linguisticValue, quantifier) + "]");
            }
            getBestAnswer();
        }

    }

    //TODO add all T1-T11 to this function
    private double getAllQualityMeasuresValue(LinguisticValue linguisticValue, Quantifier quantifier) {
        return T1(linguisticValue, quantifier) * weights[0];
    }

    private double T1(LinguisticValue linguisticValue, Quantifier quantifier) {
        double cardinalNumber = getCardinalNumber(linguisticValue);
        return quantifier.getFuzzyFunction().getMembership(cardinalNumber / players.size());

    }

    //Cardinal number of linguistic value
    private double getCardinalNumber(LinguisticValue linguisticValue) {
        double cardinalNumber = 0;
        for (Player player : this.players) {
            double value = getMembershipValue(linguisticValue, player);
            if (value > 0)
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

    public void getBestAnswer() {
        System.out.println("===================================");
        Map.Entry<String, Double> hi =
                Collections.max(answers.entrySet(), new Comparator<Map.Entry<String, Double>> () {
                    public int compare(Map.Entry<String, Double> e1, Map.Entry<String, Double>  e2) {
                        return e1.getValue().compareTo(e2.getValue());
                    }
                });
        System.out.println(hi.getKey() + " [" + hi.getValue() + "]");
        System.out.println("");
    }

}


