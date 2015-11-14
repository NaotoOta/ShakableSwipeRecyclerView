package jp.com.naonathan.mchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import jp.com.naonathan.shakableswiperecyclerview.ShakableSwipeRecyclerViewAdapter;

/**
 * Created by NaotoOta on 2015/11/14.
 *
 * @author NaotoOta
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        String[] mDataset = new String[]{"A", "B", "C", "D", "E", "F"};
        ShakableSwipeRecyclerViewAdapter mShakableSwipeRecyclerViewAdapter = new ShakableSwipeRecyclerViewAdapter(mDataset, R.layout.list_row, R.id.front);
        mRecyclerView.setAdapter(mShakableSwipeRecyclerViewAdapter);
    }
}
