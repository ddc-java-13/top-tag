package edu.cnm.deepdive.toptag.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.toptag.model.entity.HuntData;
import edu.cnm.deepdive.toptag.service.TopTagRepository;
import java.util.List;

public class HuntViewModel extends AndroidViewModel {

  private final TopTagRepository repository;
  private final MutableLiveData<List<HuntData>> huntDataList;

  public HuntViewModel(
      @NonNull Application application) {
    super(application);
    repository = new TopTagRepository(application);
    huntDataList = new MutableLiveData<>();
  }

  public LiveData<List<HuntData>> getHuntData() {

    return repository.getHuntData();
  }


}