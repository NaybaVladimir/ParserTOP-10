package org.example.kpParserTop.control;

import org.example.kpParserTop.service.ParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping
public class Contr {
    @Autowired
    private ParserService parserService;

    //Эндпоинт отдает одно единственное представление
    @GetMapping
    public String main(Map<String, Object> map,
                       @RequestParam(name = "dr", defaultValue = "noDate") String date) {
        map = parserService.mainListFilm(map, date);
        return "main";

    }
}
