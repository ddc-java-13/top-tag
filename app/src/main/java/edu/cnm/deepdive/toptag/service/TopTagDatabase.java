package edu.cnm.deepdive.toptag.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import edu.cnm.deepdive.toptag.model.dao.ApplicationChoiceDao;
import edu.cnm.deepdive.toptag.model.dao.GameManagementUnitDao;
import edu.cnm.deepdive.toptag.model.dao.UserDao;
import edu.cnm.deepdive.toptag.model.entity.ApplicationChoice;
import edu.cnm.deepdive.toptag.model.entity.GameManagementUnit;
import edu.cnm.deepdive.toptag.model.entity.User;
//import edu.cnm.deepdive.toptag.service.TopTagDatabase.Converters;
import java.util.Date;

@Database(     /*After database, attributes.  Entities, version, exportSchema.  some have integer,floating point, string values ets*/
    entities = {GameManagementUnit.class, ApplicationChoice.class,
        User.class},  // Must have .class in order to pass the entity model class.
    version = 1,
    exportSchema = true

)
// Need to tell ROOM where converters are
//@TypeConverter({Converters.class})    //Enum would be 'X'.class

/*Database class*/
// Set Fields.  String CONSTANT for name.  Application context;.
// Add SET CONTEXT method.
// Create NESTED CLASS for InstanceHolder, Invoke Room.databaseBuilder.
// Create SINGLETON to return InstanceHolder.INSTANCE.
// Add DAOs.  Convention "DAO" "getDAO"();
public abstract class TopTagDatabase extends RoomDatabase {

  private static final String DB_NAME = "top-tag-db";

  private static Application context;

  // SET CONTEXT Method
  public static void setContext(Application context) {
    TopTagDatabase.context = context;
  }

  //SINGLETON INCOMING
  public static TopTagDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  // DAOs
  public abstract UserDao getUserDao();

  public abstract ApplicationChoiceDao getApplicationChoiceDao();

  public abstract GameManagementUnitDao getGameManagementUnitDao();


  // NESTED CLASS
  private static class InstanceHolder {

    private static final TopTagDatabase INSTANCE =
        Room.databaseBuilder(context, TopTagDatabase.class,
            DB_NAME)   // Invoking static method   - context is type application, Database Class.class, the String constant defined as DB_NAME.
            .build();
  }


//               /*If Entity type Date*/
//  public static class Converters {
//
//    @TypeConverter
//    public static Long toLong(Date/*java.util*/ value) {         /*convert from date to something SQLite db can store.  Second conversion back to date*/
//      return (value != null) ? value.getTime() : null;
//    }
//
//    @TypeConverter
//    public static Date toDate(Long value) {
//      return (value != null) ? new Date(value) : null;
//    }
//
//  }

}
