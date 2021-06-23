package com.tutorials;

import java.util.ArrayList;

public class Team<T extends Player> {
    private String name;
    int won = 0;
    int lose = 0;
    int tied = 0;
    int played = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player){
        if (members.contains(player)){
            System.out.println(player.getName() + " is already in this team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }
    public int numPlayers(){
        return this.members.size();
    }
    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if (ourScore > theirScore){
            message = " beat ";
            won++;
        } else if (theirScore == ourScore){
            message = " drew with ";
            tied++;
        } else{
            message =" lose to ";
            lose++;
        }
        played ++;
        if (opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null,theirScore, ourScore);
        }
    }
    public int ranking(){
        return (won * 2) + tied;
    }




}
