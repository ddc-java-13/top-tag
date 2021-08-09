package edu.cnm.deepdive.toptag.model.pojo;

import androidx.lifecycle.LiveData;
import androidx.room.Relation;
import edu.cnm.deepdive.toptag.model.entity.ApplicationChoice;
import edu.cnm.deepdive.toptag.model.entity.HuntData;
import java.util.List;

public class HuntInfo extends HuntData {

  @Relation(
      entity = ApplicationChoice.class,
      entityColumn = "season_type",
      parentColumn = "weapon_type"
  )
  private String unit;

  @Override
  public String getUnit() {
    return unit;
  }

  @Override
  public void setUnit(String unit) {
    this.unit = unit;
  }
}
