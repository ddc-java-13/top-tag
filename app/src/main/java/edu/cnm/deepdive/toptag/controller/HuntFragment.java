package edu.cnm.deepdive.toptag.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.toptag.R;
import edu.cnm.deepdive.toptag.databinding.FragmentDashboardBinding;
import edu.cnm.deepdive.toptag.viewmodel.DashboardViewModel;

public class HuntFragment extends Fragment {

  private FragmentDashboardBinding binding;

  private DashboardViewModel dashboardViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentDashboardBinding.inflate(inflater, container, false);
    //noinspection rawtypes
    ArrayAdapter adapterW = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.weapon_array));
    binding.weaponSelect.setThreshold(1);
    binding.weaponSelect.setAdapter(adapterW);
    ArrayAdapter adapterS = new ArrayAdapter(getContext(), android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.season_array));
    binding.seasonSelect.setThreshold(1);
    binding.seasonSelect.setAdapter(adapterS);

    return binding.getRoot();

  }



  }
