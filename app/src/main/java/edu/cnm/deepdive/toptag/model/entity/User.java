package edu.cnm.deepdive.toptag.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;

@Entity(
    indices = {
        @Index(value = {"user_name"}, unique = true),
        @Index(value = {"oauth_key"}, unique = true)
    }

)
/**
 *
 * annotates user as an entity class
 */
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "user_name")
  private String userName;

  @ColumnInfo(name = "oauth_key")
  @NonNull
  private String oauthKey;


  /**
   * gets user id
   * @return id
   */
  public long getId() {
    return id;
  }

  /**
   * sets user id
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * gets user name as string
   * @return string userName
   */
  @NonNull
  public String getUserName() {
    return userName;
  }

  /**
   * sets user name
   * @param userName
   */
  public void setUserName(@NonNull String userName) {
    this.userName = userName;
  }

  /**
   * gets oauthKey as String
   * @return oauthKey String
   */
  public String getOauthKey() {
    return oauthKey;
  }

  /**
   * sets oauthKey
   * @param oauthKey
   */
  public void setOauthKey(String oauthKey) {
    this.oauthKey = oauthKey;
  }

//  @Query("SELECT * FROM ")
}
