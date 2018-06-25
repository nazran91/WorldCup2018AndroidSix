package com.aiub.worldcup2018androidsix.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.aiub.worldcup2018androidsix.ModelClasses.NotificationItem;
import com.aiub.worldcup2018androidsix.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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

        NotificationItem item = dataList.get(position);

        CircleImageView flag = view.findViewById(R.id.flagIcon);
        Picasso.get().load(item.getFlagUrl()).into(flag);

        TextView countryName = view.findViewById(R.id.countryName);
        countryName.setText(item.getName());

        CheckBox isNotified = view.findViewById(R.id.isNotifiedCheckBox);
        isNotified.setChecked(item.isNotified());

        return view;
    }
}
