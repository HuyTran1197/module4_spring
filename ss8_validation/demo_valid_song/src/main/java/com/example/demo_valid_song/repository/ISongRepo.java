package com.example.demo_valid_song.repository;

import com.example.demo_valid_song.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepo extends JpaRepository<Song,Integer> {
}
