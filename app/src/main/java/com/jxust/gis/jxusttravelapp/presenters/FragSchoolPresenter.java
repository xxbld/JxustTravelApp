package com.jxust.gis.jxusttravelapp.presenters;

import android.support.v4.app.Fragment;

import com.jxust.gis.jxusttravelapp.ui.fragment.FlashFragment;
import com.jxust.gis.jxusttravelapp.views.IFragSchoolView;

import org.github.xxbld.icemung.base.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xxbld on 2016/3/14
 * you can contact me at: 1024920618@qq.com
 *
 * @descript ：
 */
public class FragSchoolPresenter extends BasePresenter<IFragSchoolView> {

    public FragSchoolPresenter() {
    }

    @Override
    public void attachView(IFragSchoolView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void initialized() {
        this.getMvpView().initTabLayout(getTitles(), getTabFragments());
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("新鲜事");
        titles.add("新鲜事");
        titles.add("新鲜事");
        return titles;
    }

    private List<Fragment> getTabFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FlashFragment());
        fragments.add(new FlashFragment());
        fragments.add(new FlashFragment());
        return fragments;
    }
}
