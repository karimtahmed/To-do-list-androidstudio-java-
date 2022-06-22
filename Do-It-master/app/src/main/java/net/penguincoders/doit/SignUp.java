package net.penguincoders.doit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Button sign;
    EditText name;
    EditText username;
    EditText password;
    EditText phoneno;
    EditText email;
    EditText age;
    DBhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final int duration = Toast.LENGTH_SHORT;
        final Context context = getApplicationContext();
        final CharSequence success = "Sign up Successfully";
        final CharSequence user_empty = "You did not enter a username!!";
        final CharSequence pass_empty = "You did not enter a Password!!";
        final CharSequence age2 = "You did not enter a age!!";
        final CharSequence name2 = "You did not enter a name!!";
        final CharSequence email2 = "You did not enter a email!!";
        final CharSequence phone = "You did not enter a Phone number!!";
        sign = findViewById(R.id.sign);
        name=findViewById(R.id.name);
        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        phoneno=findViewById(R.id.phoneno);
        email=findViewById(R.id.email);
        age=findViewById(R.id.age);
        DB= new DBhelper(SignUp.this);
        sign.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                DBhelper DB= new DBhelper(SignUp.this);
                Toast toast ;
                if (username.getText().toString().matches("")) {

                    toast = Toast.makeText(context, user_empty, duration);
                    toast.show();
                } else if (password.getText().toString().matches("")) {

                    toast = Toast.makeText(context, pass_empty, duration);
                    toast.show();

                } else if (name.getText().toString().matches("")) {

                    toast = Toast.makeText(context, name2, duration);
                    toast.show();

                }else if (phoneno.getText().toString().matches("")) {

                    toast = Toast.makeText(context, phone, duration);
                    toast.show();

                }else if (email.getText().toString().matches("")) {

                    toast = Toast.makeText(context, email2, duration);
                    toast.show();

                }else if (age.getText().toString().matches("")) {

                    toast = Toast.makeText(context, age2, duration);
                    toast.show();

                }
                else {
                    DB.insertuserdata(username.getText().toString().trim(),name.getText().toString().trim(),password.getText().toString().trim(),phoneno.getText().toString().trim(),age.getText().toString().trim(),email.getText().toString().trim());

                    toast = Toast.makeText(context, success, duration);
                    toast.show();
//sql
                    Intent i = new Intent(SignUp.this, login.class);

                    startActivity(i);

                }

            }
        });
    }
}