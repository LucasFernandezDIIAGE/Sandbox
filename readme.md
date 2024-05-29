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

- `CharacterDetailsScreen`: Écran principal pour afficher les détails d'un personnage. Il initialise le `CharacterDetailsViewModel`, récupère l'état actuel et affiche les informations du personnage et des épisodes.

- `EpisodeCard`: Composant UI qui représente une carte d'épisode. Chaque carte peut être cliquée pour naviguer vers l'écran de détails de l'épisode et jouer un son aléatoire.

### Interfaces

Pour récupérer les épisodes et les épisodes par leur ID, une nouvelle interface a été créée :

```kotlin
interface EpisodeRepository {
    fun getEpisodes(): List<Episode>
    fun getEpisodeById(id: Int): Episode?
}
