package com.example.garrettvisionboard.adapters;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.garrettvisionboard.R;
import com.example.garrettvisionboard.model.Board;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BoardRecyclerViewAdapter extends RecyclerView.Adapter<BoardRecyclerViewAdapter.ViewHolder> {

    private List<Board> boardList;
    private OnBoardItemClickListener listener;

    public BoardRecyclerViewAdapter(List<Board> boardList) {

        this.boardList = boardList;
    }

    public void setOnBoardItemClickListener(OnBoardItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.board = boardList.get(position);
        holder.boardName.setText(boardList.get(position).getName());
        holder.imageView.setImageResource(boardList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return boardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final View parentView;
        private ImageView imageView;
        private TextView boardName;
        private Board board;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentView = itemView;
            boardName = itemView.findViewById(R.id.board_item_text_view);
            imageView = itemView.findViewById(R.id.board_item_image);

            parentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onBoardItemClick(view, position);
                        }
                    }
                }
            });
        }
    }

    public interface OnBoardItemClickListener {
        void onBoardItemClick(View itemView, int position);
    }
}
