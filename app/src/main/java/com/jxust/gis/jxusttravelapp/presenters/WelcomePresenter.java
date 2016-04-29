package com.jxust.gis.jxusttravelapp.presenters;


import com.jxust.gis.jxusttravelapp.R;
import com.jxust.gis.jxusttravelapp.views.IWelcomeView;

import org.github.xxbld.icemung.base.mvp.BasePresenter;

/**
 * Created by xxbld on 2016/3/14
 * you can contact me at: 1024920618@qq.com
 *
 * @descript ：
 */
public class WelcomePresenter extends BasePresenter<IWelcomeView> {

    private static final int PAGE_NUM = 5;

    public WelcomePresenter() {
    }

    @Override
    public void attachView(IWelcomeView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void initialized() {
        getMvpView().initViewPager(getPageNum());

        int[] selects = getDotsViewSelect();
        getMvpView().initDotsView(selects[0], selects[1], getPageNum());
    }

    public void goLoginOrHome() {
        getMvpView().goLoginOrHome();
    }

    private int getPageNum() {
        return PAGE_NUM;
    }

    private int[] getDotsViewSelect() {
        return new int[]{R.drawable.dot_selected, R.drawable.dot_unselected};
    }
}
