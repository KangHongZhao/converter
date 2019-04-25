package com.example.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView whatever, maohao,textView3;
    private Button convert;
    private EditText number;
    private Spinner country1, country2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whatever = (TextView)findViewById(R.id.whatever);
        maohao = (TextView)findViewById(R.id.maohao1);
        convert = (Button)findViewById(R.id.convert);
        number = (EditText)findViewById(R.id.number);

        country1 = (Spinner)findViewById(R.id.country1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        country1.setAdapter(adapter);
        country1.setOnItemSelectedListener(this);

        country2 = (Spinner)findViewById(R.id.country2);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.country2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        country2.setAdapter(adapter1);
        country2.setOnItemSelectedListener(this);
        textView3 = (TextView)findViewById(R.id.textView3);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
