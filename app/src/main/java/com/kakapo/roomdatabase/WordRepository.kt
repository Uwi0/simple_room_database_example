package com.kakapo.roomdatabase

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

// Declares the dao as a private property in the constructor. Pass in the DAO
// instead of the whole database, because only need access to the dao
class WordRepository(private val wordDao: WordDao) {
    // Room execute all queries on a separate thread
    // Observed FLow will notify the observer when the data has changed

    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    // By default Room runs suspend queries of the main thread. therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // of the main thread

    @WorkerThread
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
}