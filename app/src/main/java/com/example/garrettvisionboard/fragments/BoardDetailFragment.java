package com.example.garrettvisionboard.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.garrettvisionboard.R;
import com.example.garrettvisionboard.model.Board;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BoardDetailFragment extends Fragment {

    private TextView boardNameTextView;
    private TextView boardDetailsTextView;
    private ImageView boardImageImageView;
    private Board board;

    enum IntentExtra {
        Board
    }

    public static BoardDetailFragment newInstance(Board board) {
        BoardDetailFragment fragment = new BoardDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(IntentExtra.Board.toString(), board);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            board = (Board) getArguments().getSerializable(IntentExtra.Board.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SetViews(view);

        if (savedInstanceState == null) {
            if (board != null) {
                setPageContent();
            }
        }
    }

    private void setPageContent() {
        boardDetailsTextView.setText(board.getDescription());
        boardNameTextView.setText(board.getName());
        boardImageImageView.setImageResource(board.getImageUrl());
    }

    private void SetViews(View view) {
        boardDetailsTextView = view.findViewById(R.id.detail_fragment_item_description);
        boardNameTextView = view.findViewById(R.id.detail_fragment_item_name);
        boardImageImageView = view.findViewById(R.id.detail_fragment_image_view);

    }
}
