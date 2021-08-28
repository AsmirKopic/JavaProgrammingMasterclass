package com.tutorials;

import com.tutorials.model.Artist;
import com.tutorials.model.Datasource;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Cant open datasource");
        }

        List<Artist> artists = datasource.queryArtist();
        if (artists == null) {
            System.out.println("No artist in list");
        }

        for (Artist artist : artists) {
            System.out.println("ID " + artist.getId() + " Artist name " + artist.getName());
        }

        System.out.println(" //////////////////////////////////////////");

        List<String> albums = datasource.queryAlbumsForArtis("Iron Maiden");
        for (String album : albums){
            System.out.println( " > " + album);
        }

        datasource.close();
    }
}
