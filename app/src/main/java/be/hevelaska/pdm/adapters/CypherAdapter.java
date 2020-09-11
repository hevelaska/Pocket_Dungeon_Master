package be.hevelaska.pdm.adapters;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import be.hevelaska.pdm.CypherActivity;
import be.hevelaska.pdm.R;
import be.hevelaska.pdm.model.cypher.Cypher;

public class CypherAdapter extends RecyclerView.Adapter<CypherAdapter.cypherViewHolder> {
    private List<Cypher> cypherList;

    public CypherAdapter(List<Cypher> cypherList) {
        this.cypherList = cypherList;
    }

    public List<Cypher> getCypherList() {
        return cypherList;
    }

    public void setCypherList(List<Cypher> cypherList) {
        this.cypherList = cypherList;
    }

    @NonNull
    @Override
    public cypherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_cypher,parent,false);
        return new cypherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull cypherViewHolder holder, int position) {
        holder.setCypher(cypherList.get(position));
        holder.itemView.findViewById(R.id.cardView).setOnClickListener((View.OnClickListener) view -> {
            Intent intent = new Intent(view.getContext(), CypherActivity.class);
            intent.putExtra("cypher", (Parcelable) cypherList.get(position));
            view.getContext().startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return cypherList.size();
    }

    public static class cypherViewHolder extends RecyclerView.ViewHolder {

        private Cypher cypher;

        public cypherViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setCypher(Cypher cypher) {
            this.cypher = cypher;

            TextView textViewCypherName = itemView.findViewById(R.id.cypherName);
            textViewCypherName.setText(cypher.getName());
            TextView levelCypher = itemView.findViewById(R.id.cypherLevel);
            levelCypher.setText(cypher.getLevel());

        }
    }
}
