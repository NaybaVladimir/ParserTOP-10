package org.example.kpParserTop.parser.service;

import org.example.kpParserTop.parser.model.Film;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Initialization {

    //переборка и передача на инициализацию
    public List<Film> initCollection(List<Film> listFilm, Elements elements) {
        for (Element el : elements) {
            listFilm.add(initFilm(el));
        }
        return listFilm;
    }

    //Инициализация объекта значениями
    public static Film initFilm(Element el) {
        Film film = new Film();
        String[] yan = (el.select("p.selection-film-item-meta__original-name").text()).split(",");
        film.setPosition(el.select("span.film-item-rating-position__position").text().trim());
        film.setRating((el.select("span.rating__value.rating__value_positive").text()).trim());
        if (yan.length > 1)
            film.setOriginalName(yan[0].trim());
        else
            film.setOriginalName((el.select("p.selection-film-item-meta__name").text()).trim());
        film.setYear(yan[(yan.length) - 1].trim());
        film.setNumberOfPeopleWhoVoted((el.select("span.rating__count").text()).trim());
        film.setDate(new Date());
        return film;
    }
}
