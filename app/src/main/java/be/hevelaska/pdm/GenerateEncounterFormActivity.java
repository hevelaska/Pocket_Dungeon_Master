package be.hevelaska.pdm;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import be.hevelaska.pdm.databinding.ActivityGenerateEncounterFormBinding;

public class GenerateEncounterFormActivity extends AppCompatActivity {

    private ActivityGenerateEncounterFormBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenerateEncounterFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCancel.setOnClickListener(view -> finish());
        binding.btnGenerate.setOnClickListener(view -> {
            Intent intent = new Intent(this,GenerateEncounterActivity.class);
            intent.putExtra("numberPlayers",binding.listeNombreJoueur.getSelectedItemPosition()+1);
            intent.putExtra("averageLevel",binding.listeLevel.getSelectedItemPosition()+1);
            startActivity(intent);
        });
    }


}