package com.example.subir.apppractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DataShowActivity extends AppCompatActivity implements View.OnClickListener{

    TextView e1,e2,e3,e4;
    Button b1,b2;
    SharedPreferences shp;
    String UKEY = "", UPWD = "", UPIN = "",UPHONE = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datashow);

        Intent j = getIntent();
        String username = j.getStringExtra("username");
        String password = j.getStringExtra("password");
        String pin = j.getStringExtra("pin");
        String phone_no = j.getStringExtra("phone_no");

        e1 = findViewById(R.id.usernameCnf);
        e2 = findViewById(R.id.passwordCnf);
        e3 = findViewById(R.id.pinCnf);
        e4 = findViewById(R.id.phoneNoCnf);

        e1.setText(username);
        e2.setText("*********");
        e3.setText("****");
        e4.setText(phone_no);

        b1 = findViewById(R.id.submitCnf);
        b2 = findViewById(R.id.resetCnf);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.submitCnf)
        {
            Toast.makeText(getApplicationContext(), "SignUp Success", Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor edt = shp.edit();
            edt.putString(UKEY, e1.getText().toString());
            edt.putString(UPWD, e2.getText().toString());
            edt.putString(UPIN, e3.getText().toString());
            edt.putString(UPHONE, e4.getText().toString());
            edt.apply();
        }
        else
        {
            Intent i =new Intent(DataShowActivity.this,SignUpActivity.class);
            i.putExtra("uname",e1.getText().toString());
            i.putExtra("pwd",e2.getText().toString());
            i.putExtra("pin",e3.getText().toString());
            i.putExtra("phno",e4.getText().toString());
            startActivity(i);
        }

    }
}
