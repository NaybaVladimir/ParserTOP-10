package org.example.kpParserTop.cache;

import org.example.kpParserTop.parser.model.Film;
import org.example.kpParserTop.repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

//Кэш-слой
@Service
public class CacheFilms {

    @Autowired
    private FilmRepo filmRepo;

    //Возвращает список фильмов
    @Cacheable(cacheNames = "filmsCache")
    public List<Film> findAll() {
        return filmRepo.findAll();
    }

    //Обновляет Кэш
    @CachePut(cacheNames = "filmsCache")
    public List<Film> putCache() {
        return findAll();
    }

    //Сохраняет один фильм в БД
    public void save(Film film) {
        filmRepo.save(film);
    }

}
