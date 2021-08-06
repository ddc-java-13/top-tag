package edu.cnm.deepdive.toptag.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.toptag.R;
import edu.cnm.deepdive.toptag.adapter.ApplicationAdapter;
import edu.cnm.deepdive.toptag.databinding.FragmentDashboardBinding;
import edu.cnm.deepdive.toptag.model.entity.HuntData;
import edu.cnm.deepdive.toptag.viewmodel.HuntViewModel;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class HuntFragment extends Fragment {

  private FragmentDashboardBinding binding;
  private List<HuntData> huntDataList;



  private HuntViewModel huntViewModel;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    huntViewModel = new ViewModelProvider(this).get(HuntViewModel.class);
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

  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    huntViewModel.getHuntData().observe(getViewLifecycleOwner(), (list) -> {
      this.huntDataList = list;
      if (list != null) {
        binding.dataTable.setAdapter(new ApplicationAdapter(list, getContext()));
      }
    });
  }
}
