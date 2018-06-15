package com.example.subir.apppractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText e1,e2,e3,e4;
    ImageButton b1;
    Intent i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Intent j = getIntent();

        e1 = findViewById(R.id.usernameReg);
        e1.setText(j.getStringExtra("uname"));
        e2 = findViewById(R.id.passwordReg);
        e2.setText(j.getStringExtra("pwd"));
        e3 = findViewById(R.id.pinReg);
        e3.setText(j.getStringExtra("pin"));
        e4 = findViewById(R.id.phnoReg);
        e4.setText(j.getStringExtra("phno"));

        b1 = findViewById(R.id.submitBtn);
        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(getApplicationContext(), "Data Correct", Toast.LENGTH_SHORT);
        i = new Intent(SignUpActivity.this, DataShowActivity.class);
        i.putExtra("username", e1.getText().toString());
        i.putExtra("password", e2.getText().toString());
        i.putExtra("pin", e3.getText().toString());
        i.putExtra("phone_no", e4.getText().toString());
        startActivity(i);
    }
}
