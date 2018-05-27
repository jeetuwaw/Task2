package com.home.task.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.home.task.model.entities.MyContacts;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@SuppressWarnings({"WeakerAccess", "unused"})
@Entity(tableName = "MyExtensions", foreignKeys = @ForeignKey(entity = MyContacts.class,
        parentColumns = "_id",
        childColumns = "phoneContactId",
        onDelete = CASCADE))
public class MyExtensions {
    private String extentionContext;

    @PrimaryKey
    private int phoneContactId;

    public MyExtensions(String extentionContext, int phoneContactId) {
        setExtentionContext(extentionContext);
        setPhoneContactId(phoneContactId);
    }

    public String getExtentionContext() {
        return extentionContext;
    }

    public void setExtentionContext(String extentionContext) {
        this.extentionContext = extentionContext;
    }

    public int getPhoneContactId() {
        return phoneContactId;
    }

    public void setPhoneContactId(int phoneContactId) {
        this.phoneContactId = phoneContactId;
    }
}
