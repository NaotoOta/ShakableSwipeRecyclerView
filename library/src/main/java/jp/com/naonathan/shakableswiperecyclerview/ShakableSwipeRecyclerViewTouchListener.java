package jp.com.naonathan.shakableswiperecyclerview;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by NaotoOta on 2015/11/14.
 *
 * @author NaotoOta
 * @version 1.0
 */

public class ShakableSwipeRecyclerViewTouchListener implements RecyclerView.OnItemTouchListener {
    private static final String TAG = ShakableSwipeRecyclerViewTouchListener.class.getSimpleName();
    private int swipeMode;

    public void setSwipeMode(int swipeMode) {
        this.swipeMode = swipeMode;
    }

    protected boolean isSwipeEnabled() {
        return swipeMode != ShakableSwipeRecyclerView.SWIPE_MODE_NONE;
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        Log.e("", "000000");
        switch (MotionEventCompat.getActionMasked(e)) {
            case MotionEvent.ACTION_DOWN: {

            }

            case MotionEvent.ACTION_UP: {

            }

            case MotionEvent.ACTION_MOVE: {

            }
        }

        return true;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
