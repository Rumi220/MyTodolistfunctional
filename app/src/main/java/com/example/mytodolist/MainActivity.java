package com.example.mytodolist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String>items;
    private ArrayAdapter<String>itemsAdapter;
    private ListView lvitems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        lvitems =(ListView) findViewById(R.id.lvitems);
        items=new ArrayList<String>();
        itemsAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        lvitems.setAdapter(itemsAdapter);
        items.add("exam at 9");

        setupListViewListener();

        }
        private void setupListViewListener(){
        lvitems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });
        }

    public void add(View v) {
        EditText enter = findViewById(R.id.enter);
        String itemText = enter.getText().toString();
        if (!itemText.isEmpty()) {
            itemsAdapter.add(itemText);
            enter.setText("");
        }
    }
}