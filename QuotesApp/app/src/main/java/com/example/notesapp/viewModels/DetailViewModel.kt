package com.example.notesapp.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.models.QuotesItem
import com.example.notesapp.repository.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: QuoteRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val quotes: StateFlow<List<QuotesItem>>
        get() = repository.quotes

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category") ?: "Android"
            repository.getQuotes(category)
        }
    }
}