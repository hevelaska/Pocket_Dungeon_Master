package be.hevelaska.pdm.adapters;

import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;

import be.hevelaska.pdm.MonsterActivity;
import be.hevelaska.pdm.R;
import be.hevelaska.pdm.model.monster.Monster;

public class EncounterAdapter extends RecyclerView.Adapter<EncounterAdapter.MonsterViewHolder> {
    private List<Pair<Integer,Monster>> monsterList;

    public EncounterAdapter(List<Pair<Integer, Monster>> monsterList) {
        this.monsterList = monsterList;
    }

    public List<Pair<Integer,Monster>> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(List<Pair<Integer,Monster>> monsterList) {
        this.monsterList = monsterList;
    }

    @NonNull
    @Override
    public MonsterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_monster_encounter,parent,false);
        return new MonsterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MonsterViewHolder holder, int position) {
        holder.setMonster(monsterList.get(position).second);
        holder.setAmount(monsterList.get(position).first);
        holder.itemView.findViewById(R.id.cardView).setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), MonsterActivity.class);
            intent.putExtra("monster",monsterList.get(position).second);
            view.getContext().startActivity(intent);
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
            levelMonster.setText(String.format(Locale.getDefault(), "%d", monster.getLevel()));
            ImageView monsterPictures = itemView.findViewById(R.id.monsterPicture);

            Glide.with(itemView)
                    .load(monster.getImage())
                    .into(monsterPictures);

        }

        public void setAmount(int amount){
            TextView amountTextView = itemView.findViewById(R.id.amount);
            amountTextView.setText(String.format(Locale.getDefault(), "%d",amount));
        }
    }
}
