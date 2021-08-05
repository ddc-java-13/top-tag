package edu.cnm.deepdive.toptag.model.entity;

import androidx.annotation.NonNull;
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
  private long id;

  @NonNull
  @ColumnInfo(name = "game_management_unit_id", index = true)
  private long  gameManagementUnitId;


  @NonNull
  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @NonNull
  @ColumnInfo(name = "season_type", index = true)
  private SeasonType seasonType;                       /* TODO find better way to classify season than date.*/

  @NonNull
  @ColumnInfo(name = "weapon_type", index = true)
  private WeaponType weaponType;

  @NonNull
  public long getGameManagementUnitId() {
    return gameManagementUnitId;
  }

  public void setGameManagementUnitId(long gameManagementUnitId) {
    this.gameManagementUnitId = gameManagementUnitId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

//  public String getSeason() {
//    return season;
//  }
//
//  public void setSeason(String season) {
//    this.season = season;
//  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  @NonNull
  public SeasonType getSeasonType() {
    return seasonType;
  }

  public void setSeasonType(@NonNull SeasonType seasonType) {
    this.seasonType = seasonType;
  }

  public WeaponType getWeaponType() {
    return weaponType;
  }

  public void setWeaponType(WeaponType weaponType) {
    this.weaponType = weaponType;
  }

  public enum SeasonType {
    SEPT_EARLY, SEPT_LATE, OCT_EARLY, OCT_LATE;

    @TypeConverter
    public static Integer integerValue(SeasonType value) {

      return (value != null) ? value.ordinal() : null;
    }

    @TypeConverter
    public static SeasonType valueOf(Integer value) {

      return (value != null) ? SeasonType.values()[value] : null;
    }

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
