package com.hfad.todolist;


import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class ToDoDetailFragment extends Fragment {

    private long toDoID;
    private EditText category;
    private Button submitButton;
    private Button deleteButton;
    private ListView listCategory;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;


    interface Listener {
        void itemClicked(long id);
    }

    private ToDoListFragment.Listener listener;

    public ToDoDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("toDoID",toDoID);
        savedInstanceState.putStringArrayList("arrayList", arrayList);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            toDoID = savedInstanceState.getLong("toDoID");
            arrayList = savedInstanceState.getStringArrayList("arrayList");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }

        return inflater.inflate(R.layout.fragment_to_do_detail, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null) {


            TextView title = (TextView) view.findViewById(R.id.textTitle);
            ToDoList toDo = ToDoList.todo[(int) toDoID];
            title.setText(toDo.getName());

            category = (EditText) view.findViewById(R.id.addCategory);
            submitButton = (Button) view.findViewById(R.id.submitCategory);
            deleteButton = (Button) view.findViewById(R.id.removeCategory);
            listCategory = (ListView) view.findViewById(R.id.listCategory);

            adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);

            listCategory.setAdapter(adapter);

            submitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    arrayList.add(category.getText().toString());
                    adapter.notifyDataSetChanged(); }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    arrayList.remove(category.getText().toString());
                    adapter.notifyDataSetChanged(); }
            });
        }
    }


    public void setToDoID(long id) {
        this.toDoID = id;
    }


}