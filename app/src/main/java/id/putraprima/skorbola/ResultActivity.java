package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import id.putraprima.skorbola.model.Model;

public class ResultActivity extends AppCompatActivity {

    private String data;
    private TextView tvWinner;
    private TextView tvScorerList;
    public static final String EXTRA_RESULT = "EXTRA_RESULT";
    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        data = intent.getStringExtra(EXTRA_RESULT);


        //bind view
        tvWinner = findViewById(R.id.tv_winner);
        tvWinner.setText(data);
        tvScorerList = findViewById(R.id.tv_scorer);
       // Bundle extras = getIntent().getExtras();

//        if(extras != null){
//            String scorerName = "";
//            if(model.getWinner().equals(model.getHomeName())){
//                for (String win : model.getHomeScorer()) {
//                    scorerName += win + "\n";
//                }
//                tvWinner.setText("The winner is " + model.getWinner());
//                tvScorerList.setText(scorerName);
//            }else if(model.getWinner().equals(model.getAwayName())){
//                for (String win : model.getHomeScorer()) {
//                    scorerName += win + "\n";
//                }
//                tvWinner.setText("The winner is " + model.getWinner());
//                tvScorerList.setText(scorerName);
//            }
//            else{
//                tvWinner.setText("The Result is Draw");
//            }
//        }

    }
}
