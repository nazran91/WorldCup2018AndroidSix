package com.aiub.worldcup2018androidsix.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aiub.worldcup2018androidsix.ModelClasses.Team;
import com.aiub.worldcup2018androidsix.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class GroupRecyclerAdapter extends
        RecyclerView.Adapter<GroupRecyclerAdapter.MyViewHolder> {

    private List<List<Team>> groupList;

    public GroupRecyclerAdapter(List<List<Team>> groupList) {
        this.groupList = groupList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView groupName, matchesText, tablesText;
        CircleImageView flagOne, flagTwo, flagThree, flagFour;

        public MyViewHolder(View itemView) {
            super(itemView);

            groupName = itemView.findViewById(R.id.groupName);
            matchesText = itemView.findViewById(R.id.matchesText);
            tablesText = itemView.findViewById(R.id.tableText);
            flagOne = itemView.findViewById(R.id.flagOne);
            flagTwo = itemView.findViewById(R.id.flagTwo);
            flagThree = itemView.findViewById(R.id.flagThree);
            flagFour = itemView.findViewById(R.id.flagFour);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.group_item, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.groupName.setText("Group A");
        Picasso.get().load(groupList.get(position).get(0).getIcon()).into(holder.flagOne);
        Picasso.get().load(groupList.get(position).get(1).getIcon()).into(holder.flagTwo);
        Picasso.get().load(groupList.get(position).get(2).getIcon()).into(holder.flagThree);
        Picasso.get().load(groupList.get(position).get(3).getIcon()).into(holder.flagFour);
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }
}
