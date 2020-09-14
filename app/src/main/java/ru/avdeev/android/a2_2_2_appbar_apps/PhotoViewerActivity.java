package ru.avdeev.android.a2_2_2_appbar_apps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PhotoViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_viewer);
        TextView txtAdr = findViewById(R.id.textAdr);
        String outText = getString(R.string.txtAdr) + Integer.toString(getRandomIntegerBetweenRange(1,99));
        txtAdr.setText(outText);
        //init();
    }

    public void btnForwardClicked (View view) {
        Intent intent = new Intent(PhotoViewerActivity.this, PhotoViewerActivity.class);
        startActivity(intent);
    }

    public void btnBackClicked(View view) {
        finish();
    }

    public int getRandomIntegerBetweenRange(int min, int max){
        int x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }

    private void init() {
        Button btnForward = findViewById(R.id.btnForward);
        Button btnBack = findViewById(R.id.btnBack);

        btnForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhotoViewerActivity.this, PhotoViewerActivity.class);
                startActivity(intent);
            }

            public int getRandomIntegerBetweenRange(int min, int max){
                int x = (int)(Math.random()*((max-min)+1))+min;
                return x;
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}