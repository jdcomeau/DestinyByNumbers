package com.example.destinybynumbers.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DestinyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun populateDestiny(data: List<DestinyDefinitions>)

    //Below @Query & function adapted from Java CodeLab app BasicSample
    @Query("SELECT * FROM destiny_definitions WHERE _id = :destinyId")
    fun getDefinition(destinyId: String): List<DestinyDefinitions>
    //fun getDefinition(destinyId: String): LiveData<DestinyDefinitions?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun populatePythagorean(data: List<PythagoreanTable>)

    @Query("SELECT * FROM pythagorean_table")
    fun getPythagoreanNumber(): List<PythagoreanTable>

    @Insert(entity = InquiryResults::class,
        onConflict = OnConflictStrategy.REPLACE)
    fun addNewEntry(input: InquiryResults)

    @Query("SELECT * FROM inquiry_results WHERE _id = :inquiryId")
    fun getInquiryResults(inquiryId: String): LiveData<InquiryResults?>
}