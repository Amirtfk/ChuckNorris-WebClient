package com.example.webclientchucknorris.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuckNorrisResponseElement {
    private List<ChuckNorrisJokeElement> result; // muss genau wie auf der Seite geschrieben werden

}
