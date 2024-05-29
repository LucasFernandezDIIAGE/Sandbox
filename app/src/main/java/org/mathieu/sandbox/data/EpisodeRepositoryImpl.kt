package org.mathieu.sandbox.data

import org.mathieu.sandbox.domain.models.Episode

object EpisodeRepositoryImpl {

    /**
     * Try to retrieve an episode, using its id. If there is no episode found, then it returns null.
     *
     * @param id The id of the episode that we are looking for
     * @return It returns either a [Episode] or null if not found.
     */
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