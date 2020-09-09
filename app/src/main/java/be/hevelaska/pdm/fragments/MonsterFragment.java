package be.hevelaska.pdm.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import be.hevelaska.pdm.GenerateEncounterFormActivity;
import be.hevelaska.pdm.R;
import be.hevelaska.pdm.SearchMonsterActivity;

public class MonsterFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dashboard_monster,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view,@Nullable Bundle savedInstanceState){
        view.findViewById(R.id.research_monster).setOnClickListener(this::searchMonster);
        view.findViewById(R.id.generate_monster).setOnClickListener(this::generateEncounter);
    }

    public void searchMonster(View view){
        Intent goToActivity = new Intent(getContext(), SearchMonsterActivity.class);
        startActivity(goToActivity);
    }

    public void generateEncounter(View view){
        Intent goToActivity = new Intent(getContext(), GenerateEncounterFormActivity.class);
        startActivity(goToActivity);
    }
}
