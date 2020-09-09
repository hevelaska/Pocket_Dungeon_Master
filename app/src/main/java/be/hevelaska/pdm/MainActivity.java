package be.hevelaska.pdm;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import be.hevelaska.pdm.adapters.DashboardFragmentAdapter;

public class MainActivity extends FragmentActivity {

    DashboardFragmentAdapter dashboardFragmentAdapter;
    ViewPager2 viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dashboardFragmentAdapter = new DashboardFragmentAdapter(this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(dashboardFragmentAdapter);
        tabLayout = findViewById(R.id.appBarLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(position == 0 ? getString(R.string.tab_monsters) : getString(R.string.tab_treasure))
        ).attach();
    }
}