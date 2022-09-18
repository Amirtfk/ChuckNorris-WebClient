package com.example.webclientchucknorris.controller;

import com.example.webclientchucknorris.model.ChuckNorrisJokeElement;
import com.example.webclientchucknorris.service.ChuckNorrisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jokes")
public class ChuckNorrisController {

    private ChuckNorrisService service;

    @Autowired
    public ChuckNorrisController(ChuckNorrisService service) {
        this.service = service;
    }

    // Hier müssen wir dann eine Methode abrufen und die atribute in ChuckNorrisElement zurückgeben
    @GetMapping
    public ChuckNorrisJokeElement getRandomJoke(){  // auf der Seite stehet dass man eine Random Joke generieren kann
        return service.getRandomJoke(); // und hier möchten wir eine Methode in Service abrufen
                        // hier erstmal wird rot bei getRandomJoke
                        // Dann kannst du automatisch darüber Hovern und automatisch eine Methode in Service erstellen
    }

    @GetMapping("{query}")
    public List<ChuckNorrisJokeElement> getJokeByQuery(@PathVariable String query) {
        return service.getJokeByQuery(query);
    }

}
