package be.hevelaska.pdm;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import be.hevelaska.pdm.databinding.ActivityCypherBinding;
import be.hevelaska.pdm.model.cypher.Cypher;

public class CypherActivity extends AppCompatActivity {


    private ActivityCypherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCypherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        Cypher cypher = intent.getParcelableExtra("cypher");

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        assert cypher != null;
        binding.cypherName.setText(cypher.getName());
        binding.cypherLevel.setText(cypher.getLevel());
        binding.cypherType.setText(cypher.getType()== null ? "": cypher.getType().name());
        binding.effet.setText(cypher.getEffet());
        binding.utilisable.setText(cypher.getUtilisable());


    }

}