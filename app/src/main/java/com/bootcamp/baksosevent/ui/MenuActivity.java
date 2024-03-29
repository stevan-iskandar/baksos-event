package com.bootcamp.baksosevent.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bootcamp.baksosevent.R;
import com.bootcamp.baksosevent.utils.SharedPreferencesUtil;

public class MenuActivity extends AppCompatActivity {
  SharedPreferencesUtil session;
  Button btnEvent, btnBuatEvent, btnDonate, btnAbout;
  TextView txtLogout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_menu);

    session = new SharedPreferencesUtil(MenuActivity.this);
    setTitle(session.getUsername());
    btnEvent = findViewById(R.id.btnEvent);
    btnBuatEvent = findViewById(R.id.btnBuatEvent);
    btnDonate = findViewById(R.id.btnDonate);
    btnAbout = findViewById(R.id.btnAbout);
    txtLogout = findViewById(R.id.txtLogout);

    btnEvent.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MenuActivity.this, AllEventActivity.class);
        startActivity(intent);
      }
    });

    btnBuatEvent.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MenuActivity.this, BuatEventActivity.class);
        startActivity(intent);
      }
    });

    btnDonate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MenuActivity.this, DonateActivity.class);
        startActivity(intent);
      }
    });

    btnAbout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(MenuActivity.this, AboutActivity.class);
        startActivity(intent);
      }
    });

    txtLogout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        session.setUsername("");
        Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
      }
    });
  }
}
