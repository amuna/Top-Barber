package com.example.amuna95.finalproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    private EditText emailID;
    private EditText pass;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Toolbar myActionbar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(myActionbar);
        progressDialog = new ProgressDialog(this);

        emailID = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.signup_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.SignUp:
                //  Action
                Intent intent = new Intent(this, SignupActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Sign Up", Toast.LENGTH_SHORT).show();
                break;
            case R.id.home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                startActivity(homeIntent);
                Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                break;
            default:
                // Unknown Error
        }
        return super.onOptionsItemSelected(item);
    }

    public void login(View view) {
        String userEmail = emailID.getText().toString().trim();
        String userPass = pass.getText().toString().trim();

        //  Checking if email and password is empty
        if (TextUtils.isEmpty(userEmail)) {
            //  Email is empty
            emailID.setText("");
            pass.setText("");
            Toast.makeText(this, "User id or password is incorrect", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userPass)) {
            //  password is empty
            emailID.setText("");
            pass.setText("");
            Toast.makeText(this, "User id or password is incorrect", Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Signing in...");
        progressDialog.show();
    }
}