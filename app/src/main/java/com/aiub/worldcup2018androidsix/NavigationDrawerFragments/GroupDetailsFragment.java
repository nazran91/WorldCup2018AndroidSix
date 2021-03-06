package com.aiub.worldcup2018androidsix.NavigationDrawerFragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aiub.worldcup2018androidsix.Adapters.GroupDetailsFragmentPagerAdapter;
import com.aiub.worldcup2018androidsix.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupDetailsFragment extends Fragment {

    private TabLayout groupTablayout;
    private ViewPager viewPager;
    private String selectedGroupName;

    public GroupDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group_details, container, false);

        selectedGroupName = getArguments().getString("groupSelectedName");
        Log.e("GroupDetailsFragment", selectedGroupName);

        viewPager = view.findViewById(R.id.groupViewPager);
        groupTablayout = view.findViewById(R.id.groupTablayout);

        GroupDetailsFragmentPagerAdapter groupDetailsFragmentPagerAdapter
                = new GroupDetailsFragmentPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(groupDetailsFragmentPagerAdapter);
        groupTablayout.setupWithViewPager(viewPager);

        return view;
    }
}
