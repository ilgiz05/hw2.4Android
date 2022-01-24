package com.example.hw24android.boarding;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.hw24android.databinding.FragmentBoardBinding;
import com.example.hw24android.databinding.FragmentHomeBinding;
import com.example.hw24android.databinding.FragmentMainBoardBinding;
import com.example.hw24android.interfaces.ItemClickListener;
import com.example.hw24android.R;
import com.example.hw24android.adapter.ViewPagerAdapter;
import com.example.hw24android.client.ViewPagerClient;

import com.example.lesson34android2.model.ViewPagerModel;


import java.util.ArrayList;


public class MainBoardFragment extends Fragment  implements ItemClickListener {
    private @NonNull FragmentMainBoardBinding binding;
    ViewPagerAdapter adapter;
    ArrayList<ViewPagerModel> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  FragmentMainBoardBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkOnShow();
        getData();

    }
    private void checkOnShow() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        boolean isShow = sharedPreferences.getBoolean("isShow", false);
        if (isShow)
            Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
    }
    private void getData() {
        list = ViewPagerClient.getPagerlist();
        adapter = new ViewPagerAdapter(list,this);

    }

    @Override
    public void itemClick() {
        Navigation.findNavController(requireView()).navigate(R.id.homeFragment);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("isShow",true).apply();
    }
}