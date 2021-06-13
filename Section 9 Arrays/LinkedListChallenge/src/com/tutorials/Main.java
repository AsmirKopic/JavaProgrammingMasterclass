package com.tutorials;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Album> albums = new ArrayList<Album>();
    public static void main(String[] args) {

    Album album = new Album("Some random album", "SomeArtist");
    album.addSong("Track 1", 4.55);
    album.addSong("Track 2", 4.77);
    album.addSong("Track 3", 5.34);
    album.addSong("Track 4", 2.55);
    album.addSong("Track 5", 5.67);
    album.addSong("Track 6", 3.65);
    album.addSong("Track 7", 4.57);
    albums.add(album);

    album = new Album("New Album", "NewRandomArtist");
    album.addSong("Track 08", 2.55);
    album.addSong("Track 09", 5.67);
    album.addSong("Track 10", 3.65);
    album.addSong("Track 11", 4.57);
    albums.add(album);

    LinkedList<Song> playList = new LinkedList<Song>();
    albums.get(0).addToPlaylist("Track 1", playList);
    albums.get(0).addToPlaylist("Track 8", playList);
    albums.get(0).addToPlaylist("Track 25", playList);  // Does not exist
    albums.get(1).addToPlaylist(9, playList);
    albums.get(1).addToPlaylist(8, playList);
    albums.get(1).addToPlaylist(3, playList);
    albums.get(1).addToPlaylist(34, playList);  // Does not exist



    play(playList);


    }
    public static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0){
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            // adding case functions
            switch (action){
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:





            }
        }

    }

}
