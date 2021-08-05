package edu.cnm.deepdive.toptag.service;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.toptag.R;
import edu.cnm.deepdive.toptag.model.dao.ApplicationChoiceDao;
import edu.cnm.deepdive.toptag.model.dao.GameManagementUnitDao;
import edu.cnm.deepdive.toptag.model.dao.HuntDataDao;
import edu.cnm.deepdive.toptag.model.dao.UserDao;
import edu.cnm.deepdive.toptag.model.entity.ApplicationChoice;
import edu.cnm.deepdive.toptag.model.entity.ApplicationChoice.WeaponType;
import edu.cnm.deepdive.toptag.model.entity.GameManagementUnit;
import edu.cnm.deepdive.toptag.model.entity.HuntData;
import edu.cnm.deepdive.toptag.model.entity.User;
import edu.cnm.deepdive.toptag.service.TopTagDatabase.Converters;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.jetbrains.annotations.NotNull;

@Database(     /*After database, attributes.  Entities, version, exportSchema.  some have integer,floating point, string values ets*/
    entities = {GameManagementUnit.class, ApplicationChoice.class, HuntData.class,
        User.class},  // Must have .class in order to pass the entity model class.
    version = 1,
    exportSchema = true

)
@TypeConverters(value = {WeaponType.class, Converters.class})

public abstract class TopTagDatabase extends RoomDatabase {

  private static final String DB_NAME = "top-tag-db";

  private static Application context;

  // SET CONTEXT Method
  public static void setContext(Application context) {
    TopTagDatabase.context = context;
  }

  //SINGLETON
  public static TopTagDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  // DAOs
  public abstract UserDao getUserDao();

  public abstract ApplicationChoiceDao getApplicationChoiceDao();

  public abstract GameManagementUnitDao getGameManagementUnitDao();

  public abstract HuntDataDao getHuntDataDao();


  // NESTED CLASS
  private static class InstanceHolder {

    private static final TopTagDatabase INSTANCE =
        Room.databaseBuilder(context, TopTagDatabase.class,
            DB_NAME)
            .addCallback(new CallBack())
            .build();
  }

  private static class CallBack extends RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
      insertTags();
    }

    private void insertTags() {
      try (InputStream inputStream = context.getResources().openRawResource(R.raw.hunt_data);
          Reader reader = new InputStreamReader(inputStream);
          CSVParser parser = CSVParser.parse(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader()
              .withIgnoreEmptyLines()
              .withIgnoreSurroundingSpaces())) {
        List<HuntData> huntDataList = new LinkedList<>();
        for (CSVRecord record : parser) {
          HuntData huntData = new HuntData();
          try {
            huntData.setUnit(record.get(0));
            huntData.setTag(Integer.parseInt(record.get(1)));
            huntData.setApplication(Integer.parseInt(record.get(2)));
            huntData.setBow(Boolean.parseBoolean(record.get(3)));
            huntData.setRifle(Boolean.parseBoolean(record.get(4)));
            huntData.setSeptEarly(Boolean.parseBoolean(record.get(5)));
            huntData.setSeptLate(Boolean.parseBoolean(record.get(6)));
            huntData.setOctEarly(Boolean.parseBoolean(record.get(7)));
            huntData.setOctLate(Boolean.parseBoolean(record.get(8)));
          } catch (NumberFormatException | IndexOutOfBoundsException e) {
            Log.e(getClass().getSimpleName(), record.toString(), e);
          }
          huntDataList.add(huntData);
        }
        TopTagDatabase.getInstance().getHuntDataDao().insert(huntDataList)
            .subscribeOn(Schedulers.io())
            .subscribe(
                (ids) -> {},
                (throwable) -> Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable)
            );
      } catch (IOException e) {
        Log.e(getClass().getSimpleName(), e.getMessage(), e);
        throw new RuntimeException(e);
      }

    }
  }


  public static class Converters {

    @TypeConverter
    public static Long toLong(Date value) {         /*convert from date to something SQLite db can store.  Second conversion back to date*/
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date toDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }

  }


}
