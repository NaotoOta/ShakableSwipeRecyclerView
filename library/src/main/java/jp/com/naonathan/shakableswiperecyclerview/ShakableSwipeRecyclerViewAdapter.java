package jp.com.naonathan.shakableswiperecyclerview;

import android.app.Activity;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

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

        public ViewHolder(View view, int frontViewId) {
            super(view);
            this.frontViewId = frontViewId;
            view.setOnTouchListener(this);
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int x = 0;
            View frontView = v.findViewById(frontViewId);
            switch (MotionEventCompat.getActionMasked(event)) {
                case MotionEvent.ACTION_DOWN: {
                    TranslateAnimation translateAnimation = new TranslateAnimation(50, 0, 0, 0);
                    translateAnimation.setDuration(200);
                    frontView.startAnimation(translateAnimation);
                    x = (int) event.getX();
                }

                case MotionEvent.ACTION_UP: {
                    int deltaX = (int) event.getX() - x;
                    deltaX = deltaX/10;
                    if(deltaX < frontView.getWidth()/2) {
                    } else {
                        frontView.setVisibility(View.INVISIBLE);
                    }
                }

                case MotionEvent.ACTION_MOVE: {
                    int deltaX = (int) event.getX() - x;
                    deltaX = deltaX/10;
                    frontView.layout((int) frontView.getX()+deltaX, (int) frontView.getY(), (int) frontView.getX()+frontView.getWidth(), (int) frontView.getY()+frontView.getHeight());
                }
            }
            return true;
        }
    }

    private String[] mDataset;
    private int mViewId;

    public ShakableSwipeRecyclerViewAdapter(String[] dataset, int viewId, int frontViewHolder) {
        mDataset = dataset;
        mViewId = viewId;
        this.frontViewHolder = frontViewHolder;
    }

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
        return mDataset.length;
    }

}
