package edu.cnm.deepdive.toptag.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.toptag.R;
import edu.cnm.deepdive.toptag.viewmodel.NotificationsViewModel;

/**
 * Inflates the notes fragment to the viewmodel.
 */
public class NotesFragment extends Fragment {

  private NotificationsViewModel notificationsViewModel;

  /**
   * Inflates to container.
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return  returns layout.
   */
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    notificationsViewModel =
        new ViewModelProvider(this).get(NotificationsViewModel.class);
    View root = inflater.inflate(R.layout.fragment_notes, container, false);
    final TextView textView = root.findViewById(R.id.text_notes);
    notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }
}