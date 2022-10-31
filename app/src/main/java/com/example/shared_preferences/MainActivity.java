package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    SharedPreferences sharedpreferences;
    TextView name;
    TextView npm;
    TextView kelas;
    TextView prodi;
    Button btnSave;
    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String NPM = "npmKey";
    public static final String Kelas = "kelasKey";
    public static final String Prodi = "prodiKey";
    public static final String session = "session";
    private BreakIterator user;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.etName);
        npm = (TextView) findViewById(R.id.etNPM);
        kelas = (TextView) findViewById(R.id.etKelas);
        prodi = (TextView) findViewById(R.id.etProdi);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener((View.OnClickListener) this);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(NPM)) {
            npm.setText(sharedpreferences.getString(NPM, ""));
        }
        if (sharedpreferences.contains(Kelas)) {
            kelas.setText(sharedpreferences.getString(Kelas, ""));
        }
        if (sharedpreferences.contains(Prodi)) {
            prodi.setText(sharedpreferences.getString(Prodi, ""));
        }
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSave:

                pref     = getSharedPreferences(session, MODE_PRIVATE);
                editor  = pref.edit();
                editor.putString("getname" , user.getText().toString());
                editor.putInt("getnpm" , Integer.parseInt(npm.getText().toString()));
                editor.putString("getkelas" , user.getText().toString());
                editor.putString("getprodi" , user.getText().toString());
                editor.apply();

                Intent moveActivity     = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(moveActivity);

                break;
        }
    }

    public void clear(View view) {
        name = (TextView) findViewById(R.id.etName);
        npm = (TextView) findViewById(R.id.etNPM);
        kelas = (TextView) findViewById(R.id.etKelas);
        prodi = (TextView) findViewById(R.id.etProdi);
        name.setText("");
        npm.setText("");
        kelas.setText("");
        prodi.setText("");

    }

    public void Get(View view) {
        name = (TextView) findViewById(R.id.etName);
        npm = (TextView) findViewById(R.id.etNPM);
        kelas = (TextView) findViewById(R.id.etKelas);
        prodi = (TextView) findViewById(R.id.etProdi);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(NPM)) {
            npm.setText(sharedpreferences.getString(NPM, ""));
        }
            if (sharedpreferences.contains(Kelas)) {
                kelas.setText(sharedpreferences.getString(Kelas, ""));
            }
            if (sharedpreferences.contains(Prodi)) {
                prodi.setText(sharedpreferences.getString(Prodi, ""));
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
