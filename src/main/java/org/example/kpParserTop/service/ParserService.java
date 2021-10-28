package org.example.kpParserTop.service;

import org.example.kpParserTop.cache.CacheFilms;
import org.example.kpParserTop.parser.MainPars;
import org.example.kpParserTop.parser.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ParserService {
    @Autowired
    private MainPars work;
    @Autowired
    private CacheFilms cacheFilms;

    //Отдает запрлшенный ТОП-10
    public Map<String, Object> mainListFilm(Map<String, Object> map, String date) {
        List<Film> list = null;

        try {
            list = date.equals("noDate") ? new ArrayList<>() : filmsDate(date).subList(0, 10);

        } catch (Exception e) {
            list = new ArrayList<>();
        }
        map.put("films", list);

        return map;
    }

    //Запускает главный класс отвечающий за парсинг и наполнение бд
    public List<Film> pars() {
        return work.work();

    }

    //Возвращает список фильмов отфильтрованный по дате и сортированный по рейтингу
    public List<Film> filmsDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Comparator<Film> comparator = (o1, o2) -> new BigDecimal(o2.getRating()).compareTo(new BigDecimal(o1.getRating()));
        Date newDate = formatter.parse(date);
        Date dateRating;
        List<Film> resultList = new ArrayList<>();
        for (Film el : cacheFilms.findAll()) {
            dateRating = formatter.parse(formatter.format(el.getDate()));
            if (dateRating.equals(newDate))
                resultList.add(el);
        }
        resultList.sort(comparator);
        return resultList;

    }

}
