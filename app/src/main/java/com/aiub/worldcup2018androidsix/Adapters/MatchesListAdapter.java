package com.aiub.worldcup2018androidsix.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.aiub.worldcup2018androidsix.ModelClasses.MatchModel;
import com.aiub.worldcup2018androidsix.R;
import com.github.curioustechizen.ago.RelativeTimeTextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MatchesListAdapter extends BaseAdapter {

    private Context context;
    private List<MatchModel> matchModelList;
    private Date date;

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

    //ctrl+shift+/
/*    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = LayoutInflater.from(context).inflate(R.layout.match_list_item,
                parent, false);

        TextView groupName = view.findViewById(R.id.groupName);
        TextView homeName = view.findViewById(R.id.homeTeamName);
        TextView homeGoal = view.findViewById(R.id.homeGoal);
        TextView awayTeamName = view.findViewById(R.id.awayTeamName);
        TextView awayGoal = view.findViewById(R.id.awayGoal);
        CircleImageView homeTeamFlag = view.findViewById(R.id.homeTeamFlag);
        CircleImageView awayTeamFlag = view.findViewById(R.id.awayTeamFlag);
        RelativeTimeTextView matchTime = view.findViewById(R.id.matchTime);

        MatchModel matchModel = matchModelList.get(position);

        convertStringToDate(matchModel.getMatchTime());

        matchTime.setReferenceTime(date.getTime());
        groupName.setText(matchModel.getMatchStage());
        //homeName.setText(matchModel.getHomeTeam());
        homeGoal.setText("" + matchModel.getHomeResult());
        awayGoal.setText("" + matchModel.getAwayResult());
        //awayTeamName.setText(matchModel.getAwayTeam());
        //homeTeamFlag.setText(matchModel);
        //awayTeamFlag.setText();

        return view;
    }

    private void convertStringToDate(String matchTime) {
        //Date date = new Date();
        Log.e("match time", matchTime);
        //String dtStart = "2018-06-25T18:00:00+04:00";
        String dtStart = matchTime;
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'GMT'+HH:mm");
        try {
            date = format.parse(dtStart);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return;
    }
}
