package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Character
import org.mathieu.sandbox.domain.models.Episode

object CharacterLocal {
    var characters: MutableList<Character> = mutableListOf(
        Character(
            id = 1,
            firstName = "John",
            lastName = "Snow",
            age = 20,
            episodes = listOf(
                Episode(id = 1, date = "29/05/2024", name = "Game of thrones 1"),
                Episode(id = 2, date = "29/05/2024", name = "Game of thrones 2"),
                Episode(id = 3, date = "29/05/2024", name = "Game of thrones 3"),
                Episode(id = 4, date = "29/05/2024", name = "Game of thrones 4")
            )
        ),
        Character(
            id = 2,
            firstName = "Jack",
            lastName = "Sparrow",
            age = 21,
            episodes = listOf(
                Episode(id = 5, date = "29/05/2024", name = "Pirate des Caraïbes 1"),
                Episode(id = 6, date = "29/05/2024", name = "Pirate des Caraïbes 2"),
                Episode(id = 7, date = "29/05/2024", name = "Pirate des Caraïbes 3")
            )
        ),
        Character(
            id = 3,
            firstName = "Perceval",
            lastName = "De Galles",
            age = 22,
            episodes = listOf(
                Episode(id = 8, date = "29/05/2024", name = "Kaamelott Livre 2"),
                Episode(id = 9, date = "29/05/2024", name = "Kaamelott Livre 3"),
                Episode(id = 10, date = "29/05/2024", name = "Kaamelott Livre 4")
            )
        )
    )
}
