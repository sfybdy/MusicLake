package com.cyl.musiclake.ui.localmusic.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.cyl.musiclake.R;
import com.cyl.musiclake.ui.localmusic.adapter.ViewPagerAdapter;
import com.cyl.musiclake.ui.base.BaseFragment;

/**
 * Created by yonglong on 2016/11/26.
 */

public class DownloadFragment extends BaseFragment {
    //Toolbar
    Toolbar mToolbar;
    //TabLayout
    TabLayout mTabLayout;

    ViewPager mViewPager;

    public static DownloadFragment newInstance() {

        Bundle args = new Bundle();

        DownloadFragment fragment = new DownloadFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initDatas() {
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);

        if (mViewPager != null) {
            setupViewPager(mViewPager);
            mViewPager.setOffscreenPageLimit(3);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.frag_main;
    }

    @Override
    public void initViews() {
        mToolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);

        final ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_18dp);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setTitle("");
        }
        mTabLayout = (TabLayout) rootView.findViewById(R.id.tabs);
        mTabLayout.setSelectedTabIndicatorHeight(5);
        mViewPager = (ViewPager) rootView.findViewById(R.id.m_viewpager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new DownloadingFragment().newInstance(1), "正在下载");
        adapter.addFragment(new DownloadingFragment().newInstance(0), "已下载");
        viewPager.setAdapter(adapter);
    }

}