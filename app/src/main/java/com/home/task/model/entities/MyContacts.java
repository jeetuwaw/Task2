package com.home.task.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


@SuppressWarnings({"WeakerAccess", "unused"})
@Entity(tableName = "MyContacts")
public class MyContacts {
    @PrimaryKey
    private int _id;
    private String contactId;
    private String stagingId;

    public MyContacts(int _id, String contactId, String stagingId) {
        set_id(_id);
        setContactId(contactId);
        setStagingId(stagingId);
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getStagingId() {
        return stagingId;
    }

    public void setStagingId(String stagingId) {
        this.stagingId = stagingId;
    }
}
