package be.hevelaska.pdm;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import be.hevelaska.pdm.adapters.CypherAdapter;
import be.hevelaska.pdm.model.cypher.Cypher;
import be.hevelaska.pdm.services.BackendService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchCypherActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Cypher> oldList;

    private CypherAdapter cypherAdapter;

    private EditText searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_cypher);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.setOnKeyListener((view, i, keyEvent) -> {

            List<Cypher>filteredList = oldList
                        .stream()
                        .filter(cypher -> {
                            String typedtext = searchView.getText().toString();
                            return cypher.getName().toLowerCase().contains(typedtext.toLowerCase());
                        })
                        .collect(Collectors.toList());

            cypherAdapter.setCypherList(filteredList);
            cypherAdapter.notifyDataSetChanged();

            return false;
        });
        loadCypher();
    }

    public void loadCypher() {
        BackendService.getInstance().getCypherList()
                .enqueue(new Callback<List<Cypher>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Cypher>> call, @NonNull Response<List<Cypher>> response) {
                        if(response.body() == null){
                            Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            oldList = response.body();
                            cypherAdapter = new CypherAdapter(response.body());
                            recyclerView.setAdapter(cypherAdapter);
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Cypher>> call, @NonNull Throwable t) {
                        Log.e("cypher", Objects.requireNonNull(t.getLocalizedMessage()));
                        Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}