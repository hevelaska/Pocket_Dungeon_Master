package be.hevelaska.pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.bumptech.glide.Glide;

import be.hevelaska.pdm.databinding.ActivityMonsterBinding;
import be.hevelaska.pdm.model.Monster;

public class MonsterActivity extends AppCompatActivity {

    private ActivityMonsterBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMonsterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        Monster monster = intent.getParcelableExtra("monster");

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        binding.monsterName.setText(monster.getName());
        binding.monsterArmor.setText(String.valueOf(monster.getArmor()));
        binding.monsterCombat.setText(monster.getCombat());
        binding.monsterDamages.setText(String.valueOf(monster.getDamages()));
        //binding.monsterEncounterType.setText(monster.getEncounterType().name());
        binding.monsterEnvironment.setText(monster.getEnvironment());
        binding.monsterHealth.setText(String.valueOf(monster.getHealth()));
        binding.monsterInteraction.setText(monster.getInteraction());
        binding.monsterLevel.setText(String.valueOf(monster.getLevel()));
        binding.monsterLoot.setText(monster.getLoot());
        binding.monsterModifications.setText(monster.getModifications());
        binding.monsterMotive.setText(monster.getMotive());
        binding.monsterMovement.setText(monster.getMovementType() == null ? "": monster.getMovementType().name());

        Glide.with(this)
                .load(monster.getImage())
                .into(binding.monsterPicture);
        binding.monsterUse.setText(monster.getUse());
        binding.description.setText(monster.getDescription());



    }

}