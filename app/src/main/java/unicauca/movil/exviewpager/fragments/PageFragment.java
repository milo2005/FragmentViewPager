package unicauca.movil.exviewpager.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import unicauca.movil.exviewpager.R;
import unicauca.movil.exviewpager.databinding.FragmentPageBinding;
import unicauca.movil.exviewpager.models.Info;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {


    FragmentPageBinding binding;
    Info info;

    public PageFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding =  FragmentPageBinding.inflate(getLayoutInflater(savedInstanceState));

        if(info != null){
            binding.setInfo(info);
        }

        return binding.getRoot();
    }

    public void setInfo(Info info) {
        this.info = info;
        if(binding!=null){
            binding.setInfo(info);
        }
    }
}
