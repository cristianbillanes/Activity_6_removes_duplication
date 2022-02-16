package com.example.activity_5_removes_first_word;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class MainActivity extends AppCompatActivity {
    TextView Result;
    EditText input;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Result = findViewById(R.id.Result);
        input = findViewById(R.id.input);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result();
            }
        });

    }
    private void Result(){
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("Result",DeleteDuplication());
        startActivity(intent);
    }
    private String  DeleteDuplication(){
        String letters = input.getText().toString();
        String[] words = letters.split("\\s");
        LinkedHashSet<String> set = new LinkedHashSet<String>( Arrays.asList(words) );
        String result ="";
        for(String word: set) {
            result = result + word + " ";
        }
        return result;
    }


}