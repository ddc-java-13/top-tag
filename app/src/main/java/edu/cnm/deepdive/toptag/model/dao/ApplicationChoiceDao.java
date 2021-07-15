package edu.cnm.deepdive.toptag.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.toptag.model.entity.ApplicationChoice;
import edu.cnm.deepdive.toptag.model.entity.ApplicationChoice.WeaponType;
import edu.cnm.deepdive.toptag.model.entity.GameManagementUnit;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ApplicationChoiceDao {

  @Insert
  Single<Long> insert(ApplicationChoice applicationChoice);

  @Insert
  Single<List<Long>> insert(ApplicationChoice... applicationChoices);

  @Insert
  Single<List<Long>> insert(Collection<? extends ApplicationChoice> applicationChoices);

  @Update
  Single<Integer> update(ApplicationChoice applicationChoice);

  @Update
  Single<Integer> update(ApplicationChoice... applicationChoices);

  @Update
  Single<Integer> update(Collection<? extends ApplicationChoice> applicationChoices);

  @Delete
  Single<Integer> delete(ApplicationChoice applicationChoice);

  @Delete
  Single<Integer> delete(ApplicationChoice... applicationChoices);

  @Delete
  Single<Integer> delete(Collection<? extends ApplicationChoice> applicationChoices);

  @Query("SELECT * FROM application_choice WHERE application_choice_id = :applicationChoice")
  LiveData<ApplicationChoice> select(String applicationChoice);

  @Query("SELECT * FROM application_choice WHERE season_id = :season")
  LiveData<ApplicationChoice> selectBySeason(String season);

  @Query("SELECT * FROM application_choice WHERE weapon_type = :weaponType")
  LiveData<ApplicationChoice> selectByWeapon(WeaponType weaponType);

}
