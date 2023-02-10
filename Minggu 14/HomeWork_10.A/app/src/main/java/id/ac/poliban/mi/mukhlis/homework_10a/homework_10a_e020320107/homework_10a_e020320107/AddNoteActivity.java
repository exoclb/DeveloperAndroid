package id.ac.poliban.mi.mukhlis.homework_10a.homework_10a_e020320107.homework_10a_e020320107;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import id.ac.poliban.mi.ramlan.homework_10a.R;

public class AddNoteActivity extends AppCompatActivity {
    private EditText mTitleEditText;
    private EditText mContentEditText;
    private NoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        mTitleEditText = findViewById(R.id.titleEditText);
        mContentEditText = findViewById(R.id.contentEditText);
        viewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
    }

    public void onSaveClick(View view){
        Note note = new Note(0, mTitleEditText.getText().toString(), mContentEditText.getText().toString());
        viewModel.insert(note);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClearClick(View view) {
        mTitleEditText.setText("");
        mContentEditText.setText("");
    }
}
