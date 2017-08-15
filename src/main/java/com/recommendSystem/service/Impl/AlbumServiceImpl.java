package com.recommendSystem.service.Impl;

import com.recommendSystem.model.Album;
import com.recommendSystem.repository.AlbumRepository;
import com.recommendSystem.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public void addAlbum(Album album) {
        albumRepository.addAlbum(album);
    }

    @Override
    public Album fetchAlbum(long id) {
        return albumRepository.fetchAlbum(id);
    }
}
