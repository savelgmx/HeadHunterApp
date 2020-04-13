package com.example.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.domain.model.vacancie.Area;
import com.example.domain.model.vacancie.Salary;
import com.example.domain.model.vacancie.Vacancie;

import java.util.List;

@Dao
public interface HeadHunterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insertVacancies(List<Vacancie> vacancies);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertArea(List<Area> areas);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSalary(List<Salary> salarys);


    @Query("select * from vacancie")
    List<Vacancie> getVacancies();

    @Query("select * from area where vacancie_id = :vacancieId")
     Area getAreaFromVacancies(int vacancieId);
    @Query("select * from salary where vacancie_id = :vacancieId")
    Salary getSalaryFromVacancies(int vacancieId);


    @Query("delete from area")
    void clearAreaTable();
    @Query("delete from salary")
    void clearSalaryTable();



}
