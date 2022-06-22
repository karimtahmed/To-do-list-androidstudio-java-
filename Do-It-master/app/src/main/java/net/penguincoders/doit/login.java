package net.penguincoders.doit;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    public static String uname;
    public static String pp;
    Button confirm;
    Button signup;
    EditText password;
    EditText username;
    DBhelper DB;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        confirm = findViewById(R.id.confirm);
        signup=findViewById(R.id.signup2);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        final int duration = Toast.LENGTH_SHORT;
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar

        final Context context = getApplicationContext();
        CharSequence success = "Login Successfully";
        CharSequence fail = "Login Failed";
        final CharSequence user_empty = "You did not enter a username!!";
        final CharSequence pass_empty = "You did not enter a Password!!";

        confirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                //is empty for username
                if (username.getText().toString().matches("")) {
                    Toast toast = Toast.makeText(context, user_empty, duration);
                    toast.show();

                    return;
                } else if (password.getText().toString().matches("")) {
                    Toast toast = Toast.makeText(context, pass_empty, duration);
                    toast.show();
                    return;
                } else {
                    //sql retrieve
                    DB = new DBhelper(login.this);
                    Boolean check = DB.getdata(username.getText().toString().trim(), password.getText().toString().trim());

                    if (check == true) {
                        Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show();
                        i = new Intent(login.this, MainActivity.class);
                        uname=username.getText().toString();
                        pp=password.getText().toString();
                        i.putExtra("uname", uname);
                        startActivity(i);
                    } else {

                        Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                /*final Intent i = new Intent(login.this, MainActivity.class);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(i);
                        finish();
                    }
                }, 2000);*/
                }
         }
        });

        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                final Intent i1 = new Intent(login.this, SignUp.class);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(i1);
                        finish();
                    }
                }, 2000);

            }
        });
    }
}