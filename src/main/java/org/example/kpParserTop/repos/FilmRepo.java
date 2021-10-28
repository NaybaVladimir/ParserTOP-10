package org.example.kpParserTop.repos;

import org.example.kpParserTop.parser.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

//Репозиторий
public interface FilmRepo extends JpaRepository<Film, Long> {

}
