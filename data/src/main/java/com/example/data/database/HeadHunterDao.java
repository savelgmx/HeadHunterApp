package com.example.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.domain.model.vacancie.Vacancie;

import java.util.List;

@Dao
public interface HeadHunterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insertVacancies(List<Vacancie> vacancies);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertArea();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSalary();


    @Query("select * from vacancie")
    List<Vacancie> getVacancies();


    @Query("delete from area")
    void clearAreaTable();
    @Query("delete from salary")
    void clearSalaryTable();



}
