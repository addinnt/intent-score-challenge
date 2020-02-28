package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.putraprima.skorbola.model.Model;

public class MatchActivity extends AppCompatActivity {
    private TextView homeName;
    private TextView awayName;
    private TextView homeScore;
    private TextView awayScore;
    private TextView homeScorer;
    private TextView awayScorer;
    private ImageView homeLogo;
    private  ImageView awayLogo;
    private int home_score =0;
    private int away_score =0;
    private String winner;
    private Model model;
    private Intent intent;
    private String away_scorer;
    private String home_scorer;
    public static final String scorer_key = "add_scorer";
    public static final int home_key = 1;
    public static final int away_key = 2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        //bind view
        homeName = findViewById(R.id.txt_home);
        awayName = findViewById(R.id.txt_away);
        homeScore = findViewById(R.id.score_home);
        awayScore = findViewById(R.id.score_away);
        awayLogo = findViewById(R.id.away_logo);
        homeLogo = findViewById(R.id.home_logo);
        homeScorer = findViewById(R.id.txt_home_scorer);
        awayScorer = findViewById(R.id.txt_away_scorer);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            model = extras.getParcelable(MainActivity.USER_KEY);
            homeName.setText(model.getHomeName());
            awayName.setText(model.getAwayName());
            homeScore.setText(String.valueOf(model.getHomeScore()));
            awayScore.setText(String.valueOf(model.getAwayScore()));
            Bitmap bmp = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("homeLogo"), 0, getIntent().getByteArrayExtra("homeLogo").length);
            homeLogo.setImageBitmap(bmp);
            Bitmap bmpAway = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("awayLogo"), 0, getIntent().getByteArrayExtra("awayLogo").length);
            awayLogo.setImageBitmap(bmpAway);
        }

    }

    public void handleAddHomeScore(View view) {
        Intent intent = new Intent(this, ScorerActivity.class);
        startActivityForResult(intent, 1);
    }

    public void handleAddAwayScore(View view) {
        Intent intent = new Intent(this, ScorerActivity.class);
        startActivityForResult(intent, 2);
    }

    public void handleCekHasil(View view) {

        Intent intent = new Intent(this, ResultActivity.class );

        intent.putExtra(ResultActivity.EXTRA_RESULT,winner);

        if(home_score>away_score){
            winner = "The winner is " + homeName.getText().toString();
            intent.putExtra(ResultActivity.EXTRA_RESULT,winner);
        }
        else if(home_score<away_score){
            winner = "The winner is " + awayName.getText().toString();
            intent.putExtra(ResultActivity.EXTRA_RESULT,winner);
        }
        else if(home_score==away_score){
            winner = "The result is Draw ";
            intent.putExtra(ResultActivity.EXTRA_RESULT,winner);
        }

        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED) {
            return;
        }
        if(requestCode == home_key){
            if(resultCode == RESULT_OK){
                home_score++;
                //set score
                model.addHomeScorer(scorer_key);
                homeScore.setText(String.valueOf(home_score));
                //set nama pencetak gol
                homeScorer.setText(String.valueOf(model.getHomeScorer()));

            }
        }else if(requestCode == away_key){
            if(resultCode == RESULT_OK) {
                away_score++;
                //set score
                model.addAwayScorer(data.getStringExtra(scorer_key));
                awayScore.setText(String.valueOf(home_score));
                //set nama pencetak gol
                awayScorer.setText(String.valueOf(away_scorer));
            }
        }

    }//onActivityResult

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_CANCELED) {
//            return;
//        }
//        if(requestCode == 1){
//            if(resultCode == RESULT_OK){
//                match.addHomeScore(data.getStringExtra(ADD_KEY), data.getStringExtra(TIME_KEY));
//                tvScoreHome.setText(String.valueOf(match.getHomeScore()));
//                tvGoalHome.setText(match.homeScorer());
//                Log.d("who?", "scorer is " + match.getHomeScorer());
//            }
//        }else if(requestCode == 2){
//            if(resultCode == RESULT_OK) {
//                match.addAwayScore(data.getStringExtra(ADD_KEY), data.getStringExtra(TIME_KEY));
//                tvScoreAway.setText(String.valueOf(match.getAwayScore()));
//                tvGoalAway.setText(match.awayScorer());
//                Log.d("who?", "scorer is " + match.getHomeScorer());
//            }
//        }
//    }

}
