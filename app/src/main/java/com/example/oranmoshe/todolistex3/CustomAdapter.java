package com.example.oranmoshe.todolistex3;

    import java.util.List;

    import com.example.oranmoshe.todolistex3.ListViewItem;

    import android.app.Activity;
    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.BaseAdapter;
    import android.widget.ImageView;
    import android.widget.ListView;
    import android.widget.TextView;

    public class CustomAdapter extends BaseAdapter
    {

        LayoutInflater inflater;
        List<ListViewItem> items;

        public CustomAdapter(Activity context, List<ListViewItem> items) {
            super();
            this.items = items;
            this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ListViewItem item = items.get(position);
            View vi=convertView;
            if(convertView==null)
                vi = inflater.inflate(R.layout.custom_row, null);
            TextView textView = (TextView)vi.findViewById(R.id.textViewTaskName);
            textView.setText(item.GetTaskName());
            return vi;
        }
    }
