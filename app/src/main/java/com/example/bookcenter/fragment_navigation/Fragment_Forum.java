package com.example.bookcenter.fragment_navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.bookcenter.ForumAdapter.ForumAdapter;
import com.example.bookcenter.R;
import com.example.bookcenter.fragmentforum.Bookmark;
import com.example.bookcenter.fragmentforum.Feed;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Fragment_Forum extends Fragment {

    ViewPager viewPagerforum;
    TabLayout tabLayoutforum;
    TabItem tabItem;

    View myfragment;

    public Fragment_Forum()
    {

    }
    public static Fragment_Forum getInstance()
    {
        return new Fragment_Forum();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        myfragment= inflater.inflate(R.layout.forum_fragment,container,false);
        viewPagerforum=myfragment.findViewById(R.id.pager);
        tabLayoutforum=myfragment.findViewById(R.id.tab_view);
        return myfragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setvViewpager(viewPagerforum);
        tabLayoutforum.setupWithViewPager(viewPagerforum);

        tabLayoutforum.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setvViewpager(ViewPager viewPagerforum) {

        ForumAdapter adapter = new ForumAdapter(getChildFragmentManager());


        adapter.addfragmetn(new Feed(),"Feed");
        adapter.addfragmetn(new Bookmark(),"Bookmark");

        viewPagerforum.setAdapter(adapter);
    }
}

