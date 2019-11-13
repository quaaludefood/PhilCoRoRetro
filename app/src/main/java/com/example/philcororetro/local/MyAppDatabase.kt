package com.example.philcororetro.local

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.philcororetro.model.Action


@Database(
    entities = [Action::class],
    version = 1
)
abstract class MyAppDatabase :RoomDatabase() {

    abstract fun actionDao(): ActionDao

    companion object {

        private const val databaseName = "myApp-db"

        fun buildDefault(context: Context) =
            Room.databaseBuilder(context, MyAppDatabase::class.java, databaseName)
                .build()

        @VisibleForTesting
        fun buildTest(context: Context) =
            Room.inMemoryDatabaseBuilder(context, MyAppDatabase::class.java)
                .build()
    }
}