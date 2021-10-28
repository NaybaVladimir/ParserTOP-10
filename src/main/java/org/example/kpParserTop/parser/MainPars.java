package org.example.kpParserTop.parser;

import org.example.kpParserTop.cache.CacheFilms;
import org.example.kpParserTop.parser.model.Film;
import org.example.kpParserTop.parser.service.Initialization;
import org.example.kpParserTop.parser.service.ReadUrl;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*Управляющий Класс.
 * Стартует получение html разметки
 * Стартует инициализацию объектов и списка объектов
 * Сохраняет объекты в БД
 * Обновляет КЭШ*/
@Service
public class MainPars {
    @Autowired
    private Initialization initialization;
    @Autowired
    private ReadUrl readUrl;
    @Autowired
    private CacheFilms cacheFilms;

    //Исполняющий метод
    public List<Film> work() {
        List<Film> listFilms = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Elements elements = readUrl.read("https://www.kinopoisk.ru/lists/top250/?page=" + i + "&tab=all");
            listFilms = initialization.initCollection(listFilms, elements);
        }
        for (Film el : listFilms) {
            cacheFilms.save(el);
        }
        cacheFilms.putCache();
        return listFilms;
    }
}
