package com.codegym.service;

import com.codegym.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ISongService {
    void save(Song song);

    Page<Song> findAll(Pageable pageable);

    Song findById(int id);

}
