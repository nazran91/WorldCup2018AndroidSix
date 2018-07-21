package com.aiub.worldcup2018androidsix.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.aiub.worldcup2018androidsix.ModelClasses.MatchModel;
import com.aiub.worldcup2018androidsix.R;

import java.util.List;

public class MatchesListAdapter extends BaseAdapter {

    private Context context;
    private List<MatchModel> matchModelList;

    public MatchesListAdapter(Context context, List<MatchModel> matchModelList) {
        this.context = context;
        this.matchModelList = matchModelList;
    }

    @Override
    public int getCount() {
        return matchModelList.size();
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
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.match_list_item,
                parent, false);

        return view;
    }
}
