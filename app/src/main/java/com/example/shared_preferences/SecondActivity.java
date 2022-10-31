package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;
    public static final String session = "session";

    TextView result;
    Button btnGetData, btnClearData;
    private String getname;
    private int getnpm;
    private String getkelas;
    private String getprodi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        result      = findViewById(R.id.tv_result);
        btnGetData  = findViewById(R.id.btn_get_data);
        btnClearData = findViewById(R.id.btn_clear);


    }

    void getData(){
        pref     = getSharedPreferences(session, MODE_PRIVATE);
        getname  = pref.getString("getname", "Not Found");
        getnpm  = pref.getInt("getnpm", 0);
        getkelas  = pref.getString("getkelas", "Not Found");
        getprodi  = pref.getString("getprodi", "Not Found");

        result.setText("Result : "+getname+getkelas+getprodi+ " And Number "+getnpm);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_get_data:
                getData();

                break;

            case R.id.btn_clear:
                editor    = pref.edit();
                editor.remove("getname");
                editor.remove("getnpm");
                editor.remove("getkelas");
                editor.remove("getprodi");
                editor.commit();
                getData();

                break;
        }
    }
}