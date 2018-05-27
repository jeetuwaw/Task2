package com.home.task.daogenerator;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.home.task.Utils.Constants;
import com.home.task.dao.MyDao;
import com.home.task.model.entities.MyAccounts;
import com.home.task.model.entities.MyContacts;
import com.home.task.model.entities.MyExtensions;

@SuppressWarnings("ALL")
@Database(entities = { MyContacts.class, MyAccounts.class, MyExtensions.class }, version = 1)
public abstract class ContactsDatabase extends RoomDatabase {
    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
    private static ContactsDatabase contactsDB;
    public abstract MyDao getMyDao();

    public static ContactsDatabase getInstance(Context context) {
        if (null == contactsDB) {
            contactsDB = buildDatabaseInstance(context);
        }
        return contactsDB;
    }

    private static ContactsDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                ContactsDatabase.class,
                Constants.DB_NAME)
                .allowMainThreadQueries().build();
    }

// --Commented out by Inspection START (27/5/18 10:34 PM):
//    public void cleanUp(){
//        contactsDB = null;
//    }
// --Commented out by Inspection STOP (27/5/18 10:34 PM)

}
