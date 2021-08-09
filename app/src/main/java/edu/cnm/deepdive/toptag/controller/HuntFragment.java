package edu.cnm.deepdive.toptag.controller;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.toptag.R;
import edu.cnm.deepdive.toptag.adapter.ApplicationAdapter;
import edu.cnm.deepdive.toptag.databinding.FragmentHuntBinding;
import edu.cnm.deepdive.toptag.viewmodel.HuntViewModel;

public class HuntFragment extends Fragment implements OnItemSelectedListener {

  private FragmentHuntBinding binding;

  private HuntViewModel huntViewModel;
  private String[] weaponChoices;
  private String[] seasonChoices;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    huntViewModel = new ViewModelProvider(this).get(HuntViewModel.class);
    binding = FragmentHuntBinding.inflate(inflater, container, false);
    Resources resources = getResources();
    weaponChoices = resources.getStringArray(R.array.weapon_choices);
    ArrayAdapter<String> adapterW = new ArrayAdapter<>(getContext(),
        android.R.layout.simple_spinner_item, weaponChoices);
    adapterW.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    binding.weaponSelect.setAdapter(adapterW);
    binding.weaponSelect.setOnItemSelectedListener(this);
    seasonChoices = resources.getStringArray(R.array.season_choices);
    ArrayAdapter<String> adapterS = new ArrayAdapter<>(getContext(),
        android.R.layout.simple_spinner_item, seasonChoices);
    adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    binding.seasonSelect.setAdapter(adapterS);
    binding.seasonSelect.setOnItemSelectedListener(this);

    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    huntViewModel.getHuntData().observe(getViewLifecycleOwner(), (list) -> {
      if (list != null) {
        binding.dataTable.setAdapter(new ApplicationAdapter(list, getContext()));
      }
    });
  }


  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    if (parent == binding.weaponSelect) {
      huntViewModel.setWeaponChoice(weaponChoices[position]);
    } else if (parent == binding.seasonSelect) {
      huntViewModel.setSeasonChoice(seasonChoices[position]);
    }

  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {

  }
}
