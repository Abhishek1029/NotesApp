package com.abhishek.notesapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "description")
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
