package com.recommendSystem.service;

import com.recommendSystem.model.Album;

public interface AlbumService {

    void addAlbum(Album album);

    Album fetchAlbum(long id);

}
