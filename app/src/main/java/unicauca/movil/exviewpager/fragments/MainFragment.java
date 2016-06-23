package unicauca.movil.exviewpager.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import unicauca.movil.exviewpager.R;
import unicauca.movil.exviewpager.adapters.PagerAdapter;
import unicauca.movil.exviewpager.databinding.FragmentMainBinding;
import unicauca.movil.exviewpager.models.Info;
import unicauca.movil.exviewpager.util.L;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    FragmentMainBinding binding;

    public MainFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(getLayoutInflater(savedInstanceState));
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(), L.getMain());
        binding.setAdapter(adapter);
        return binding.getRoot();
    }


}
