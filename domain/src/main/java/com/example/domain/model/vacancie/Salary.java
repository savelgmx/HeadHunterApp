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
                parentColumns = "id",
                childColumns = "vacancie_id"
        ))


public class Salary implements Serializable
{
    @PrimaryKey
    @ColumnInfo(name = "id")
    @SerializedName("id")
    private String mId;
    @ColumnInfo(name="from")
    @SerializedName("from")
    private String mFrom;
    @SerializedName("to")
    private String mTo;
    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("gross")
    private String mGross;

    public String getFrom() {  return mFrom; }
    public void setFrom(String from) {mFrom = from; }

    public String getTo() {
        return mTo;
    }
    public void setTo(String to) { mTo = to; }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getGross() {
        return mGross;
    }

    public void setGross(String gross) {
            mGross = gross;
    }

}