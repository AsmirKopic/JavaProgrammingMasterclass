package com.tutorials;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }
   public boolean add(T team){
        if (league.contains(team)){
            System.out.println(team.getName() + " is already in league.");
            return false;
        } else {
            league.add(team);
            System.out.println(team.getName() + " added to team");
            return true;
        }
   }
   public void showLeagueTable(){
       Collections.sort(league);
       for (T t : league){
           System.out.println(t.getName() + " : " + t.ranking());
       }
   }
}
