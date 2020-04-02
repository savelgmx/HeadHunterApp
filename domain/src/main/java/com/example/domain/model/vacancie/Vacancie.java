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
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private String mId;
    //не знаю почему но создатели HeadHunter API решили сделать это поле строкой
    //поэтому пришлось делать дополнительный integer db_id
    //который только  и возможно сделать primary key
    @PrimaryKey
    @NonNull
    @ColumnInfo(name="db_id")
    private int mDbId;


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
        mDbId = Integer.valueOf(mId);
        return  mId;
    }
    public void setId(String id) {
        mId = id;
    }

    public int getDbId() {

        return  mDbId;
    }

    public void setDbId(int DbId) {
        mDbId = DbId;
    }


    public String getName() {
        return mName;
    }

    public void setName(@NonNull String name) {
        mName = name;
    }

    public List<Area> getArea() {
        return mArea;
    }

    public void setArea(@NonNull List<Area>area) {
        mArea =  area;
    }

    public List<Salary> getSalary() {
        return mSalary;
    }

    public void setSalary(@NonNull List<Salary> salary) {
        mSalary = salary;
    }

}
