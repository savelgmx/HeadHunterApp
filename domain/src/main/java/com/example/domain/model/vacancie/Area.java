package com.example.domain.model.vacancie;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import com.google.gson.annotations.SerializedName;
@Entity
        (foreignKeys = @ForeignKey(
                entity = Vacancie.class,
                parentColumns = "db_id",
                childColumns = "vacancie_id"
        ))

public class Area implements Serializable {
    //район работы в отдельном классе Area список из "id","name","url"
        @PrimaryKey
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;


    @ColumnInfo(name = "vacancie_id")
    private int mVacancieId;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Area withId(String id) {
            this.id = id;
            return this;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Area withName(String name) {
            this.name = name;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Area withUrl(String url) {
            this.url = url;
            return this;
        }

    public void setVacancieId(String id) {

            mVacancieId = Integer.valueOf(id);
    }
    public int getVacancieId(){
            return mVacancieId;
    }
}

