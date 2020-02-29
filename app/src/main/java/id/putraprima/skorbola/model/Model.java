package id.putraprima.skorbola.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Model implements Parcelable {

    private String homeName;
    private String awayName;
    private int homeScore=0;
    private int awayScore=0;
    private String winner;
    private ArrayList<String> homeScorer = new ArrayList<>();
    private ArrayList<String> awayScorer = new ArrayList<>();
    private String result = "";

    public Model(String homeName, String awayName) {
        this.homeName = homeName;
        this.awayName = awayName;
    }

    public void addHomeScore(String name, String time){
        homeScorer.add(name+", "+time+"'");
        homeScore++;
    }

    public void addAwayScore(String name, String time){
        awayScorer.add(name+", "+time+"'");
        awayScore++;
    }



    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getWinner() {

        if(homeScore > awayScore){
            return homeName;
        }
        else if( homeScore < awayScore){
            return awayName;
        }
        else{
            return "draw";
        }
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public ArrayList<String> getHomeScorer() {
        return homeScorer;
    }

    public void setHomeScorer(ArrayList<String> homeScorer) {
        this.homeScorer = homeScorer;
    }

    public ArrayList<String> getAwayScorer() {
        return awayScorer;
    }

    public void setAwayScorer(ArrayList<String> awayScorer) {
        this.awayScorer = awayScorer;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    protected Model(Parcel in) {
        homeName = in.readString();
        awayName = in.readString();
        homeScore = in.readInt();
        awayScore = in.readInt();
        winner = in.readString();
        homeScorer = in.createStringArrayList();
        awayScorer = in.createStringArrayList();
        result = in.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(homeName);
        parcel.writeString(awayName);
        parcel.writeInt(homeScore);
        parcel.writeInt(awayScore);
        parcel.writeString(winner);
        parcel.writeStringList(homeScorer);
        parcel.writeStringList(awayScorer);
        parcel.writeString(result);
    }
}
