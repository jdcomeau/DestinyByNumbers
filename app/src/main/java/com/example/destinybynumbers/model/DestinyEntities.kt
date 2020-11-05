package com.example.destinybynumbers.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "destiny_definitions")
data class DestinyDefinitions (
    @PrimaryKey(autoGenerate = false)
    val _id: String,
    @ColumnInfo(name = "life_path_def")
    val life_path_def: String,
    @ColumnInfo(name = "destiny_def")
    val destiny_def: String,
    @ColumnInfo(name = "soul_def")
    val soul_def: String,
    @ColumnInfo(name = "personality_def")
    val personality_def: String,
    @ColumnInfo(name = "random_string_def")
    val random_string_def: String,
    @ColumnInfo(name = "street_number_def")
    val street_number_dev: String
)

@Entity(tableName = "inquiry_results")
data class InquiryResults(
    @PrimaryKey(autoGenerate = true)
    val _id: Int,
    @ColumnInfo(name = "inquiry_date")
    val inquiry_date: String,
    @ColumnInfo(name = "inquiry_result")
    val inquiry_result: String,
    @ColumnInfo(name = "inquiry_num")
    val inquiry_num: String,
    @ColumnInfo(name = "inquiry_definition")
    val inquiry_definition: String,
    @ColumnInfo(name = "inquiry_type")
    val inquiry_type: String
)

@Entity(tableName = "pythagorean_table")
data class PythagoreanTable (
    @PrimaryKey(autoGenerate = false)
    val _id: Int,
    @ColumnInfo(name = "letters")
    val alpha_1: String
)