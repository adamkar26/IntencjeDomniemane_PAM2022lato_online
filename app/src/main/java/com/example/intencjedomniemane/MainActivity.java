package com.example.intencjedomniemane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonWWW = findViewById(R.id.buttonWWW);
        buttonWWW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editTextWWW);
                String adres = editText.getText().toString();

                Uri uri = Uri.parse("http://"+adres);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button buttonCity = findViewById(R.id.buttonCity);
        buttonCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editTextCity);
                String miasto = editText.getText().toString();

                Uri uri = Uri.parse("geo:0,0?q="+miasto);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button buttonWspolrzedne = findViewById(R.id.buttonWspolrzedne);
        buttonWspolrzedne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editTextSzerkosc);
                String szerokosc = editText.getText().toString();
                editText = findViewById(R.id.editTextDlugosc);
                String dlugosc = editText.getText().toString();

                String s= String.format("geo:%s,%s", szerokosc, dlugosc);
                Uri uri = Uri.parse(s);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        Button buttonBudzik = findViewById(R.id.buttonBudzik);
        buttonBudzik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_HOUR, 15)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 54)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "Pora wstawać!");
                startActivity(intent);
            }
        });

        Button buttonMinutnik = findViewById(R.id.buttonMinutnik);
        buttonMinutnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "Odliczanie")
                        .putExtra(AlarmClock.EXTRA_LENGTH, 15)
                      //  .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true);

                startActivity(intent);
            }
        });
    }
}