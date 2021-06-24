package com.kakapo.roomdatabase

import android.app.Application

class WordsApplication : Application() {
    // Using by lazy so the database and the repository are only created when they needed
    // rather than application start
    val database by lazy { WordRoomDatabase.getDatabase(this) }
    val repository by lazy { WordRepository(database.wordDao())}
}