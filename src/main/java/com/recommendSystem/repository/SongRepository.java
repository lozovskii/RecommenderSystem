package com.recommendSystem.repository;

import com.recommendSystem.model.Song;

public interface SongRepository {

    void addSong(Song song);

    Song fetchSong(long id);

    void updateSong(Song song);

}
