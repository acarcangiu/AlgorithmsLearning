package com.example.algorithmlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Button button2;
    Button Add;
    Button Clearstack;
    ArrayList <String> StackList;
    EditText txt;
    ListView show;
    Button peekButton;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Clearstack = (Button) findViewById(R.id.clear_stack);
        txt = (EditText) findViewById(R.id.txt);
        show = (ListView) findViewById(R.id.listofthings);
        Add = (Button) findViewById(R.id.Add);
        button2 = (Button) findViewById(R.id.button2);
        peekButton = (Button) findViewById(R.id.PeekButton);
        StackList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, StackList);
        show.setAdapter(adapter);

    }







        public void AddButtonClick() {
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = txt.getText().toString();

             if(StackList.contains(getInput)) {
                 Toast.makeText(getBaseContext(), "Item Already added to Array", Toast.LENGTH_LONG).show();

             }
             else if (getInput == null || getInput.trim().equals("")) {
                 Toast.makeText(getBaseContext(), "Input Field is Empty", Toast.LENGTH_LONG).show();

             }
             else{
                 StackList.add(getInput);
                 ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, StackList);
                 show.setAdapter(adapter);
                 ((EditText) findViewById(R.id.txt)).setText(" ");

             }
            }
        });
        public void PopButtonClick()  {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StackList.isEmpty()) {
                    Toast.makeText(getBaseContext(),"The Stack is Empty", Toast.LENGTH_LONG).show();
                }
                else {
                    StackList.remove(StackList.size() + 0);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, StackList);
                    show.setAdapter((ListAdapter) StackList);
                    ((EditText) findViewById(R.id.txt)).setText(" ");


                }
            }}
        );

        Clearstack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StackList.isEmpty()) {
                    Toast.makeText(getBaseContext(), "The Stack is Empty", Toast.LENGTH_LONG).show();
                }
                else {
                    StackList.clear();
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, StackList);
                    show.setAdapter((ListAdapter) StackList);
                    ((EditText) findViewById(R.id.txt)).setText(" ");
                }
            }
        });

        peekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (StackList.isEmpty()) {
                    Toast.makeText(getBaseContext(), "null", Toast.LENGTH_LONG).show();
                }
                else {
                    int length = StackList.size();
                    String n = StackList.get(length - 1) ;
                    Toast.makeText(getBaseContext(), " " + n, Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}