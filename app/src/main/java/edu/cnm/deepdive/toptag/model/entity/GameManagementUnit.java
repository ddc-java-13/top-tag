package edu.cnm.deepdive.toptag.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Sets class as entity.
 */
@Entity(tableName = "game_management_unit")
public class GameManagementUnit {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "game_management_unit_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "unit_number", index = true)
  private int unitNumber;

//  @NonNull
//  @ColumnInfo(name = "animal_name")
//  private String animalName;

//  @NonNull
//  @ColumnInfo(name = "herd_size")
//  private int herdSize;

//  @NonNull
//  @ColumnInfo(name = "harvest_number")
//  private int harvestNumber;

  @NonNull
  @ColumnInfo(name = "tag_applications")
  private int tagApplications;

  @NonNull
  @ColumnInfo(name = "tags_issued")
  private int tagsIssued;

  /**
   * gets game management unit id
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   * sets game management unit id
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * gets unit number
   * @return
   */
  public int getUnitNumber() {
    return unitNumber;
  }

  /**
   * sets unit number
   * @param unitNumber
   */
  public void setUnitNumber(int unitNumber) {
    this.unitNumber = unitNumber;
  }

//  public String getAnimalName() {
//    return animalName;
//  }
//
//  public void setAnimalName(String animalName) {
//    this.animalName = animalName;
//  }
//
//  public int getHerdSize() {
//    return herdSize;
//  }
//
//  public void setHerdSize(int herdSize) {
//    this.herdSize = herdSize;
//  }
//
//  public int getHarvestNumber() {
//    return harvestNumber;
//  }
//
//  public void setHarvestNumber(int harvestNumber) {
//    this.harvestNumber = harvestNumber;
//  }

  /**
   * gets tag applications
   * @return
   */
  public int getTagApplications() {
    return tagApplications;
  }

  /**
   * sets tag applications
   * @param tagApplications
   */
  public void setTagApplications(int tagApplications) {
    this.tagApplications = tagApplications;
  }

  /**
   * gets tags issued
   * @return
   */
  public int getTagsIssued() {
    return tagsIssued;
  }

  /**
   * sets tags issued
   * @param tagsIssued
   */
  public void setTagsIssued(int tagsIssued) {
    this.tagsIssued = tagsIssued;
  }

}
