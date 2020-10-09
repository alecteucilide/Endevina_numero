package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity_ranking extends AppCompatActivity {
    static ArrayList<String> rankingNombre = new ArrayList<String>();
    static ArrayList<Integer> rankingIntentos = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ranking);

        final TextView tvRanking = (TextView)findViewById(R.id.textViewRanking);
        String name = getIntent().getStringExtra("name");
        int numIntentos  = getIntent().getIntExtra("intentos", 0);

        tvRanking.setText(name+" "+numIntentos);


        //rankingIntentos.add(numIntentos);

        /*buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = getName();

                tvRanking.setText(name);

                /*if(!name. || !name.equals(" ")){
                    rankingNombre.add(name);

                    for(int i = rankingIntentos.size() - 1; i >= 1; i--){
                        for(int j = 0; j < i; j++){
                            if(rankingIntentos.get(j)<rankingIntentos.get(i)){
                                int change = rankingIntentos.get(j);
                                rankingIntentos.set(j, rankingIntentos.get(i));
                                rankingIntentos.set(i, change);
                                String nameChange = rankingNombre.get(j);
                                rankingNombre.set(j, rankingNombre.get(i));
                                rankingNombre.set(i, nameChange);
                            }
                        }
                    }

                    String text = "";
                    for(int i = 0; i < rankingNombre.size();i++){
                        text=text+rankingNombre.get(i)+" "+rankingIntentos.get(i)+"\n";
                    }
                    tvRanking.setText(text);

                }else{
                    Toast.makeText(MainActivity_ranking.this, "Nombre no valida", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }
}