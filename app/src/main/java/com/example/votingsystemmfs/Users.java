package com.example.votingsystemmfs;

public class Users {
    private int userId;
    private String voter_NM;
    private int vote;

    public int getUserId(int anInt) {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVoter_NM(String string) {
        return voter_NM;
    }

    public void setVoter_NM(String voter_NM) {
        this.voter_NM = voter_NM;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
