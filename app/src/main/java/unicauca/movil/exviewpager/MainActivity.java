package unicauca.movil.exviewpager;

import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import unicauca.movil.exviewpager.fragments.MainFragment;
import unicauca.movil.exviewpager.fragments.OtherFragment;
import unicauca.movil.exviewpager.fragments.PageFragment;
import unicauca.movil.exviewpager.models.Info;
import unicauca.movil.exviewpager.util.L;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView nav;
    DrawerLayout drawer;

    MainFragment main;
    OtherFragment other;

    PageFragment mainPage1, mainPage2, mainPage3;

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(this);
        drawer = (DrawerLayout) findViewById(R.id.drawer);

        loadMainPages();

        main = new MainFragment();
        other = new OtherFragment();

        if(savedInstanceState!=null)
            id = savedInstanceState.getInt("nav");
        else
            id = R.id.nav_main;

        navFragment(id);
    }

    private void loadMainPages() {
        if(L.getMain().size()==0){
            Info info1 = new Info();
            info1.setTitle("Main titulo 1");
            info1.setSubTitle("Main Subtitulo 1");

            Info info2 = new Info();
            info2.setTitle("Main titulo 2");
            info2.setSubTitle("Main Subtitulo 2");

            Info info3 = new Info();
            info3.setTitle("Main titulo 3");
            info3.setSubTitle("MAin Subtitulo 3");

            mainPage1 =  new PageFragment();
            mainPage1.setInfo(info1);

            mainPage2 =  new PageFragment();
            mainPage2.setInfo(info2);

            mainPage3 =  new PageFragment();
            mainPage3.setInfo(info3);

            L.getMain().add(mainPage1);
            L.getMain().add(mainPage2);
            L.getMain().add(mainPage3);

        }else{
            mainPage1 = (PageFragment) L.getMain().get(0);
            mainPage2 = (PageFragment) L.getMain().get(1);
            mainPage3 = (PageFragment) L.getMain().get(2);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        navFragment(item.getItemId());
        drawer.closeDrawers();

        return false;
    }

    private void navFragment(int id){
        this.id = id;
        switch (id){
            case R.id.nav_main:
                putFragment(R.id.container, main);
                break;
            case R.id.nav_other:
                putFragment(R.id.container, other);
                break;
        }
    }

    private void putFragment(int container, Fragment fragment){
        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        ft.replace(container, fragment);
        ft.commit();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("nav", id);
        super.onSaveInstanceState(outState);

    }
}
