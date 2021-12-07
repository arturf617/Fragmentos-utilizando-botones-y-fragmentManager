package com.paparazziteam.fragmentreplace.ui.main;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.paparazziteam.fragmentreplace.R;
import com.paparazziteam.fragmentreplace.fragments.BlankFragment;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    Button btnmostrar;

    TextView txtview;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.main_fragment, container, false);


        btnmostrar = vista.findViewById(R.id.btnMostrar);
        txtview = vista.findViewById(R.id.message);

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("TAG","Iniciando segundo Fragment");

                // Create new fragment and transaction
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);

                // Replace whatever is in the fragment_container view with this fragment
                transaction.replace(R.id.linearLayoutReemplazar, BlankFragment.newInstance("Antony",""));

                // Commit the transaction
                transaction.commit();


                //Ocultar botones
                btnmostrar.setVisibility(View.GONE);
                txtview.setVisibility(View.GONE);

                Log.e("TAG","Termino de mostrar el segundo Fragment");

            }
        });







        return vista;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}