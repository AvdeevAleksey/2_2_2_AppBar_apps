package ru.avdeev.android.a2_2_2_appbar_apps;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NotesActivity extends AppCompatActivity {

    private EditText editTextNote;
    private final static String KEY = "key";
    private final static String TEXTNOTE = "text_note";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        editTextNote = findViewById(R.id.notebookEditText);
        editTextNote.setText(loadNoteText());
    }

    public void btnSaveClicked (View view) {
        saveNoteText(editTextNote.getText().toString());
    }

    private void saveNoteText (String text) {
        getSharedPreferences(TEXTNOTE,MODE_PRIVATE)
                .edit()
                .putString(KEY,text)
                .apply();
    }

    private String loadNoteText() {
        return getSharedPreferences(TEXTNOTE,MODE_PRIVATE).getString(KEY,"");
    }
}