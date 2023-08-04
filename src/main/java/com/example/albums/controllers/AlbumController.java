package com.example.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.albums.models.Album;
import com.example.albums.services.AlbumService;

@RestController
@RequestMapping("/api")
public class AlbumController {
        @Autowired
        AlbumService albumService;
        
        @RequestMapping(value="/albums", method=RequestMethod.POST)
        public Album createAlbum(@RequestBody Album album) {
            return albumService.createAlbum(album);
        }
        
        @RequestMapping(value="/albums", method=RequestMethod.GET)
        public List<Album> listAlbums() {
            return albumService.getAlbums();
        }

        @RequestMapping(value="/albums/{albumId}", method=RequestMethod.PUT)
        public Album readAlbum(@PathVariable(value = "albumId") Long id, @RequestBody Album albumDetails) {
            return albumService.updateAlbum(id, albumDetails);
        }

        @RequestMapping(value="/albums/{albumId}", method=RequestMethod.DELETE)
        public void deleteAlbum(@PathVariable(value = "albumId") Long id) {
            albumService.deleteAlbum(id);
        }



}