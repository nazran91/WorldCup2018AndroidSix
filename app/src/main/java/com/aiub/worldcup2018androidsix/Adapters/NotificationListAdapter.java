package com.aiub.worldcup2018androidsix.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aiub.worldcup2018androidsix.ModelClasses.NotificationItem;
import com.aiub.worldcup2018androidsix.R;

import java.util.List;

public class NotificationListAdapter extends BaseAdapter{

    private List<NotificationItem> dataList;
    private Context context;

    public NotificationListAdapter(Context context, List<NotificationItem> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.notification_list_item, parent, false);

        TextView countryName = view.findViewById(R.id.countryName);
        countryName.setText(dataList.get(position).getName());

        return view;
    }
}
