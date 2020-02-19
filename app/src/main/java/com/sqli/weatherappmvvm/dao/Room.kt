package com.sqli.weatherappmvvm.dao

import android.content.Context
import androidx.room.*
import com.sqli.weatherappmvvm.model.Data

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather")
    suspend fun getAllWeatherData(): List<Data>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeatherData(posts: List<Data>)
}

@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun WeatherDao(): WeatherDao

    companion object {

        @Volatile
        private var instance: WeatherDatabase? = null

        fun getDatabaseInstance(context: Context): WeatherDatabase {
            val tempInstance = instance
            if (tempInstance != null && tempInstance.isOpen)
                return tempInstance

            synchronized(this) {
                val inst = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    "weather"
                ).fallbackToDestructiveMigration().build()
                instance = inst
                return inst
            }
        }
    }
}