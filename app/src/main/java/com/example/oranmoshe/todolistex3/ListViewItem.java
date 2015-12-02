package com.example.oranmoshe.todolistex3;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by oranmoshe on 11/11/15.
 */

    // simple class that just has one member property as an example
    public class ListViewItem implements Serializable {

        private String TaskName;

        public ListViewItem(String name){
            TaskName = name;
        }

        private static final long serialVersionUID = 46543445;

        public String GetTaskName(){
            return TaskName;
        }


    }

