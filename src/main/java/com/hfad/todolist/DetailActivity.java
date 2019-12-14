package com.hfad.todolist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_TODO_ID = "id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        ToDoDetailFragment frag = (ToDoDetailFragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);

        int todoID = (int) getIntent().getExtras().get(EXTRA_TODO_ID);
        frag.setToDoID(todoID);
    }

}
