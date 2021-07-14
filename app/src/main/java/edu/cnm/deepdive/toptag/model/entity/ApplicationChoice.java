package edu.cnm.deepdive.toptag.model.entity;

import androidx.annotation.InspectableProperty.EnumEntry;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import java.util.Date;

public class ApplicationChoice {

  @PrimaryKey
  @ColumnInfo(name = "application_choice")
  private String applicationChoice;

  @Expose
  private Date season;

  @Expose
  @ColumnInfo(name = "user_id")
  private long userId;                                // TODO Ask about enum field.


  public String getApplicationChoice() {
    return applicationChoice;
  }

  public void setApplicationChoice(String applicationChoice) {
    this.applicationChoice = applicationChoice;
  }

  public Date getSeason() {
    return season;
  }

  public void setSeason(Date season) {
    this.season = season;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  @EnumEntry(name = "weapon_type", value = 0)
  private enum weaponType {}
}
