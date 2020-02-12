package com.liusara.lab02_texts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submitButton;
    EditText responseText;
    TextView displayText;
    TextView messageText;
    Button messageButton;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton=findViewById(R.id.clickButton);
        responseText=findViewById(R.id.responseEditText);
        displayText=findViewById(R.id.textBox);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("testSubmit", "Your name is " + responseText.getText());
                String concatenatedString = "Your name is "+responseText.getText();
                displayText.setText(concatenatedString);
            }
        });
        messageText=findViewById(R.id.messages);
        messageButton=findViewById(R.id.seeMessage);
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                String[] planets = res.getStringArray(R.array.planets_array);
                String planet = planets[count%planets.length];
                count++;
                Log.i("testMessage", planet);
                messageText.setText(planet);
            }
        });
    }
}
