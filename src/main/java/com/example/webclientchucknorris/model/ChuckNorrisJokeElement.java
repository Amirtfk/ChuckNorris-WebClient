package com.example.webclientchucknorris.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuckNorrisJokeElement {

    // Wir möchten jetzt die Atribute aus der Seite https://api.chucknorris.io/ rauskriegen: Also dann
    // Auf der Seite bei Example response: wir sehen dass 4 atribute gibt:
    // 1- "icon_url"  2- "id" 3-"url"  4-"value"

    private String icon_url;
    private String id;
    private String url;
    private String value;

}
