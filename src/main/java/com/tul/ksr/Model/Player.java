package com.tul.ksr.Model;

import com.opencsv.bean.CsvBindByName;

public class Player {
    @CsvBindByName
    int height;
    @CsvBindByName
    int weight;
    @CsvBindByName
    int firstNHL;
    @CsvBindByName
    int lastNHL;
    @CsvBindByName
    int birthYear;
    @CsvBindByName
    int birthMon;
    @CsvBindByName
    int birthDay;
    @CsvBindByName
    int deathYear;
    @CsvBindByName
    int goals;

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getFirstNHL() {
        return firstNHL;
    }

    public int getLastNHL() {
        return lastNHL;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getBirthMon() {
        return birthMon;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public int getGoals() {
        return goals;
    }
}
