package com.tutorials.model;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\HP\\Desktop\\Java Programms\\MusicProject\\" + DB_NAME;

    public static final String TABLE_ALBUM = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final String COLUMN_ARTIST_ID = "_id";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";

    private Connection conn;
    public boolean open(){
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e){
            System.out.println("Couldn't open connection." + e.getMessage());
            return false;
        }
    }

    public void close(){
        try{
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e){
            System.out.println("Couldn't close connection" + e.getMessage());
        }
    }

    public List<Artist> queryArtist(){

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS)){

            List<Artist> artists = new ArrayList<>();
            while (results.next()){
                Artist artist = new Artist();
                artist.setId(results.getInt(COLUMN_ARTIST_ID));
                artist.setName(results.getString(COLUMN_ARTIST_NAME));
                artists.add(artist);
            }
            return artists;

        } catch (SQLException e){
            System.out.println("Query failed " + e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbumsForArtis(String artist){

        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT albums.name FROM albums \n" +
                    "INNER JOIN artists ON albums.artist = artists._id \n" +
                    "WHERE artists.name = \"" + artist + "\" \n" +
                    "ORDER BY albums.name COLLATE NOCASE ASC")) {

            List<String> albums = new ArrayList<>();
            while (results.next()){
                albums.add(results.getString(1));
            }
            return albums;
        } catch (SQLException e){
            System.out.println("Query failed " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<SongArtist> queryArtistsForSong(String songName){
        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT artists.name, albums.name, songs.track FROM songs \n" +
                    "INNER JOIN albums ON songs.album = albums._id \n" +
                    "INNER JOIN artists ON albums.artist = artists._id\n" +
                    "WHERE songs.title = \"" + songName +"\"\n" +
                    "ORDER BY artists.name, albums.name COLLATE NOCASE ASC")) {
            List<SongArtist> songs = new ArrayList<>();
            while (results.next()){
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songs.add(songArtist);
            }
            return songs;
        } catch (SQLException e){
            System.out.println("Query failed " + e.getMessage());
            return null;
        }
    }

    public int getCount(String table){
        String sql = "SELECT COUNT(*) FROM " + table;
        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(sql)) {
            int count = results.getInt(1);
            return count;
        } catch (SQLException e){
            System.out.println("Query failed " + e.getMessage());
            return -1;
        }
    }




}

