package edu.cnm.deepdive.toptag.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;

public class GameManagementUnit {

  @PrimaryKey
  @ColumnInfo(name = "game_management_unit")
  private int gameManagementUnit;

  @Expose
  @ColumnInfo(name = "animal_name")
  private String animalName;

  @Expose
  @ColumnInfo(name = "herd_size")
  private int herdSize;

  @Expose
  @ColumnInfo(name = "harvest_number")
  private int harvestNumber;

  @Expose
  @ColumnInfo(name = "tag_applications")
  private int tagApplications;

  @Expose
  @ColumnInfo(name = "tags_issued")
  private int tagsIssued;

  public int getGameManagementUnit() {
    return gameManagementUnit;
  }

  public void setGameManagementUnit(int gameManagementUnit) {
    this.gameManagementUnit = gameManagementUnit;
  }

  public String getAnimalName() {
    return animalName;
  }

  public void setAnimalName(String animalName) {
    this.animalName = animalName;
  }

  public int getHerdSize() {
    return herdSize;
  }

  public void setHerdSize(int herdSize) {
    this.herdSize = herdSize;
  }

  public int getHarvestNumber() {
    return harvestNumber;
  }

  public void setHarvestNumber(int harvestNumber) {
    this.harvestNumber = harvestNumber;
  }

  public int getTagApplications() {
    return tagApplications;
  }

  public void setTagApplications(int tagApplications) {
    this.tagApplications = tagApplications;
  }

  public int getTagsIssued() {
    return tagsIssued;
  }

  public void setTagsIssued(int tagsIssued) {
    this.tagsIssued = tagsIssued;
  }
}
