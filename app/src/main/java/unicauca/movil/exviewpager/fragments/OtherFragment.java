package unicauca.movil.exviewpager.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unicauca.movil.exviewpager.adapters.PagerAdapter;
import unicauca.movil.exviewpager.databinding.FragmentMainBinding;
import unicauca.movil.exviewpager.models.Info;
import unicauca.movil.exviewpager.util.L;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment {

    FragmentMainBinding binding;
    PageFragment page1, page2, page3;

    public OtherFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(getLayoutInflater(savedInstanceState));
        loadData();
        return binding.getRoot();
    }

    private void loadData() {
        if(L.getOther().size()==0){
            Info info1 = new Info();
            info1.setTitle("Otro titulo 1");
            info1.setSubTitle("Otro Subtitulo 1");

            Info info2 = new Info();
            info2.setTitle("Otro titulo 2");
            info2.setSubTitle("Otro Subtitulo 2");

            Info info3 = new Info();
            info3.setTitle("Otro titulo 3");
            info3.setSubTitle("Otro Subtitulo 3");

            page1 =  new PageFragment();
            page1.setInfo(info1);

            page2 =  new PageFragment();
            page2.setInfo(info2);

            page3 =  new PageFragment();
            page3.setInfo(info3);

            L.getOther().add(page1);
            L.getOther().add(page2);
            L.getOther().add(page3);

        }else{
            page1 = (PageFragment) L.getOther().get(0);
            page2 = (PageFragment) L.getOther().get(1);
            page3 = (PageFragment) L.getOther().get(2);
        }

        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(), L.getOther());
        binding.setAdapter(adapter);
    }

}
