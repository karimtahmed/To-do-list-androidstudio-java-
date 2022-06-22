package net.penguincoders.doit;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class profile extends AppCompatActivity {
    TextView name;
    TextView email;
    TextView phonenumber;
    TextView age;
    DBhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = findViewById(R.id.textView4);
        email = findViewById(R.id.textView5);
        phonenumber = findViewById(R.id.textView6);
        age = findViewById(R.id.textView7);
        DB = new DBhelper(profile.this);
        Cursor res=DB.prof(login.uname, login.pp);
        if(res.getCount()==0){
            Toast.makeText(this, "no entry exist", Toast.LENGTH_SHORT).show();
        }
        else{
            res.moveToFirst();
        name.setText("Name : "+res.getString(1));
        email.setText("Email : "+res.getString(5));
        phonenumber.setText("Phone Number : "+res.getString(3));
        age.setText("Age : "+res.getString(4));}
    }
}