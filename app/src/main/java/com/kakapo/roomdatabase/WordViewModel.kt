package com.kakapo.roomdatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {
    // Using liveData and caching what allWords returns has several benefits:
    // - we can put an observer on the data (instead of polling for changes) an d only update the
    //   the UI when data actually changes.
    //- Repository is completely separated from the UI trough view model

    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

    /*
    * Launching a new coroutine to insert the data in non-blocking way
    **/

    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}