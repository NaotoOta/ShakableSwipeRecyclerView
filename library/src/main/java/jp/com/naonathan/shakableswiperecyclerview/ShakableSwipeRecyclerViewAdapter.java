package jp.com.naonathan.shakableswiperecyclerview;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * Created by NaotoOta on 2015/11/14.
 *
 * @author NaotoOta
 * @version 1.0
 */

public class ShakableSwipeRecyclerViewAdapter extends RecyclerView.Adapter<ShakableSwipeRecyclerViewAdapter.ViewHolder> {
    private int frontViewHolder;

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnTouchListener {
        private int frontViewId;
        private int x = 0;
        private boolean move_enabled = false;

        public ViewHolder(View view, int frontViewId) {
            super(view);
            this.frontViewId = frontViewId;
            view.setOnTouchListener(this);
        }

        // TODO 条件文きれいに
        // TODO 設定をライブラリ外からできるようにgetter,setterの用意
        // TODO なめらかに動く値の調査
        // TODO アニメーションの謎解明

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            final View frontView = v.findViewById(frontViewId);
            if (frontView.getVisibility() == View.VISIBLE) {
                switch (MotionEventCompat.getActionMasked(event)) {
                    case MotionEvent.ACTION_DOWN: {
                        TranslateAnimation translateAnimation = new TranslateAnimation(50, 0, 0, 0);
                        translateAnimation.setDuration(200);
                        frontView.startAnimation(translateAnimation);
                        x = (int) event.getX();
                        move_enabled = true;
                    }

                    case MotionEvent.ACTION_UP: {
                        if (move_enabled) {
                            int deltaX = (int) event.getX() - x;
                            // TODO この値は怪しい
                            if (deltaX < frontView.getWidth() /2) {
                                frontView.layout(0, (int) frontView.getY(), frontView.getWidth(), (int) frontView.getY() + frontView.getHeight());
                            } else {
                                TranslateAnimation translateAnimation = new TranslateAnimation(frontView.getWidth(), 0, frontView.getWidth()*2, 0);
                                translateAnimation.setDuration(200);
                                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                                    @Override
                                    public void onAnimationStart(Animation animation) {

                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {
                                        frontView.layout(frontView.getWidth(), (int) frontView.getY(), frontView.getWidth()*2, (int) frontView.getY()+frontView.getHeight());
                                        frontView.setAnimation(null);
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {

                                    }
                                });
                                frontView.startAnimation(translateAnimation);
                                frontView.setVisibility(View.GONE);
                            }
                            move_enabled = false;
                        } else {
                            frontView.layout(0, (int) frontView.getY(), frontView.getWidth(), (int) frontView.getY() + frontView.getHeight());
                        }
                    }

                    case MotionEvent.ACTION_MOVE: {
                        int deltaX = (int) event.getX() - x;
                        if (move_enabled) {
                            if (deltaX > 0) {
                                frontView.layout(deltaX, (int) frontView.getY(), frontView.getWidth() + deltaX, (int) frontView.getY() + frontView.getHeight());
                            }
                        } else {
                            move_enabled = true;
                        }
                    }
                }
            }
            return true;
        }
    }

    // TODO datasetいらない。adapterごと渡すようにする

    private String[] mDataSet;
    private int mViewId;

    public ShakableSwipeRecyclerViewAdapter(String[] dataSet, int viewId, int frontViewHolder) {
        mDataSet = dataSet;
        mViewId = viewId;
        this.frontViewHolder = frontViewHolder;
    }


    // TODO カスタムviewが可能なようにする

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mViewId, parent, false);
        return new ViewHolder(v, frontViewHolder);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

}
