package com.example.colossustex.SG;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.colossustex.R;

public class yarn_requirements extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_requirements);
        Toast.makeText(yarn_requirements.this, "Your account is ready to use!", Toast.LENGTH_LONG).show();

        Spinner spinner = findViewById(R.id.spinner2);
        Button add_more = findViewById(R.id.button);
        Button submit = findViewById(R.id.button2);

        add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(yarn_requirements.this, "will be added more, soon.", Toast.LENGTH_LONG).show();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(yarn_requirements.this, "Submit button recieved, but, m kya karoon fir, job chod du?", Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(yarn_requirements.this, R.array.types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(yarn_requirements.this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(yarn_requirements.this, "You selected option : "+ Integer.toString(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(yarn_requirements.this, "Nothing selected", Toast.LENGTH_SHORT).show();
    }
}
