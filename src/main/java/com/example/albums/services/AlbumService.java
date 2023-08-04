package com.example.albums.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.albums.models.Album;
import com.example.albums.repositories.AlbumRepository;
import java.util.List;

@Service
public class AlbumService {

        @Autowired
            AlbumRepository albumRepository;     
        
     // CREATE 
        public Album createAlbum(Album album) {
            return albumRepository.save(album);
        }

        // READ
        public List<Album> getAlbums() {
            return albumRepository.findAll();
        }
        
     // UPDATE
        public Album updateAlbum(Long albumId, Album albumDetails) {
                Album album = albumRepository.findById(albumId).get();
                album.setTitle(albumDetails.getTitle());
                album.setArtist(albumDetails.getArtist());
                album.setGenre(albumDetails.getGenre());
                
                return albumRepository.save(album);                                
        }

        // DELETE
        public void deleteAlbum(Long albumId) {
            albumRepository.deleteById(albumId);
        }
}

