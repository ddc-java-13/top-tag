package edu.cnm.deepdive.toptag.service;

import android.content.Context;
import android.content.res.Resources;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.toptag.R;
import edu.cnm.deepdive.toptag.model.dao.HuntDataDao;
import edu.cnm.deepdive.toptag.model.entity.HuntData;
import java.util.List;

/**
 * Creats app repository
 */
public class TopTagRepository {

  private final Context context;
  private final String[] weaponChoices;
  private final String[] seasonChoices;
  private final HuntDataDao huntDataDao;

  /**
   * Gets weapon choice and season choice arrays from database
   * @param context
   */
  public TopTagRepository(Context context) {
    this.context = context;
    Resources resources = context.getResources();
    weaponChoices = resources.getStringArray(R.array.weapon_choices);
    seasonChoices = resources.getStringArray(R.array.season_choices);
    TopTagDatabase database = TopTagDatabase.getInstance();
    huntDataDao = database.getHuntDataDao();
  }

  /**
   * Gets data from data base and creates a filtered query.
   * @param weaponChoice
   * @param seasonChoice
   * @return selected filtered query of bow, rifle, septEarly, septLate, octEarly and octLate
   */
  public LiveData<List<HuntData>> getHuntData(String weaponChoice, String seasonChoice) {
    Boolean bow = null;
    Boolean rifle = null;
    Boolean septEarly = null;
    Boolean septLate = null;
    Boolean octEarly = null;
    Boolean octLate = null;

    if (weaponChoice != null) {
      if (weaponChoice.equals(weaponChoices[1])) {
        bow = true;
      } else if (weaponChoice.equals(weaponChoices[2])) {
        rifle = true;
      }
    }
    if (seasonChoice != null ) {
       if (seasonChoice.equals(seasonChoices[1])) {
         septEarly = true;
       } else if (seasonChoice.equals(seasonChoices[2])) {
         septLate = true;
       } else if (seasonChoice.equals(seasonChoices[3])) {
         octEarly = true;
       } else if (seasonChoice.equals(seasonChoices[4])) {
         octLate = true;
       }
    }
    return huntDataDao.selectFiltered(bow, rifle, septEarly, septLate, octEarly, octLate);
  }

}
