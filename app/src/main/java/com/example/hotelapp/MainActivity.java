package com.example.hotelapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button blogin = (Button) findViewById(R.id.login_button);
        final EditText input1 = (EditText) findViewById(R.id.email);
        final EditText input2 = (EditText) findViewById(R.id.password);

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = input1.getText().toString();
                String password = input2.getText().toString();

                if(email.equals("pgpb@gmail.com") && password.equals("123")) {
                    Intent masukHome = new Intent(MainActivity.this, HomePage.class);
                    startActivity(masukHome);
                }
                else{
                    AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
                    myAlertBuilder.setTitle(R.string.alert_title);
                    myAlertBuilder.setMessage(R.string.alert_message);

                    myAlertBuilder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    myAlertBuilder.show();
                }
            }
        });
    }
}