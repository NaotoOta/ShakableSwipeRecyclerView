package jp.com.naonathan.mchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import jp.com.naonathan.shakableswiperecyclerview.ShakableSwipeRecyclerViewAdapter;
import jp.com.naonathan.shakableswiperecyclerview.ShakableSwipeRecyclerViewTouchListener;

/**
 * Created by NaotoOta on 2015/11/14.
 *
 * @author NaotoOta
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private ShakableSwipeRecyclerViewAdapter mShakableSwipeRecyclerViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ShakableSwipeRecyclerViewTouchListener mShakableSwipeRecyclerViewTouchListener;
    private String[] mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDataset = new String[]{"A", "B", "C"};
        mShakableSwipeRecyclerViewAdapter = new ShakableSwipeRecyclerViewAdapter(mDataset, R.layout.list_row, R.id.front);
        mRecyclerView.setAdapter(mShakableSwipeRecyclerViewAdapter);
    }
}
