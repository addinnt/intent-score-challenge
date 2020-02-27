package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import id.putraprima.skorbola.model.Model;

public class ScorerActivity extends AppCompatActivity {

    private TextView scorerNameInput;
    private String scorerName;
    private String scorerAwayName;
    private String scorerStatus;
    Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);
        scorerNameInput= findViewById(R.id.scorerInput);

    }

    public void handleSubmitScorer(View view) {

        if(scorerStatus.equals("home")){
            model.setHomeScorer(scorerNameInput.getText().toString());
        }else {
            model.setAwayScorer(scorerNameInput.getText().toString());
        }

        Intent intent = new Intent(this, MatchActivity.class);
        startActivity(intent);
    }
}
