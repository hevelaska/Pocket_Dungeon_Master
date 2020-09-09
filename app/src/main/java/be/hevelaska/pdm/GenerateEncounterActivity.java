package be.hevelaska.pdm;

import android.os.Bundle;
import android.util.Pair;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import be.hevelaska.pdm.adapters.EncounterAdapter;
import be.hevelaska.pdm.databinding.ActivityGenerateEncounterBinding;
import be.hevelaska.pdm.model.Monster;
import be.hevelaska.pdm.services.BackendService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenerateEncounterActivity extends AppCompatActivity {

    private ActivityGenerateEncounterBinding binding;
    private int averagePlayersLevel;
    private int numberOfPlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenerateEncounterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        averagePlayersLevel = getIntent().getIntExtra("averageLevel",1);
        numberOfPlayers =getIntent().getIntExtra("numberPlayers",1);
        generateEncounter(averagePlayersLevel,numberOfPlayers);
        binding.reloadButton.setOnClickListener(view -> generateEncounter(averagePlayersLevel,numberOfPlayers));

    }

    public void generateEncounter(int averagePlayersLevel,int numberOfPlayers){
        BackendService
                .getInstance()
                .getMonsterList()
                .enqueue(new Callback<List<Monster>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Monster>> call, @NonNull Response<List<Monster>> response) {
                        List<Pair<Integer, Monster>> listEncounter = new ArrayList<>();
                        assert response.body() != null;
                        listEncounter.add(Pair.create(1,response.body().get(0)));
                        EncounterAdapter encounterAdapter = new EncounterAdapter(listEncounter);
                        binding.recyclerView.setLayoutManager(new LinearLayoutManager(GenerateEncounterActivity.this));
                        binding.recyclerView.setAdapter(encounterAdapter);
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Monster>> call, @NonNull Throwable t) {
                        Toast.makeText(GenerateEncounterActivity.this,"Fail",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}