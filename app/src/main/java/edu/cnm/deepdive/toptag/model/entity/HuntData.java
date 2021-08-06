package edu.cnm.deepdive.toptag.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.toptag.model.entity.ApplicationChoice.WeaponType;
import java.util.Date;

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

  private Boolean septEarly;

  private Boolean septLate;

  private Boolean octEarly;

  private Boolean octLate;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public Integer getTag() {
    return tag;
  }

  public void setTag(Integer tag) {
    this.tag = tag;
  }

  public Integer getApplication() {
    return application;
  }

  public void setApplication(Integer application) {
    this.application = application;
  }

  public Boolean getBow() {
    return bow;
  }

  public void setBow(Boolean bow) {
    this.bow = bow;
  }

  public Boolean getRifle() {
    return rifle;
  }

  public void setRifle(Boolean rifle) {
    this.rifle = rifle;
  }

  public Boolean getSeptEarly() {
    return septEarly;
  }

  public void setSeptEarly(Boolean septEarly) {
    this.septEarly = septEarly;
  }

  public Boolean getSeptLate() {
    return septLate;
  }

  public void setSeptLate(Boolean septLate) {
    this.septLate = septLate;
  }

  public Boolean getOctEarly() {
    return octEarly;
  }

  public void setOctEarly(Boolean octEarly) {
    this.octEarly = octEarly;
  }

  public Boolean getOctLate() {
    return octLate;
  }

  public void setOctLate(Boolean octLate) {
    this.octLate = octLate;
  }
}
