package ru.avdeev.android.a2_2_2_appbar_apps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_open_notes) {
            //Toast.makeText(MainActivity.this, getText(R.string.open_netbook), Toast.LENGTH_LONG).show();
            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intentNotes);
            return true;
        }

        if (id == R.id.subscription) {
            Intent intentNotes = new Intent(MainActivity.this, SubscriptionActivity.class);
            startActivity(intentNotes);
            return true;
        }

        if (id == R.id.photo_viewer) {
            Intent intentNotes = new Intent(MainActivity.this, PhotoViewerActivity.class);
            startActivity(intentNotes);
            return true;
        }

        if (id == R.id.health_monitoring) {
            Intent intentNotes = new Intent(MainActivity.this, HealthMonitoringActivity.class);
            startActivity(intentNotes);
            return true;
        }

        if (id == R.id.mutualy_checkbox) {
            Intent intentNotes = new Intent(MainActivity.this, MutuallyCheckBoxActivity.class);
            startActivity(intentNotes);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}