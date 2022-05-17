package com.codegym.service.impl;

import com.codegym.model.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;
    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Page<Song> findAll(Pageable pageable) {
        return iSongRepository.findAll(pageable);
    }

    @Override
    public Song findById(int id) {
        return iSongRepository.findById(id).orElse(null);
    }



}
