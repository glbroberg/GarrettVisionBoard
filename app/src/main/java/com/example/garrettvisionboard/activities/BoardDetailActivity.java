package com.example.garrettvisionboard.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.example.garrettvisionboard.R;
import com.example.garrettvisionboard.fragments.BoardDetailFragment;
import com.example.garrettvisionboard.fragments.BoardListFragment;
import com.example.garrettvisionboard.model.Board;

import static com.example.garrettvisionboard.R.id.board_detail_frame_layout;

public class BoardDetailActivity extends AppCompatActivity {
    BoardDetailFragment fragment;
    private static final String TAG_DETAIL_FRAGMENT = "TAG_DETAIL_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_detail);

        Board board = (Board)getIntent().getSerializableExtra(BoardListFragment.requestCode.Details.toString());
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.board_detail_frame_layout, BoardDetailFragment.newInstance(board), TAG_DETAIL_FRAGMENT);
            fragmentTransaction.commit();
        }

    }
}