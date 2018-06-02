package com.tul.ksr.Model;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class DataParser {
    public static List<Player> createPlayerList() throws IOException {
        return new CsvToBeanBuilder(new FileReader("resources/Master.csv"))
                .withType(Player.class).build().parse();
    }
}
