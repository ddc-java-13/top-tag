package edu.cnm.deepdive.toptag.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.toptag.model.entity.ApplicationChoice;
import edu.cnm.deepdive.toptag.model.entity.GameManagementUnit;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface GameManagementUnitDao {


  @Insert
  Single<Integer> insert(GameManagementUnit gameManagementUnit);

  @Insert
  Single<List<Integer>> insert(GameManagementUnit... gameManagementUnits);

  @Insert
  Single<List<Integer>> insert(Collection<? extends GameManagementUnit> gameManagementUnits);

  @Update
  Single<Integer> update(GameManagementUnit gameManagementUnit);

  @Update
  Single<Integer> update(GameManagementUnit... gameManagementUnits);

  @Update
  Single<Integer> update(Collection<? extends GameManagementUnit> gameManagementUnits);

  @Delete
  Single<Integer> delete(GameManagementUnit gameManagementUnit);

  @Delete
  Single<Integer> delete(GameManagementUnit... gameManagementUnits);

  @Delete
  Single<Integer> delete(Collection<? extends GameManagementUnit> gameManagementUnits);

  @Query("SELECT * FROM game_management_unit WHERE game_management_unit_id = :gameManagementUnitId")
  LiveData<GameManagementUnit> selectById(long gameManagementUnitId);

  @Query("SELECT * FROM game_management_unit WHERE unit_number = :unitNumber")
  LiveData<GameManagementUnit> selectByUnitNumber(int unitNumber);

  @Query("SELECT * FROM game_management_unit ORDER BY unit_number ASC ")
  LiveData<List<GameManagementUnit>> selectAll();
}
