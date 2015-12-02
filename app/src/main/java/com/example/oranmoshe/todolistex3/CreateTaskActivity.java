package com.example.oranmoshe.todolistex3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateTaskActivity extends AppCompatActivity {

    public ArrayList<ListViewItem> items;
    public  final static String SER_KEY = "com.easyinfogeek.objectPass.ser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // ListViewItem
        /*
        ArrayList<ListViewItem> listArr = (ArrayList<ListViewItem>)getIntent().getSerializableExtra(TaskListActivity.SER_KEY);
        for(ListViewItem object: listArr){
            Toast.makeText(getBaseContext(),object.GetTaskName(), Toast.LENGTH_LONG).show();
        }
        */

        // ArrayListString

        ArrayList<ListViewItem> listArr = (ArrayList<ListViewItem>)getIntent().getSerializableExtra(TaskListActivity.SER_KEY);
        for(ListViewItem object: listArr){
            Toast.makeText(getBaseContext(),object.GetTaskName(), Toast.LENGTH_LONG).show();
        }

        items = listArr;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void myClickHandler(View v) {
        EditText et = (EditText)findViewById(R.id.editTextName);
        String name =  et.getText().toString();
        ListViewItem lvi = new ListViewItem(name);
        items.add(new ListViewItem(name));

        Intent mIntent = new Intent(this,TaskListActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(SER_KEY, items);
        mIntent.putExtras(mBundle);

        startActivity(mIntent);
    }

    public void GoToMainActivity() {
    }
}
