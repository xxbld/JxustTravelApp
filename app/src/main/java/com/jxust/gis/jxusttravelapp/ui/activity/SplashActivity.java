package com.jxust.gis.jxusttravelapp.ui.activity;

import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.jxust.gis.jxusttravelapp.R;
import com.jxust.gis.jxusttravelapp.presenters.SplashPresenter;
import com.jxust.gis.jxusttravelapp.ui.base.BaseActivity;
import com.jxust.gis.jxusttravelapp.views.ISplashView;

import org.github.xxbld.icemung.utils.StatusBarUtil;

import butterknife.Bind;
import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;

public class SplashActivity extends BaseActivity implements ISplashView {

    @Bind(R.id.splash_frame)
    View mRevealView;
    @Bind(R.id.splash_img_bg)
    ImageView mImgBg;
    @Bind(R.id.splash_txt_versioncode)
    TextView mTxtVersioncode;
    @Bind(R.id.splash_txt_copyright)
    TextView mTxtCopyright;

    private SplashPresenter mSplashPresenter;
    private Handler handler = new Handler() {
    };

    @Override
    protected int getContentViewLayoutResID() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initViewsAndEvents() {
        StatusBarUtil.setTranslucent(this, false);
        mSplashPresenter = new SplashPresenter(this);
        mSplashPresenter.attachView(this);
        mSplashPresenter.initialized();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            setReveal();
        }
    }

    private void setReveal() {
        // get the center for the clipping circle
        int cx = (mRevealView.getLeft() + mRevealView.getRight()) / 2;
        int cy = (mRevealView.getTop() + mRevealView.getBottom()) / 2;

        // get the final radius for the clipping circle
        int dx = Math.max(cx, mRevealView.getWidth() - cx);
        int dy = Math.max(cy, mRevealView.getHeight() - cy);
        float finalRadius = (float) Math.hypot(dx, dy);

        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(mRevealView, cx, cy, 0, finalRadius);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setDuration(1500);
        animator.start();
    }

    @Override
    protected void setToolbar() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSplashPresenter.detachView();
    }

    //==========ISplashView Implements Method================

    @Override
    public void initViews(String copyright, String versionName, int bgResId) {
        mTxtCopyright.setText(copyright);
        mTxtVersioncode.setText(versionName);
        mImgBg.setBackgroundResource(bgResId);
    }

    @Override
    public void goHomePage() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goThenKill(WelcomeActivity.class);
            }
        }, 2000);
    }
}
