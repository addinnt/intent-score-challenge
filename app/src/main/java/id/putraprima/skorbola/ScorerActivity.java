package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import id.putraprima.skorbola.model.Model;

public class ScorerActivity extends AppCompatActivity {

    private EditText etScorer;
    public static final String ADD_SCORER_KEY = "add";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorer);
        //bind view
        etScorer= findViewById(R.id.scorerInput);
    }

    public void handleSubmitScorer(View view) {
        Intent intent = new Intent();
        intent.putExtra(ADD_SCORER_KEY, etScorer.getText().toString());
        setResult(RESULT_OK, intent);
        finish();

    }
}
