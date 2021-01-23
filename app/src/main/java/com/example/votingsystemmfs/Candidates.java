package com.example.votingsystemmfs;

public class Candidates {
    private String position_NM;
    private String candidate_NM;
    private String start_TM;
    private String end_TM;
    private int id;


    public int getId(int anInt) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition_NM(String string) {
        return position_NM;
    }

    public void setPosition_NM(String position_NM) {
        this.position_NM = position_NM;
    }

    public String getCandidate_NM() {
        return candidate_NM;
    }

    public void setCandidate_NM(String candidate_NM) {
        this.candidate_NM = candidate_NM;
    }

    public String getStart_TM() {
        return start_TM;
    }

    public void setStart_TM(String start_TM) {
        this.start_TM = start_TM;
    }

    public String getEnd_TM() {
        return end_TM;
    }

    public void setEnd_TM(String end_TM) {
        this.end_TM = end_TM;
    }
}
