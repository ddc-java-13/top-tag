package edu.cnm.deepdive.toptag.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import edu.cnm.deepdive.toptag.model.entity.HuntData;
import edu.cnm.deepdive.toptag.service.TopTagRepository;
import java.util.List;

/**
 * manages the lifecycle for UI
 */
public class HuntViewModel extends AndroidViewModel {

  private final TopTagRepository repository;
  private final LiveData<List<HuntData>> huntDataList;
  private final MutableLiveData<String> weaponChoice;
  private final MutableLiveData<String> seasonChoice;

  /**
   * provides data for list of live hunt data
   * @param application
   */
  public HuntViewModel(
      @NonNull Application application) {
    super(application);
    repository = new TopTagRepository(application);
    weaponChoice = new MutableLiveData<>();
    seasonChoice = new MutableLiveData<>();
    SelectionLiveData selectionLiveData = new SelectionLiveData(weaponChoice, seasonChoice);
    huntDataList = Transformations.switchMap(selectionLiveData,
        (selection) -> repository.getHuntData(selection.first, selection.second));
  }

  /**
   *  gets list of live hunt data
   * @return returns huntdata list
   */
  public LiveData<List<HuntData>> getHuntData() {

    return huntDataList;
  }

  /**
   * sets weapon choice
   * @param weaponChoice
   */
  public void setWeaponChoice(String weaponChoice) {
    this.weaponChoice.setValue(weaponChoice);
  }

  /**
   * sets season choice
   * @param seasonChoice
   */
  public void setSeasonChoice(String seasonChoice) {
    this.seasonChoice.setValue(seasonChoice);
  }

  private static class SelectionLiveData extends MediatorLiveData<Pair<String, String>> {

    /**
     * adds weapon choice and season choice to live data
     * @param weaponChoice
     * @param seasonChoice
     */
    public SelectionLiveData(LiveData<String> weaponChoice, LiveData<String> seasonChoice) {
      addSource(weaponChoice, (choice) -> setValue(new Pair<>(choice, seasonChoice.getValue())));
      addSource(seasonChoice, (choice) -> setValue(new Pair<>(weaponChoice.getValue(), choice)));
    }
  }

}