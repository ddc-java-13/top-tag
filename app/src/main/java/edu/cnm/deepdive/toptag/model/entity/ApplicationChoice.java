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
/**
 * Sets as Entity class.
 */
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

  /**
   * sets id.
   * @param gameManagementUnitId
   */
  public void setGameManagementUnitId(long gameManagementUnitId) {
    this.gameManagementUnitId = gameManagementUnitId;
  }

  /**
   * gets id.
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * sets id.
   * @param id
   */
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

  /**
   * gets user id.
   * @return
   */
  public long getUserId() {
    return userId;
  }

  /**
   * sets user id
   * @param userId
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * gets SeasonType enum value
   * @return
   */
  @NonNull
  public SeasonType getSeasonType() {
    return seasonType;
  }

  /**
   * sets Season Type enum value
   * @param seasonType
   */
  public void setSeasonType(@NonNull SeasonType seasonType) {
    this.seasonType = seasonType;
  }

  /**
   * gets weapon type enum
   * @return
   */
  public WeaponType getWeaponType() {
    return weaponType;
  }

  /**
   * sets weapon type enum
   * @param weaponType
   */
  public void setWeaponType(WeaponType weaponType) {
    this.weaponType = weaponType;
  }

  /**
   * season type enum values
   */
  public enum SeasonType {
    SEPT_EARLY, SEPT_LATE, OCT_EARLY, OCT_LATE;

    /**
     * converts season type enum to integer for database
     * @param value
     * @return return integer
     */
    @TypeConverter
    public static Integer integerValue(SeasonType value) {

      return (value != null) ? value.ordinal() : null;
    }

    /**
     * converts integer from database to season type enum value.
     * @param value
     * @return returns enum
     */
    @TypeConverter
    public static SeasonType valueOf(Integer value) {

      return (value != null) ? SeasonType.values()[value] : null;
    }

  }

  /**
   * sets weapon type enum values
   */
  public enum WeaponType {
    BOW, RIFLE;

    /**
     * converts enum to integer for database
     * @param value
     * @return returns integer
     */
    @TypeConverter
    public static Integer integerValue(WeaponType value) {

      return (value != null) ? value.ordinal() : null;

    }

    /**
     * converts integer from database to enum
     * @param value
     * @return returns enum
     */
    @TypeConverter
    public static WeaponType valueOf(Integer value) {

      return (value != null) ? WeaponType.values()[value] : null;
    }
  }

}
