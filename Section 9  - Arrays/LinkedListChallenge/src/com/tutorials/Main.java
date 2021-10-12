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
    albums.get(0).addToPlaylist("Track 3", playList);
    albums.get(0).addToPlaylist("Track 25", playList);  // Does not exist
    albums.get(1).addToPlaylist(1, playList);
    albums.get(1).addToPlaylist(4, playList);
    albums.get(1).addToPlaylist(6, playList);
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
            printMenu();

        }
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist completed.");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We reached end of the playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                            forward = false;
                        }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of playlist");
                        forward = true;
                    }
                     break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                        }
                    else {
                        if(listIterator.hasNext()){
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list.");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                case 6:
                    if (playlist.size() > 0){
                        listIterator.remove();
                    } if (listIterator.hasNext()){
                    System.out.println("Now playing " + listIterator.next());
                } else if(listIterator.hasPrevious()){
                    System.out.println("Now playing " + listIterator.previous());
                }
                break;
            }
        }
    }
    private static void printList(LinkedList<Song> playlist){
        for (Song song: playlist) {
            System.out.println(song);
        }
    }
    private static void printMenu(){
        System.out.println("Available actions \nPress " +
                        "0 - to Quit\n" +
                        "1 - to play next song\n" +
                        "2 - to play previous song\n" +
                        "3 - to reply the current song\n" +
                        "4 - list songs in the playlist\n" +
                        "5 - print menu\n" +
                        "6 - delete current song from playlist.");
    }

}
