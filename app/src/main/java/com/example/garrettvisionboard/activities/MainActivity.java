package com.example.garrettvisionboard.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.garrettvisionboard.fragments.BoardListFragment;
import com.example.garrettvisionboard.R;
import com.example.garrettvisionboard.model.Board;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT";
    BoardListFragment boardListFragment;
    List<Board> dummyBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            boardListFragment = new BoardListFragment();
            fragmentTransaction.add(R.id.main_activity_frame_layout, boardListFragment, TAG_LIST_FRAGMENT);
            fragmentTransaction.commit();
        }else{
            boardListFragment = (BoardListFragment) fragmentManager.findFragmentByTag(TAG_LIST_FRAGMENT);
        }

        dummyBoard = new ArrayList<>();
        dummyBoard.add((new Board("Travel", "Travel with family", R.drawable.maldivas)));
        dummyBoard.add((new Board("Buy a House", "Get my dream house", R.drawable.utah)));
        dummyBoard.add((new Board("Invest", "Travel with Save money for retirement", R.drawable.maldives)));
        dummyBoard.add((new Board("Be Free", "Have fun, man", R.drawable.ontario)));
        dummyBoard.add((new Board("Travel", "Travel with family", R.drawable.senegal)));
        dummyBoard.add((new Board("Buy a House", "Get my dream house", R.drawable.ic_launcher_background)));
        dummyBoard.add((new Board("Invest", "Travel with Save money for retirement", R.drawable.ic_launcher_background)));
        dummyBoard.add((new Board("Be Free", "Have fun, man", R.drawable.senegal)));
        dummyBoard.add((new Board("Travel", "Travel with family", R.drawable.maldives)));
        dummyBoard.add((new Board("Buy a House", "Get my dream house", R.drawable.utah)));
        dummyBoard.add((new Board("Invest", "Travel with Save money for retirement", R.drawable.maldivas)));
        dummyBoard.add((new Board("Be Free", "Have fun, man", R.drawable.ontario)));
        dummyBoard.add((new Board("Travel", "Travel with family", R.drawable.maldivas)));
        dummyBoard.add((new Board("Buy a House", "Get my dream house", R.drawable.utah)));
        dummyBoard.add((new Board("Invest", "Travel with Save money for retirement", R.drawable.senegal)));
        dummyBoard.add((new Board("Be Free", "Have fun, man", R.drawable.ic_launcher_background)));

        boardListFragment.setBoards(dummyBoard);
    }
}