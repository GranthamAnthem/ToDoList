package com.hfad.todolist;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  implements  ToDoListFragment.Listener {
    static ArrayAdapter<String> adapter;
    public static long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id) {

        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            ToDoDetailFragment details = (ToDoDetailFragment) getSupportFragmentManager().findFragmentByTag(ToDoList.todo[(int) id].getName());
            if(details == null) {
                details = new ToDoDetailFragment();
            }
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setToDoID(id);
            ft.replace(R.id.fragment_container,details, ToDoList.todo[(int) id].getName());
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_TODO_ID, (int) id);
            startActivity(intent);
        }
    }
}

