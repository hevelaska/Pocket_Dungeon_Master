package be.hevelaska.pdm.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import be.hevelaska.pdm.MonsterActivity;
import be.hevelaska.pdm.R;
import be.hevelaska.pdm.model.Monster;

public class MonsterAdapter extends RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder> {
    private List<Monster> monsterList;

    public MonsterAdapter(List<Monster>monsterList) {
        this.monsterList = monsterList;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    @NonNull
    @Override
    public MonsterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_monster,parent,false);
        return new MonsterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonsterViewHolder holder, int position) {
        holder.setMonster(monsterList.get(position));
        holder.itemView.findViewById(R.id.cardView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MonsterActivity.class);
                intent.putExtra("monster",monsterList.get(position));
                view.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return monsterList.size();
    }

    public static class MonsterViewHolder extends RecyclerView.ViewHolder {

        private Monster monster;

        public MonsterViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setMonster(Monster monster) {
            this.monster = monster;

            TextView textViewMonsterName = itemView.findViewById(R.id.monsterName);
            textViewMonsterName.setText(monster.getName());
            TextView levelMonster = itemView.findViewById(R.id.monsterLevel);
            levelMonster.setText(String.format("%d", monster.getLevel()));
            ImageView monsterPictures = itemView.findViewById(R.id.monsterPicture);

            Glide.with(itemView)
                    .load(monster.getImage())
                    .into(monsterPictures);

        }
    }
}
