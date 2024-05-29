package org.mathieu.sandbox.domain.repositories

import org.mathieu.sandbox.domain.models.Episode

interface IEpisodeRepository {

    /**
     * Try to retrieve a character, using its id. If there is no character found, then it returns null.
     *
     * @param id The id of the character that we are looking for
     * @return It returns either a [Episode] or null if not found.
     */
    fun getEpisodeByIdOrNull(id: Int): Episode?

    fun getEpisodes(): List<Episode>
}