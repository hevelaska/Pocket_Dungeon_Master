package be.hevelaska.pdm;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import be.hevelaska.pdm.databinding.ActivityGenerateEncounterFormBinding;
import be.hevelaska.pdm.databinding.ActivityMonsterBinding;

public class GenerateEncounterFormActivity extends AppCompatActivity {

    private ActivityGenerateEncounterFormBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGenerateEncounterFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}