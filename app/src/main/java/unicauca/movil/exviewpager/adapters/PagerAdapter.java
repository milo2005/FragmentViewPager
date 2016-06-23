package unicauca.movil.exviewpager.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Dario Chamorro on 20/06/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> data;

    public PagerAdapter(FragmentManager fm, List<Fragment> data) {
        super(fm);
        this.data = data;
    }


    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }


}
