package com.recommendSystem.repository;

import com.recommendSystem.model.Song;
import com.recommendSystem.model.User;

import java.util.List;

public interface SongRepository {

    void addSong(Song song);

    Song fetchSong(long id);

    void updateSong(Song song);

    List<Song> getAllSongs(User user);

}
