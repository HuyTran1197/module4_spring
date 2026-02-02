package com.example.demo_valid_song.service;

import com.example.demo_valid_song.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    boolean save(Song song);
    Song findById(int id);
}
