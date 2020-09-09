package be.hevelaska.pdm;

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
    }


}