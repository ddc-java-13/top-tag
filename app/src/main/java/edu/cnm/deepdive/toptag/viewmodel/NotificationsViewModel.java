package edu.cnm.deepdive.toptag.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * extends UI for notes fragment
 */
public class NotificationsViewModel extends ViewModel {

  private MutableLiveData<String> mText;

  public NotificationsViewModel() {
    mText = new MutableLiveData<>();
    mText.setValue("This is notes fragment");
  }

  /**
   * not used yet
   * @return returns placeholder text
   */
  public LiveData<String> getText() {
    return mText;
  }
}