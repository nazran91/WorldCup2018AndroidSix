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

import com.aiub.worldcup2018androidsix.Adapters.GroupRecyclerAdapter;
import com.aiub.worldcup2018androidsix.Database.DatabaseHelper;
import com.aiub.worldcup2018androidsix.ModelClasses.Team;
import com.aiub.worldcup2018androidsix.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchesFragment extends Fragment {

    public MatchesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_matches, container, false);


        return view;
    }
}
