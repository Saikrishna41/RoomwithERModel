package com.techfortyone.roomerphilip.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techfortyone.roomerphilip.Director
import com.techfortyone.roomerphilip.School
import com.techfortyone.roomerphilip.relations.SchoolAndDirector


@Database(
    entities = [School::class, Director::class, SchoolAndDirector::class],
    exportSchema = false,
    version = 1
)

abstract class RoomDatabaseImpl : RoomDatabase() {

    abstract fun getDao(): SchoolDao

    companion object {
        @Volatile
        var INSTANCE: RoomDatabaseImpl? = null
        fun getDatabase(context: Context) : RoomDatabaseImpl {
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    RoomDatabaseImpl::class.java,
                    "RoomDb"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}