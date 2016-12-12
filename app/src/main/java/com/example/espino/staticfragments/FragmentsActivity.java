package com.example.espino.staticfragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class FragmentsActivity extends Activity implements FragmentA.FragmentIterationListener{

    public static final String TAG_FRAGMENT_A= "tag_a";

    private FragmentA fragmenta;
    private FragmentB fragmentb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
        FragmentManager fm = getFragmentManager();
        fragmenta = (FragmentA) fm.findFragmentByTag(TAG_FRAGMENT_A);

        if(fragmenta == null){
            fragmenta = new FragmentA();
            getFragmentManager().beginTransaction().add(R.id.activity_fragments, fragmenta, TAG_FRAGMENT_A).commit();
        }

    }

    @Override
    public void onFragmentIterationListener(String text, int size) {
        Bundle bnd = new Bundle();
        bnd.putString(FragmentB.TEXT_KEY,text);
        bnd.putFloat(FragmentB.SIZE_KEY, size);
        fragmentb = FragmentB.newInstance(bnd);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.activity_fragments, fragmentb);
        ft.addToBackStack(null);
        ft.commit();
    }


}
