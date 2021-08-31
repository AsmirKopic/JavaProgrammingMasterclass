package com.tutorials.model;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Datasource {
    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\HP\\Desktop\\Java Programms\\MusicProject\\" + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
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

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
                                                '(' + COLUMN_ARTIST_NAME + ") VALUES (?)";
    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS +
                                                '(' + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";
    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
                                                '(' + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM + ") VALUES(?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUM_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";


    private Connection conn;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;


    public boolean open(){
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);

            return true;
        } catch (SQLException e){
            System.out.println("Couldn't open connection." + e.getMessage());
            return false;
        }
    }

    public void close(){
        try{
            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }
            if (insertIntoAlbums != null){
                insertIntoAlbums.close();
            }
            if (insertIntoSongs != null){
                insertIntoSongs.close();
            }
            if (queryArtist != null){
                queryArtist.close();
            }
            if (queryAlbum != null){
                queryAlbum.close();
            }

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

//    public void insertArtist(String name) throws SQLException {
//        String query = "INSERT INTO artists (name) VALUES (?)";
//        try {
//            PreparedStatement myStmt = conn.prepareStatement(query);
//            myStmt.setString(1, name.trim());
//            int res = myStmt.executeUpdate();
//            System.out.println(name.trim() + " added into database.");
//            System.out.println(res + " records inserted.");
//        } catch (SQLException e) {
//            System.out.println("Query failed" + e.getMessage());
//        }
//    }
    private int insertArtist(String name) throws SQLException {

        // Check if artist is already in database
        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();
        if (results.next()) {
            return results.getInt(1);
        } else {
            // if artist is not into database, insert artist
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert artist.");
            }

            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get id from artist");
            }
        }
    }

    private int insertAlbum(String name,int artisId) throws SQLException {

        // Check if artist is already in database
        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();
        if (results.next()) {
            return results.getInt(1);
        } else {
            // if album is not into database, insert album
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artisId);
            int affectedRows = insertIntoAlbums.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert album.");
            }

            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if(generatedKeys.next()){
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get id from album");
            }
        }
    }

}

