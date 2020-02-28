package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import id.putraprima.skorbola.model.Model;

public class ScorerActivity extends AppCompatActivity {

    private TextView scorerNameInput;
    private String scorerName;
    private String scorerAwayName;
    Model model;
    public static final String scorer_key = "add";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);
        //bind view
        scorerNameInput= findViewById(R.id.scorerInput);
    }

    public void handleSubmitScorer(View view) {
            Intent intent = new Intent();
            intent.putExtra(scorer_key,scorerNameInput.getText().toString());
            setResult(RESULT_OK, intent);
            finish();

    }
}
