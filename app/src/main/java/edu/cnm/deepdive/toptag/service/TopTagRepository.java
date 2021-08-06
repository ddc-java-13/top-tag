package edu.cnm.deepdive.toptag.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.toptag.model.dao.HuntDataDao;
import edu.cnm.deepdive.toptag.model.entity.HuntData;
import java.util.List;

public class TopTagRepository {

  private final Context context;

  private final HuntDataDao huntDataDao;

  public TopTagRepository(Context context) {
    this.context = context;
    TopTagDatabase database = TopTagDatabase.getInstance();
    huntDataDao = database.getHuntDataDao();
  }

  public LiveData<List<HuntData>> getHuntData() {

    return huntDataDao.selectUnit();
  }

}
