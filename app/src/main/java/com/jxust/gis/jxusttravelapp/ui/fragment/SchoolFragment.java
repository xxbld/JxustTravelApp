package com.jxust.gis.jxusttravelapp.ui.fragment;

import android.app.Activity;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.jxust.gis.jxusttravelapp.R;
import com.jxust.gis.jxusttravelapp.presenters.FragSchoolPresenter;
import com.jxust.gis.jxusttravelapp.ui.adapter.SchoolFragmentAdapter;
import com.jxust.gis.jxusttravelapp.ui.base.BaseFragment;
import com.jxust.gis.jxusttravelapp.views.IFragSchoolView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xxbld on 2016/3/22
 * you can contact me at: 1024920618@qq.com
 *
 * @descript ：
 */
public class SchoolFragment extends BaseFragment implements IFragSchoolView {

    TabLayout mTabLayout;
    @Bind(R.id.layout_viewpager)
    ViewPager mViewPager;

    FragSchoolPresenter mFragSchoolPresenter;
    SchoolFragmentAdapter mSchoolFragmentAdapter;

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void initViewsAndEvents() {
        mFragSchoolPresenter = new FragSchoolPresenter();
        mFragSchoolPresenter.attachView(this);
        mFragSchoolPresenter.initialized();
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.layout_viewpager;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mFragSchoolPresenter.detachView();
    }

    @Override
    public void onPause() {
        super.onPause();
        mTabLayout.setVisibility(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        mTabLayout.setVisibility(View.VISIBLE);
    }

    //==========impls
    @Override
    public void initTabLayout(List<String> tabTitles, List<Fragment> fragments) {
        mTabLayout = ButterKnife.findById((Activity) mContext, R.id.content_tab);
        mTabLayout.setVisibility(View.VISIBLE);

        mSchoolFragmentAdapter = new SchoolFragmentAdapter(getSupportFragmentManager(), fragments, tabTitles);
        mViewPager.setAdapter(mSchoolFragmentAdapter);
        //必须在viewpager.setAdapter之后
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
