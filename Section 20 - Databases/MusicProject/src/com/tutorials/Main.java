package com.tutorials;

import com.tutorials.model.Artist;
import com.tutorials.model.Datasource;
import com.tutorials.model.SongArtist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Cant open datasource");
        }

        //Print list of artists
//        List<Artist> artists = datasource.queryArtist();
//        if (artists == null) {
//            System.out.println("No artist in list");
//        }
//        for (Artist artist : artists) {
//            System.out.println("ID " + artist.getId() + " Artist name " + artist.getName());
//        }

        System.out.println("___________________________________________________________________");

        //Print albums for artist
        List<String> albums = datasource.queryAlbumsForArtis("Iron Maiden");
        albums.forEach(album -> System.out.println(album));

        System.out.println("___________________________________________________________________");

        //Print list of artist by song name
        String songName = "Go Your Own Way";
        List<SongArtist> songArtists = datasource.queryArtistsForSong(songName);
        if (songArtists == null){
            System.out.println("Cant find that song!");
        }
        songArtists.forEach(song -> System.out.println("Song: " + songName +
                " Artist name " + song.getArtistName() +
                ", Album name " + song.getAlbumName() +
                ", Track " + song.getTrack()));

        System.out.println("___________________________________________________________________");

        //Count number of songs in songs table
        System.out.println("Number of songs is " + datasource.getCount("songs") );

        //Insert song into database

        System.out.println("Inserting song");

            datasource.insertSong("NewSong", "NewArtist", "SomeNewAlbum", 1);









        //close connection
        datasource.close();
    }
}
