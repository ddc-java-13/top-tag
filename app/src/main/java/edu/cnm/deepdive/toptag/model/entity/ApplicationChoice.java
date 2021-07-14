package edu.cnm.deepdive.toptag.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    indices = {},
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            childColumns = {"user_id"},
            parentColumns = {"user_id"},
            onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
            entity = GameManagementUnit.class,
            childColumns = {"game_management_unit_id"},
            parentColumns = {"game_management_unit_id"},
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class ApplicationChoice {

  @PrimaryKey
  @ColumnInfo(name = "application_choice_id")
  private String id;

  private Date season;    /* TODO find better way to classify seas than date.*/

  @ColumnInfo(name = "user_id")
  private long userId;

  private WeaponType weaponType;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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

  private enum WeaponType {
    BOW, RIFLE
  }

}
