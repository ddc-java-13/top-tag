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
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  @ColumnInfo(name = "user_name")
  @NonNull
  private String userName;

  @ColumnInfo(name = "oauth_key")
  private String oauthKey;




  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getUserName() {
    return userName;
  }

  public void setUserName(@NonNull String userName) {
    this.userName = userName;
  }

  public String getOauthKey() {
    return oauthKey;
  }

  public void setOauthKey(String oauthKey) {
    this.oauthKey = oauthKey;
  }

//  @Query("SELECT * FROM ")
}
