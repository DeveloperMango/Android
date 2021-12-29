

package com.example.testapp;


import android.app.ActionBar;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import static android.view.MotionEvent.ACTION_MOVE;

public class TouchScreenTest extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private TouchScreenAdapter adapter;

    View child;
    int position;

    private final View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {
            switch (event.getAction())
            {
                case ACTION_MOVE:
                    child = mRecyclerView.findChildViewUnder(event.getX(), event.getY());
                    if (child != null)
                    {
                        position = mRecyclerView.getChildAdapterPosition(child);
                        if (!adapter.getSelected(position))
                        {
                            adapter.setSelected(position, true);
                            break;
                        }
                    }
                    break;
                default:    break;
            }
            return false;
        }
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LOW_PROFILE
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_screen_test);

        mRecyclerView = findViewById(R.id.recyclerView);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 40);
        mRecyclerView.setLayoutManager(layoutManager);
        adapter = new TouchScreenAdapter(this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setOnTouchListener(mTouchListener);
    }
}

