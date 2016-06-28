package com.example.vale.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapterPropio extends FragmentStatePagerAdapter {

    //Simplemente llamo al contrstructor del padre
    public PageAdapterPropio(FragmentManager fm) {
        super(fm);
    }

    //De forma similar al GETVIEW, este adpater también devuelve una vista
    //pero en este caso, es un Fragment! (y se llama getItem)
    @Override
    public Fragment getItem(int posicion) {

        Fragment fragment = null;

       switch (posicion)
       {
           case 0: fragment = new ScreenFragment1(); break;
           default: fragment = new ScreenFragment2();
       }

        return  fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    //sobrrescribo este método para que se pinte el tab como parte
    //del fragtment
    @Override
    public CharSequence getPageTitle(int position) {
        return MainActivity.getTitulo(position);
    }
}
