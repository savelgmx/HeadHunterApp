package com.example.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.domain.model.vacancie.Vacancie;

@Database(entities = {Vacancie.class},version=1)

public abstract class HeadHunterDatabase extends RoomDatabase {


    public abstract HeadHunterDao getHeadHunterDao();
}
