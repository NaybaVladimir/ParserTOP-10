package org.example.kpParserTop.parser.service;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ReadUrl {
    public ReadUrl() {
    }

    //считывание html  разметки разметки
    public Elements read(String url) {

        try {
            return (Jsoup
                    .connect(url)
                    .get()).select("div.desktop-rating-selection-film-item");
        } catch (IOException e) {
            return null;
        }


    }
}
