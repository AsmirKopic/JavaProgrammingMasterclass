package com.tutorials;

public class Main {

    public static void main(String[] args) {

        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootballPlayer> adelaide = new Team<>("Adelaide");

        adelaide.addPlayer(joe);
//        adelaide.addPlayer(pat);
//        adelaide.addPlayer(beckham);
        

    }
}
