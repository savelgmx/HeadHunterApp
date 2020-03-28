package com.example.domain.model.vacancie;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


import java.io.Serializable;
import java.util.List;

@Entity
public class Vacancie implements Serializable {
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private String mId; //не знаю почему но создатели HeadHunter API решили сделать это поле строкой

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String mName;


    @SerializedName("area")
    @Ignore
    private List<Area> mArea; //район работы в отдельном классе Area список из "id","name","url"

    @SerializedName("salary")
    @Ignore
    private List<Salary> mSalary;//зарплата

    @SerializedName("address")
    @Ignore

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(@NonNull String name) {
        mName = name;
    }


}
