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

import be.hevelaska.pdm.adapters.MonsterAdapter;
import be.hevelaska.pdm.model.monster.Monster;
import be.hevelaska.pdm.services.BackendService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchMonsterActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Monster> oldList;

    private MonsterAdapter monsterAdapter;

    private EditText searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_monster);

        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        searchView.setOnKeyListener((view, i, keyEvent) -> {

            List<Monster>filteredList = oldList
                        .stream()
                        .filter(monster -> {
                            String typedtext = searchView.getText().toString();
                            return monster.getName().toLowerCase().startsWith(typedtext.toLowerCase());
                        })
                        .collect(Collectors.toList());

            monsterAdapter.setMonsterList(filteredList);
            monsterAdapter.notifyDataSetChanged();

            return false;
        });
        loadMonster();
    }

    public void loadMonster() {
        BackendService.getInstance().getMonsterList()
                .enqueue(new Callback<List<Monster>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Monster>> call, @NonNull Response<List<Monster>> response) {
                        oldList =response.body();
                        monsterAdapter = new MonsterAdapter(response.body());
                        recyclerView.setAdapter(monsterAdapter);

                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Monster>> call, @NonNull Throwable t) {
                        Log.e("monsters", Objects.requireNonNull(t.getLocalizedMessage()));
                        Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}