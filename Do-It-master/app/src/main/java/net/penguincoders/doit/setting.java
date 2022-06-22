package net.penguincoders.doit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class setting extends AppCompatActivity {

    Switch switch1;
    Button button3;
    TextView textView3;
    Button button;
    Button button2;

    private UiModeManager uiModeManager;
    @SuppressLint("WrongViewCast")
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting2);
        switch1 = findViewById(R.id.switch1);
        uiModeManager = (UiModeManager) getSystemService(UI_MODE_SERVICE);
        textView3 = findViewById(R.id.textView3);
        button2= findViewById(R.id.button2);
        Intent intent=getIntent();
        String name = intent.getStringExtra("uname");
        Toast.makeText(getApplicationContext(), login.uname, Toast.LENGTH_SHORT).show();
        textView3.setText("Hello, "+login.uname);
       switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                final Intent i = new Intent(setting.this, login.class);
                startActivity(i);

            }

        });
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                final Intent i = new Intent(setting.this, MainActivity.class);
                startActivity(i);

            }

        });
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                final Intent i = new Intent(setting.this, profile.class);
                startActivity(i);

            }

        });
    }
}