package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    //public static final String RANKING = "com.example.myapplication.MainActivity_ranking";
    int secretNum = (int)(Math.random()*99)+1;
    int numIntentos = 0;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonName = findViewById(R.id.buttonName);
        buttonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText enteredName = (EditText) findViewById (R.id.inPutName);
                String enteredNameString = enteredName.getText().toString();
                name = enteredNameString;
            }
        });

        final Button buttonRestart = findViewById(R.id.buttonNumber);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart();
            }
        });

        final Button buttonNumber = findViewById(R.id.buttonNumber);
        buttonNumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EditText enteredNum = (EditText) findViewById (R.id.inPutNumber);
                String enteredNumString = enteredNum.getText().toString();

                try{
                    int enteredNumInt = Integer.parseInt(enteredNumString);
                    numIntentos++;
                    if(enteredNumInt<secretNum){
                        Toast.makeText(MainActivity.this, "El numero secreto es mas grande.", Toast.LENGTH_SHORT).show();
                    }else if(enteredNumInt>secretNum) {
                        Toast.makeText(MainActivity.this, "El numero secreto es mas chico.", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(MainActivity.this, "Haz encontrado el numero secreto en "+numIntentos+" intentos.", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Entrada no valida.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void restart(){
        numIntentos = 0;
        name = "";
        secretNum = (int)(Math.random()*99)+1;
    }

    public void callRanking(View view){
        if(!name.equals("")){
        Intent intent = new Intent(this, MainActivity_ranking.class);
        intent.putExtra("intentos", numIntentos);
        intent.putExtra("name", name);
        startActivity(intent);
        }else {
            Toast.makeText(MainActivity.this, "Nombre no valida.", Toast.LENGTH_SHORT).show();
        }
    }
}