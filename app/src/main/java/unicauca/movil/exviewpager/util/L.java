package unicauca.movil.exviewpager.util;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dario Chamorro on 20/06/2016.
 */
public class L {

    private static List<Fragment> main;
    public static List<Fragment> getMain() {
        if(main == null){
            main=  new ArrayList<>();
        }
        return main;
    }

    private static List<Fragment> other;
    public static List<Fragment> getOther() {
        if(other == null){
            other=  new ArrayList<>();
        }
        return other;
    }

}
