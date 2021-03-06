package edu.cnm.deepdive.toptag.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.toptag.model.entity.HuntData;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 *  Interface for CRUD. Inserts/Deletes queries Hunt Data entity data.
 */
@Dao
public interface HuntDataDao {

  @Insert
  Single<Long> insert(HuntData huntData);

  @Insert
  Single<List<Long>> insert(HuntData... huntsData);

  @Insert
  Single<List<Long>> insert(Collection<? extends HuntData> huntsData);

  @Update
  Single<Integer> update(HuntData huntData);

  @Update
  Single<Integer> update(HuntData... huntsData);

  @Update
  Single<Integer> update(Collection<? extends HuntData> huntsData);

  @Delete
  Single<Integer> delete(HuntData huntData);

  @Delete
  Single<Integer> delete(HuntData... huntsData);

  @Delete
  Single<Integer> delete(Collection<? extends HuntData> huntsData);

  @Query("SELECT * FROM hunt_data ORDER BY unit ASC ")
  LiveData<List<HuntData>> selectUnit();

  @Query("SELECT * FROM hunt_data "
      + "WHERE bow = IFNULL(:bow, bow) "
      + "AND rifle = IFNULL(:rifle, rifle) "
      + "AND sept_early = IFNULL(:septEarly, sept_early) "
      + "AND sept_late = IFNULL(:septLate, sept_late) "
      + "AND oct_early = IFNULL(:octEarly, oct_early) "
      + "AND oct_late = IFNULL(:octLate, oct_late) "
      + "ORDER BY unit ASC")
  LiveData<List<HuntData>> selectFiltered(Boolean bow, Boolean rifle, Boolean septEarly, Boolean septLate, Boolean octEarly, Boolean octLate);

}
