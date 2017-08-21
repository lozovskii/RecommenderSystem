package com.recommendSystem.service;

import com.recommendSystem.model.Song;
import com.recommendSystem.model.User;

import java.util.List;

public interface SongService {

    void addSong(Song song);

    Song fetchSong(long id);

    List<Song> getListSongParseXML(String path);

    void updateSong(Song song);

    List<Song> getAllSongs(User user);

}