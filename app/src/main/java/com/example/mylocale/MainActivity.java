package com.example.mylocale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpLanguage;
    private Button mBtnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initBtnOk();
    }
    private void initViews() {
        mSpLanguage = findViewById(R.id.spLanguage);
        mBtnOk = findViewById(R.id.btnOk);
        initSpLanguage();
    }

    private void initSpLanguage(){
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpLanguage.setAdapter(adapterCountries);

    }

    private void initBtnOk(){
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String language = (String)mSpLanguage.getSelectedItem();
                Locale locale = null;
                switch (language){
                    case "Русский":
                        locale = new Locale("ru");
                        break;
                    case "English":
                        locale = new Locale("en");
                        break;
                }

                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }
}