package com.example.oranmoshe.todolistex3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityAddRecycleTask extends AppCompatActivity {
    public ArrayList<TaskItem> items;
    public  final static String SER_KEY = "com.easyinfogeek.objectPass.ser.recycle";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_add_recycle_task);

        items = new ArrayList<TaskItem>();
        items = (ArrayList<TaskItem>)getIntent().getSerializableExtra(SER_KEY);

    }


    public void myClickHandler(View v) {
        EditText et = (EditText)findViewById(R.id.editTextName);
        String name =  et.getText().toString();
        items.add(new TaskItem(name,name));

        Intent mIntent = new Intent(this,MainActivityRecycle.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(MainActivityRecycle.SER_KEY, items);
        mIntent.putExtras(mBundle);

        startActivity(mIntent);
    }

}
