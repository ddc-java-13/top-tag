package edu.cnm.deepdive.toptag.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import java.util.Date;

@Entity(
    tableName = "application_choice",
    indices = {
        @Index(value = "season"),
        @Index(value = "weapon_type")
    },
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

  @ColumnInfo(name = "season_id")
  private String season;    /* TODO find better way to classify season than date.*/

  @ColumnInfo(name = "user_id")
  private long userId;

  @ColumnInfo(name = "weapon_type")
  private WeaponType weaponType;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public enum WeaponType {
    BOW, RIFLE;

    @TypeConverter
    public static Integer integerValue(WeaponType value) {

      return (value != null) ? value.ordinal() : null;

    }

    @TypeConverter
    public static WeaponType valueOf(Integer value) {

      return (value != null) ? WeaponType.values()[value] : null;
    }
  }

}
