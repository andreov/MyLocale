package com.example.mylocale;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
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
    private Spinner mSpColor;
    private Spinner mSpMargin;
    private Button mBtnOk;
    private static @StyleRes int themeRes = R.style.AppThemeGreen;
    private Locale locale = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(themeRes);
        setContentView(R.layout.activity_main);
        initViews();
        initBtnOk();
    }
    private void initViews() {
        mSpLanguage = findViewById(R.id.spLanguage);
        mSpColor=findViewById(R.id.spColor);
        mSpMargin=findViewById(R.id.spMargin);
        mBtnOk = findViewById(R.id.btnOk);
        initSpColor();
        initSpMargin();
        initSpLanguage();
    }

    private void initSpLanguage(){
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpLanguage.setAdapter(adapterCountries);

    }

    private void initSpColor(){
        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(this, R.array.Color, android.R.layout.simple_spinner_item);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpColor.setAdapter(adapterColor);

    }

    private void initSpMargin() {
        ArrayAdapter<CharSequence> adapterColor = ArrayAdapter.createFromResource(this, R.array.Margin, android.R.layout.simple_spinner_item);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpMargin.setAdapter(adapterColor);
    }

    private void changeLang(){
        String language = (String)mSpLanguage.getSelectedItem();
        switch (language){
            case "Русский":
                locale = new Locale("ru");
                break;
            case "English":
                locale = new Locale("en");
                break;
        }
    }

    private void changeColor(){
        String[] colorRes = getResources().getStringArray(R.array.Color);
        String colorStyle = (String)mSpColor.getSelectedItem();

        if (colorStyle.equals(colorRes[0]))
            themeRes=R.style.AppThemeGreen;
        else if (colorStyle.equals(colorRes[1]))
            themeRes=R.style.AppThemeBlack;
        else if (colorStyle.equals(colorRes[2]))
            themeRes=R.style.AppThemeBlue;
    }

    private void changeMargin(){
        String[] marginRes = getResources().getStringArray(R.array.Margin);
        String marginStyle = (String)mSpMargin.getSelectedItem();
        if (marginStyle.equals(marginRes[1]))
            themeRes=R.style.Margin1;
        else if (marginStyle.equals(marginRes[2]))
            themeRes=R.style.Margin3;
        else if (marginStyle.equals(marginRes[3]))
            themeRes=R.style.Margin10;
    }



    private void initBtnOk(){
        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLang();
                changeColor();
                changeMargin();


                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        });
    }
}

    //String item = (String)parent.getItemAtPosition(position);
    //String[] countries = getResources().getStringArray(R.array.countries);