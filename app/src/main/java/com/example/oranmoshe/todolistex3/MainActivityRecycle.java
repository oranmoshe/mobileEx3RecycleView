package com.example.oranmoshe.todolistex3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivityRecycle extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public  final static String SER_KEY = "com.easyinfogeek.objectPass.ser.recycle";
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_recycle);

        mRecyclerView = (RecyclerView) findViewById(R.id.cardList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        items = new ArrayList<String>();

        if (isExtrasEmpty()) { // if getSerializableExtraTasks is empty creates new tasks
            items.add("tesk1");
            items.add("tesk2");
            items.add("tesk3");
            items.add("tesk4");
            items.add("tesk6");
            items.add("tesk7");
            items.add("tesk8");
            mAdapter = new RecycleAdapterManager(items);

        } else { // else read them to memory
            items = getSerializableExtraTasks();
            mAdapter = new RecycleAdapterManager(items);
        }
        mRecyclerView.setAdapter(mAdapter);
    }

    public ArrayList<String> getSerializableExtraTasks(){
        return  (ArrayList<String>)getIntent().getSerializableExtra(MainActivityAddRecycleTask.SER_KEY);
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

    public void GoToCreateTaskCreate(View v){
        Intent mIntent = new Intent(this,MainActivityAddRecycleTask.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(SER_KEY, items);
        mIntent.putExtras(mBundle);
        startActivity(mIntent);
    }

    public void myClickHandlerDelete(View v) {
      //  LinearLayout vwParentRow = (LinearLayout)v.getParent();
     //   int index = ((ViewGroup) vwParentRow.getParent()).indexOfChild(vwParentRow);
    //    ((RecycleAdapterManager)mAdapter).remove(index);
    }

}
