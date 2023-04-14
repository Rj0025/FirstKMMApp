package com.delivery.firstkmmapp.android.di

import android.app.Application
import com.delivery.firstkmmapp.data.local.DatabaseDriverFactory
import com.delivery.firstkmmapp.data.note.SqlDelightNoteDataSource
import com.delivery.firstkmmapp.database.NoteDatabase
import com.delivery.firstkmmapp.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }
}