package com.home.task.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@SuppressWarnings({"ALL", "unused", "NullableProblems"})
@Entity(tableName = "MyAccounts")
public class MyAccounts {
    private String status;
    private String userID;
    @PrimaryKey
    @NonNull
    private String extentionContext;

    public MyAccounts(String status, String userID, @NonNull String extentionContext) {
        setStatus(status);
        setUserID(userID);
        setExtensionContext(extentionContext);
    }

    public String getStatus() {
        return status;
    }

    @SuppressWarnings("WeakerAccess")
    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    @SuppressWarnings("WeakerAccess")
    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getExtentionContext() {
        return extentionContext;
    }

    public void setExtensionContext(@NonNull String extentionContext) {
        this.extentionContext = extentionContext;
    }

}

