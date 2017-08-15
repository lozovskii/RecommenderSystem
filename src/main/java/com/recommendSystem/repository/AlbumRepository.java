package com.recommendSystem.repository;

import com.recommendSystem.model.Album;

public interface AlbumRepository {

    void addAlbum(Album album);

    Album fetchAlbum(long id);

}
