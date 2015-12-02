package com.example.oranmoshe.todolistex3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class TaskListActivity extends AppCompatActivity {

    public  final static String SER_KEY = "com.easyinfogeek.objectPass.ser";
    CustomAdapter customAdapter;
    ArrayList<ListViewItem> items;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
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


        // Initiates objects
        lv = (ListView) findViewById(R.id.listViewTasks);
        items = new ArrayList<ListViewItem>();
        if(isExtrasEmpty()) { // if getSerializableExtraTasks is empty creates new tasks
            items.add(new ListViewItem("tesk1"));
            items.add(new ListViewItem("tesk2"));
            items.add(new ListViewItem("tesk3"));
            items.add(new ListViewItem("tesk4"));
            items.add(new ListViewItem("tesk1"));
            items.add(new ListViewItem("tesk2"));
            items.add(new ListViewItem("tesk3"));
            items.add(new ListViewItem("tesk4"));
            items.add(new ListViewItem("tesk1"));
            items.add(new ListViewItem("tesk2"));
            items.add(new ListViewItem("tesk3"));
            items.add(new ListViewItem("tesk4"));
            customAdapter = new CustomAdapter(this,items);
        }
        else  { // else read them to memory
            items = getSerializableExtraTasks();
            customAdapter = new CustomAdapter(this,items);
        }
        lv.setAdapter(customAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void GoToCreateTaskActivity(View v){
        Intent mIntent = new Intent(this,CreateTaskActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(SER_KEY, items);
        mIntent.putExtras(mBundle);
        startActivity(mIntent);
    }

    public void GoToCreateTaskRecycle(View v){
        Intent mIntent = new Intent(this,MainActivityR.class);
        startActivity(mIntent);
    }

    public ArrayList<ListViewItem> getSerializableExtraTasks(){
        return  (ArrayList<ListViewItem>)getIntent().getSerializableExtra(TaskListActivity.SER_KEY);
    }

    public boolean isExtrasEmpty(){
        boolean isEmpty = false;
        try{
            if(getSerializableExtraTasks().isEmpty()) {
                return false;
            }
        }
        catch (Exception exc){
            return true;
        }
        return false;
    }

    public void myClickHandler(View v) {
        LinearLayout vwParentRow = (LinearLayout)v.getParent();
        int index = ((ViewGroup) vwParentRow.getParent()).indexOfChild(vwParentRow);
        items.remove(index);
        customAdapter = new CustomAdapter(this,items);
        lv.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

