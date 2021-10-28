package org.example.kpParserTop.control;

import org.example.kpParserTop.parser.model.Film;
import org.example.kpParserTop.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pars/kp")
public class ContrRest {
    @Autowired
    private ParserService parserService;

    // стартует процесс парсинга и сохранения в бд, отдает результат работы
    @GetMapping()
    public List<Film> point() {

        return parserService.pars();
    }
}
