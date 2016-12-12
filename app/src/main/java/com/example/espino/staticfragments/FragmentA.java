package com.example.espino.staticfragments;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by espino on 25/11/16.
 */

public class FragmentA extends Fragment {

    public interface FragmentIterationListener{
        void onFragmentIterationListener(String text, int size);
    }

    private EditText editFragmentA;
    private SeekBar seekFragmentA;
    private Button btn_fragmentA;
    private FragmentIterationListener mCallback;

    public FragmentA(){
        super();
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        try{
            mCallback = (FragmentIterationListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implements FragmentIterationListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_a, container, false);
        editFragmentA = (EditText) rootView.findViewById(R.id.editText);
        seekFragmentA = (SeekBar) rootView.findViewById(R.id.seekBar);
        btn_fragmentA = (Button) rootView.findViewById(R.id.button);
        btn_fragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onFragmentIterationListener(editFragmentA.getText().toString(),seekFragmentA.getProgress());
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
