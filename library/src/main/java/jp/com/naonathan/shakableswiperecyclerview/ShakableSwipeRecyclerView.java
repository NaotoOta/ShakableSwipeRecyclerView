package jp.com.naonathan.shakableswiperecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by NaotoOta on 2015/11/14.
 *
 * @author NaotoOta
 * @version 1.0
 */

public class ShakableSwipeRecyclerView extends RecyclerView {
    private static final String TAG = ShakableSwipeRecyclerView.class.getSimpleName();

    public static final int SWIPE_MODE_NONE = 0;


    public ShakableSwipeRecyclerView(Context context) {
        super(context);
    }
}
