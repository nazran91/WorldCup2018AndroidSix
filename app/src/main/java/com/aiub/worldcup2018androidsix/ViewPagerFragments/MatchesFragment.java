package com.aiub.worldcup2018androidsix.ViewPagerFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.aiub.worldcup2018androidsix.Adapters.GroupRecyclerAdapter;
import com.aiub.worldcup2018androidsix.Adapters.MatchesListAdapter;
import com.aiub.worldcup2018androidsix.Database.DatabaseHelper;
import com.aiub.worldcup2018androidsix.ModelClasses.MatchModel;
import com.aiub.worldcup2018androidsix.ModelClasses.Team;
import com.aiub.worldcup2018androidsix.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchesFragment extends Fragment {

    private DatabaseHelper databaseHelper;
    private List<MatchModel> matchList = new ArrayList<>();
    private ListView matchListView;

    public MatchesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(getActivity());
        matchList = databaseHelper.getAllMatches();
        Log.e("MatchesFragment", "" + matchList.size());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_matches, container, false);

        matchListView = view.findViewById(R.id.matchListView);
        MatchesListAdapter matchesListAdapter =
                new MatchesListAdapter(getActivity(), matchList);
        matchListView.setAdapter(matchesListAdapter);

        return view;
    }
}
