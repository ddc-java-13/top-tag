package edu.cnm.deepdive.toptag.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.toptag.model.entity.HuntData;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

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
  
//  @Query("SELECT * FROM hunt_data ORDER BY created ASC ")
//  LiveData<List<HuntData>> selectAll();

}
