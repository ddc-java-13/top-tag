package edu.cnm.deepdive.toptag.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.toptag.model.entity.ApplicationChoice.WeaponType;
import java.util.Date;

/**
 * sets class as entity for hunt data
 */
@Entity(tableName = "hunt_data")
public class HuntData {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "hunt_data_id")
  private long id;

  @NonNull
  @ColumnInfo(index = true)
  private Date created = new Date();

  private String unit;

  private Integer tag;

  private Integer application;

  private Boolean bow;

  private Boolean rifle;

  @ColumnInfo(name = "sept_early")
  private Boolean septEarly;

  @ColumnInfo(name = "sept_late")
  private Boolean septLate;

  @ColumnInfo(name = "oct_early")
  private Boolean octEarly;

  @ColumnInfo(name = "oct_late")
  private Boolean octLate;

  /**
   * gets ung data id
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * sets hunt data id
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * gets craeted date
   * @return returns created date
   */
  @NonNull
  public Date getCreated() {
    return created;
  }

  /**
   * sets created date
   * @param created
   */
  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  /**
   * gets unit as string
   * @return
   */
  public String getUnit() {
    return unit;
  }

  /**
   * sets unit as string
   * @param unit
   */
  public void setUnit(String unit) {
    this.unit = unit;
  }

  /**
   * gets tag
   * @return  returns tag integer
   */
  public Integer getTag() {
    return tag;
  }

  /**
   * sets tag
   * @param tag
   */
  public void setTag(Integer tag) {
    this.tag = tag;
  }

  /**
   * gets application
   * @return returns application as integer
   */
  public Integer getApplication() {
    return application;
  }

  /**
   * sets application
   * @param application
   */
  public void setApplication(Integer application) {
    this.application = application;
  }

  /**
   * gets bow boolean
   * @return returns bow boolean
   */
  public Boolean getBow() {
    return bow;
  }

  /**
   * sets bow
   * @param bow
   */
  public void setBow(Boolean bow) {
    this.bow = bow;
  }

  /**
   * gets rifle boolean
   * @return returns rifle boolean
   */
  public Boolean getRifle() {
    return rifle;
  }

  /**
   * sets rifle
   * @param rifle
   */
  public void setRifle(Boolean rifle) {
    this.rifle = rifle;
  }

  /**
   * gets boolean value of season septEarly
   * @return returns septEarly
   */
  public Boolean getSeptEarly() {
    return septEarly;
  }

  /**
   * sets septEarly
   * @param septEarly
   */
  public void setSeptEarly(Boolean septEarly) {
    this.septEarly = septEarly;
  }

  /**
   * gets boolean value of season septLate
   * @return returns setpLate
   */
  public Boolean getSeptLate() {
    return septLate;
  }

  /**
   * sets boolean of season septLate
   * @param septLate
   */
  public void setSeptLate(Boolean septLate) {
    this.septLate = septLate;
  }

  /**
   * gets boolean value of season octEarly
   * @return returns octEarly
   */
  public Boolean getOctEarly() {
    return octEarly;
  }

  /**
   * sets boolean of season octEarly
   * @param octEarly
   */
  public void setOctEarly(Boolean octEarly) {
    this.octEarly = octEarly;
  }

  /**
   * gets boolean value of octLate
   * @return octLate
   */
  public Boolean getOctLate() {
    return octLate;
  }

  /**
   * sets boolean value of octLate
   * @param octLate
   */
  public void setOctLate(Boolean octLate) {
    this.octLate = octLate;
  }
}
