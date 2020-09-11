package be.hevelaska.pdm.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import be.hevelaska.pdm.R;
import be.hevelaska.pdm.SearchCypherActivity;

public class TreasureFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dashboard_treasure,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        view.findViewById(R.id.research_treasure).setOnClickListener(this::searchCypher);
    }

    public void searchCypher(View view){
        Intent goToActivity = new Intent(getContext(), SearchCypherActivity.class);
        startActivity(goToActivity);
    }
}
