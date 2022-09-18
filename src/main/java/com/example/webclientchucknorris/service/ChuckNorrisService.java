package com.example.webclientchucknorris.service;

import com.example.webclientchucknorris.model.ChuckNorrisJokeElement;
import com.example.webclientchucknorris.model.ChuckNorrisResponseElement;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ChuckNorrisService {

    // WebClient an sich hat 3 Schritte, die wir ablaufen müssen:
    // 1- Wir müssen ein Instanz davon erstellen 2- dann brauchen wir ein Request 3- dann müssen wir das handeln, was wir zurück bekommen

    // erstmal wir initializieren das ding:
    private WebClient client = WebClient.create("https://api.chucknorris.io/jokes"); // Worauf wird er created? (Welche Adresse soll er ansprechen? bzw. wo möchte ich nachher hin? Die Adresse steht auf der Seite in Usage bei Random Joke)
                                                //https://api.chucknorris.io/jokes/random  >> nehmen wir /random raus und in uri drinne packen wir es, weil wir ein Random Joke haben möchte
    public ChuckNorrisJokeElement getRandomJoke() {
        ChuckNorrisJokeElement randomJoke = // Wir bauen hier ein ChuckNorrisJokeElement
                client.get()
                        .uri("/random")
                        .retrieve()
                        .toEntity(ChuckNorrisJokeElement.class)
                        .block()
                        .getBody();
        return randomJoke;
    }


    // In ChuckNorris haben wir ein Free Text Search: https://api.chucknorris.io/jokes/search?query={query}
    // Hier könne wir als beispiel in ChuckNorris Text jeder gewünsche Text z.B water eingeben und wird
    // Automatisch in Text gesucht und die Jokes, die nur water beinhatet rausgibt
    // Wir bekommen eine Liste von ChuckNorris Jokes
    /*public List<ChuckNorrisJokeElement> getJokeByQuery(String query) {
        List<ChuckNorrisJokeElement> jokes =
                client.get()
                        .uri("/search?query="+query)
                        .retrieve()
                        .toEntityList(ChuckNorrisJokeElement.class) // hier toEntity ist eine Liste
                        .block()
                        .getBody();
                return jokes; // so wird null zurückgeben, weil wir wie in ChuckNorris Seite steht
                            // eine Result, die eine Liste beinhaltet absprechen müssen, nicht nur eine Liste
                            // Dann erstellen wir noch eine Classe unter dem Name: ChuckNorrisResponseElement und
                            // ertellen eine Liste aus ChuckNorrisJokeElement, die result heißt
    } */



    public List<ChuckNorrisJokeElement> getJokeByQuery(String query) {
        ChuckNorrisResponseElement responseElement =
                client.get()
                        .uri("/search?query="+query)
                        .retrieve()
                        .toEntity(ChuckNorrisResponseElement.class)
                        .block()
                        .getBody();
        return responseElement.getResult(); // jetzt wenn du >> http://localhost:8080/jokes/water >> als beispiel water eingibst wird nur die Jokes, die water drinnen neinhalten angezeigt
    }


}
