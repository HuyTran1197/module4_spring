package com.example.demo_valid_song.service;

import com.example.demo_valid_song.entity.Song;
import com.example.demo_valid_song.repository.ISongRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    private ISongRepo songRepo;

    public SongService(ISongRepo songRepo) {
        this.songRepo = songRepo;
    }

    @Override
    public List<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public boolean save(Song song) {
        try {
            songRepo.save(song);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Song findById(int id) {
        return songRepo.findById(id).orElse(null);
    }
}
