package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    int secretNum = (int)(Math.random()*99)+1;
    int numIntentos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                EditText enteredNum = (EditText) findViewById (R.id.InPutNumber);
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
                        secretNum = (int)(Math.random()*99)+1;
                        numIntentos = 0;
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Entrada no valida.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}