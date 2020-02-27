package id.putraprima.skorbola.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Model implements Parcelable {

    private String homeName;
    private String awayName;
    private int homeScore;
    private int awayScore;
    private String winner;
    private String [] homeScorer;
    private String [] awayScorer;

    public Model(String homeName, String awayName) {
        this.homeName = homeName;
        this.awayName = awayName;
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
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String[] getHomeScorer() {
        return homeScorer;
    }

    public void setHomeScorer(String[] homeScorer) {
        this.homeScorer = homeScorer;
    }

    public String[] getAwayScorer() {
        return awayScorer;
    }

    public void setAwayScorer(String[] awayScorer) {
        this.awayScorer = awayScorer;
    }

    protected Model(Parcel in) {
        homeName = in.readString();
        awayName = in.readString();
        homeScore = in.readInt();
        awayScore = in.readInt();
        winner = in.readString();
        homeScorer = in.createStringArray();
        awayScorer = in.createStringArray();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(homeName);
        dest.writeString(awayName);
        dest.writeInt(homeScore);
        dest.writeInt(awayScore);
        dest.writeString(winner);
        dest.writeStringArray(homeScorer);
        dest.writeStringArray(awayScorer);
    }

    @Override
    public int describeContents() {
        return 0;
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
}
