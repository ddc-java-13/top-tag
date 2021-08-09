package edu.cnm.deepdive.toptag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.toptag.R;
import edu.cnm.deepdive.toptag.adapter.ApplicationAdapter.Holder;
import edu.cnm.deepdive.toptag.databinding.ItemUnitBinding;
import edu.cnm.deepdive.toptag.model.entity.HuntData;
import java.text.DecimalFormat;
import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<Holder>{

  private final List<HuntData> huntDataList;

  private Context context;

  private final LayoutInflater inflater;

  private final String valueFormat;

  public ApplicationAdapter(
      List<HuntData> huntDataList, Context context) {
    this.huntDataList = huntDataList;
    this.context = context;
    inflater = LayoutInflater.from(context);
    valueFormat = context.getString(R.string.value_format);
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    ItemUnitBinding binding = ItemUnitBinding.inflate(inflater, parent, false);
    return new Holder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return huntDataList.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final ItemUnitBinding binding;

    public Holder(@NonNull ItemUnitBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
      binding.getRoot();
    }

    private void bind(int position) {

      HuntData huntData = huntDataList.get(position);
      binding.unit.setText(String.format(huntData.getUnit()));
      binding.tag.setText(String.valueOf(huntData.getTag()));
      binding.application.setText(String.valueOf(huntData.getApplication()));
      double odds = (double)huntData.getTag() / huntData.getApplication();
      DecimalFormat df = new DecimalFormat("#" +'%');
      binding.percentage.setText(df.format(odds));


    }

  }

}
