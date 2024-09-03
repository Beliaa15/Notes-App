package com.belia.notesapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Upsert //works as Insert and Update, depending on the given data in the Note object
    suspend fun upsertNote(n: Note)

    @Delete
    suspend fun deleteNote(n: Note)

    @Query("SELECT * FROM note")
    fun getNotes() : Flow<List<Note>>
}