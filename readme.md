# Sandbox Android Application

## Description

L'application Sandbox est une application Android conçue pour présenter des détails sur des personnages et leurs épisodes associés. Cette application utilise Jetpack Compose pour l'interface utilisateur et suit une architecture basée sur MVVM (Model-View-ViewModel).

## Architecture du Projet

### Structure des Packages

- `org.mathieu.sandbox`: Contient les fichiers principaux de l'application.
- `org.mathieu.sandbox.domain`: Contient les modèles de données.
- `org.mathieu.sandbox.ui`: Contient les composants de l'interface utilisateur.
- `org.mathieu.sandbox.ui.screens`: Contient les écrans de l'application.
- `org.mathieu.sandbox.ui.screens.characterdetails`: Contient l'écran des détails du personnage.

### Composants Principaux

#### ViewModel

- `CharacterDetailsViewModel`: Gère la logique de présentation pour l'écran des détails du personnage. Il récupère les données du personnage et les épisodes associés, puis les expose à l'interface utilisateur via un état immuable.
- 
- `EpisodesDetailsViewModel`: Gère la logique de présentation pour l'écran des détails de l'épisode. Il récupère les données de l'épisode et les épisodes associés, puis les expose à l'interface utilisateur via un état immuable.

#### Modèles

- `Character`: Modèle de données représentant un personnage avec des attributs tels que le nom et le prénom. Il contient aussi la liste des épisondes correspondants à ce personnage.

- `Episode`: Modèle de données représentant un épisode avec des attributs tels que l'identifiant, la date et le nom de l'épisode.

#### Écrans

Le dossier écrans contient les fichiers correspondants à tous les écrans à afficher dans l'application.
Chaque dossier écran contient un fichier `Screen.kt` et un fichier `ViewModel.kt`

Exemple:

- `CharacterDetailsScreen`: Écran principal pour afficher les détails d'un personnage. Il initialise le `CharacterDetailsViewModel`, récupère l'état actuel et affiche les informations du personnage et des épisodes.

- `CharacterDerailsViewModel`: Responsable de la gestion de la logique de présentation et de la préparation des données pour l'écran des détails du personnage. Il interagit avec les sources de données (par exemple, les repositories) pour récupérer les informations sur les personnages et leurs épisodes associés. Il expose ces données via des propriétés observables qui sont utilisées par les composants d'interface utilisateur (UI) pour afficher les informations de manière réactive. Le ViewModel est également responsable de la gestion de l'état de l'interface utilisateur, tel que le chargement, les erreurs, et les actions utilisateur.

### Interfaces

Pour récupérer les épisodes et les épisodes par leur ID, une nouvelle interface a été créée :

Afin de récupérer la liste de tous les épisodes et cela sans prendre en compte le personnge en question, on utilise la fonction `flatMap`.
Cette fonction permet de récupérer la liste des épisodes sur chaque personnage et de les fusionner en une seule.

```kotlin
interface EpisodeRepository {
    fun getEpisodeByIdOrNull(id: Int): Episode? {
        for (character in CharacterLocal.characters) {
            val episode = character.episodes.find { it.id == id }
            if (episode != null) {
                return episode
            }
        }
        return null
    }
    
    fun getEpisodes(): List<Episode> {
        return CharacterLocal.characters.flatMap { it.episodes }
    }
}
