package com.home.task.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.database.Cursor;

import com.home.task.model.entities.MyAccounts;
import com.home.task.model.entities.MyContacts;
import com.home.task.model.entities.MyExtensions;

@Dao
public interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserContacts(MyContacts myContacts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserExtensions(MyExtensions myExtensions);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserAccounts(MyAccounts myAccounts);

    @Query("SELECT c.stagingId, e.extentionContext , a.status, a.userID " +
            "FROM MyContacts c inner join MyExtensions e " +
            "on c._id = e.phoneContactId " +
            "inner join MyAccounts a on a.extentionContext = e.extentionContext where  contactId = :s"
            )
    Cursor diaplayData(String s);


}
