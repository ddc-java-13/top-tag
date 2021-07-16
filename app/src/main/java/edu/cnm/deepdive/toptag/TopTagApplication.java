package edu.cnm.deepdive.toptag;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.toptag.service.TopTagDatabase;
import io.reactivex.schedulers.Schedulers;

/**
 * Initializes (in the {@link #onCreate()} method) application-level resources. This class
 * <strong>must</strong> be referenced in {@code AndroidManifest.xml}, or it will not be loaded and
 * used by the Android system.
 */
public class TopTagApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    TopTagDatabase.setContext(this);
    TopTagDatabase
        .getInstance()
        .getApplicationChoiceDao()
        .delete()
        .subscribeOn(Schedulers.io())
        .subscribe();

    Stetho.initializeWithDefaults(this);
  }

}
