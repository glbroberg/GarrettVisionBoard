package com.example.garrettvisionboard.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.garrettvisionboard.R;
import com.example.garrettvisionboard.activities.BoardDetailActivity;
import com.example.garrettvisionboard.adapters.BoardRecyclerViewAdapter;
import com.example.garrettvisionboard.model.Board;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class BoardListFragment extends Fragment {

    public enum requestCode
    {
        Details
    }
    private RecyclerView recyclerView;
    private ArrayList<Board> boardArrayList = new ArrayList<>();
    private BoardRecyclerViewAdapter adapter = new BoardRecyclerViewAdapter(boardArrayList);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_board_list, container, false);
        // return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Context context = view.getContext();
        recyclerView = view.findViewById(R.id.board_list_recycler_view);
        // recyclerView.setLayoutManager(new LinearLayoutManager((context)));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    public void setBoards(final List<Board> boardList) {
        for (Board board : boardList) {
            if (!boardArrayList.contains(board)) {
                boardArrayList.add((board));
                adapter.notifyItemInserted(boardArrayList.indexOf(board));
            }
        }

        adapter.setOnBoardItemClickListener(new BoardRecyclerViewAdapter.OnBoardItemClickListener() {
            @Override
            public void onBoardItemClick(View itemView, int position) {
                Board board = boardArrayList.get(position);
                Intent i = new Intent(getContext(), BoardDetailActivity.class);
                i.putExtra(requestCode.Details.toString(), board);
                startActivityForResult(i, requestCode.Details.ordinal());
            }
        });

    }
}
