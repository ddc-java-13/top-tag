package edu.cnm.deepdive.toptag.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
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

  private boolean bow;

  private boolean rifle;

  private boolean septEarly;

  private boolean septLate;

  private boolean octEarly;

  private boolean octLate;

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

  public boolean isBow() {
    return bow;
  }

  public void setBow(boolean bow) {
    this.bow = bow;
  }

  public boolean isRifle() {
    return rifle;
  }

  public void setRifle(boolean rifle) {
    this.rifle = rifle;
  }

  public boolean isSeptEarly() {
    return septEarly;
  }

  public void setSeptEarly(boolean septEarly) {
    this.septEarly = septEarly;
  }

  public boolean isSeptLate() {
    return septLate;
  }

  public void setSeptLate(boolean septLate) {
    this.septLate = septLate;
  }

  public boolean isOctEarly() {
    return octEarly;
  }

  public void setOctEarly(boolean octEarly) {
    this.octEarly = octEarly;
  }

  public boolean isOctLate() {
    return octLate;
  }

  public void setOctLate(boolean octLate) {
    this.octLate = octLate;
  }
}
