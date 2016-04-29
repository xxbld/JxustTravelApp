package org.github.xxbld.icemung.base.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by xxbld on 2016/1/19.
 * you can contact me at: 1024920618@qq.com
 *
 * @description :
 */
public class BaseListViewHolder {
    private final SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context mContext;

    private BaseListViewHolder(Context context, ViewGroup parent, int layoutId,
                               int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<>();
        this.mContext = context;
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        // setTag
        mConvertView.setTag(this);
    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static BaseListViewHolder get(Context context, View convertView,
                                         ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new BaseListViewHolder(context, parent, layoutId, position);
        }
        return (BaseListViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public BaseListViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public BaseListViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param bm
     * @return
     */
    public BaseListViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片==网络加载
     *
     * @param viewId
     * @param netUrl
     * @return
     */
    public BaseListViewHolder setImageByNetUrl(int viewId, String netUrl) {
        Glide.with(mContext).load(netUrl).into((ImageView) getView(viewId));
        return this;
    }

    public int getPosition() {
        return mPosition;
    }
}
