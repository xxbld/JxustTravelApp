package com.jxust.gis.jxusttravelapp.ui.base;

import android.os.Bundle;
import android.view.View;

import org.github.xxbld.icemung.base.BaseAppCompatActivity;
import org.github.xxbld.icemung.base.mvp.IMvpView;
import org.github.xxbld.icemung.netsatus.NetUtils;

/**
 * Created by xxbld on 2016/2/19
 * you can contact me at: 1024920618@qq.com
 *
 * @descript ：
 */
public abstract class BaseActivity extends BaseAppCompatActivity implements IMvpView {

//    protected Toolbar mToolbar;

    /**
     * 开启切换动画
     *
     * @return
     */
    @Override
    protected boolean isOverridePendingTransition() {
        return true;
    }

    /**
     * 切换动画默认设置为右进左出
     *
     * @return
     */
    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT_LEFT;
    }

    @Override
    protected int getContentViewLayoutResID() {
        return 0;
    }

    /**
     * default set root of layout
     *
     * @return
     */
    @Override
    protected View getLoadingTargetView() {
        return null;
//        return ((ViewGroup) this.findViewById(android.R.id.content)).getChildAt(0);
    }

    @Override
    protected void handleBundleExtras(Bundle extras) {

    }

    @Override
    protected void onNetConnected(NetUtils.NetType netType) {

    }

    @Override
    protected void onNetDisConnected() {
    }

    @Override
    protected void initViewsAndEvents() {
    }

    /**
     * 此处setCommonToolbar
     *
     * @param layoutResID
     */
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setToolbar();
    }

    /**
     * set toolbar
     */
//    private void setToolbar() {
//        mToolbar = ButterKnife.findById(this, R.id.common_toolbar);
//        if (mToolbar != null) {
//            setSupportActionBar(mToolbar);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
////            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
//        }
//    }
    protected abstract void setToolbar();

    //====================impls
    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showException(String msg) {

    }

    @Override
    public void showNetError() {

    }
}
