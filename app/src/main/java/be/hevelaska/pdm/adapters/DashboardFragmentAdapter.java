package be.hevelaska.pdm.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import be.hevelaska.pdm.fragments.MonsterFragment;
import be.hevelaska.pdm.fragments.TreasureFragment;

public class DashboardFragmentAdapter extends FragmentStateAdapter {

    public DashboardFragmentAdapter(FragmentActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new MonsterFragment();
        }
        else {
            return new TreasureFragment();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
