package com.example.dailydoer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   private ArrayList<String> item;
   private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.ListView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                additem(view);
            }
        });

        item =new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,item);
        listView.setAdapter(itemsAdapter);
        setUpListViewListnerr();

    }

    private void setUpListViewListnerr() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Item Removed", Toast.LENGTH_LONG).show();

                item.remove(i); // Removing item from the list
                itemsAdapter.notifyDataSetChanged(); // Notifying adapter about data change
                return true;
            }
        });
    }

    private void additem(View view) {


        EditText input = findViewById(R.id.editTextTextPersonName);
        String itemtext = input.getText().toString();

        if(!itemtext.equals(""))
        {
            itemsAdapter.add(itemtext);
            input.setText("");
        }
        else
        {
          Toast.makeText(getApplicationContext(),"Please Enter Text....",Toast.LENGTH_LONG).show();
        }

    }
}