package com.robelseyoum.airvettakehomecoding.ui.randomuseroverview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robelseyoum.airvettakehomecoding.concurrency.AppDispatchers
import com.robelseyoum.airvettakehomecoding.data.api.ApiResult.*
import com.robelseyoum.airvettakehomecoding.data.model.RandomUser
import com.robelseyoum.airvettakehomecoding.data.model.Results
import com.robelseyoum.airvettakehomecoding.data.repository.RandomUserRepositoryImp
import com.robelseyoum.airvettakehomecoding.utils.RandomUserApiStatus
import com.robelseyoum.airvettakehomecoding.utils.RandomUserApiStatus.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RandomUserViewModel @Inject constructor(
    private val appDispatchers: AppDispatchers,
    private val randomUserRepo: RandomUserRepositoryImp
) : ViewModel() {

    private val _randomUserApiData: MutableLiveData<List<Results>?> = MutableLiveData()
    private val _navigateToSelectedRandomUser = MutableLiveData<Results?>()
    private val _randomUserStatus = MutableLiveData<RandomUserApiStatus>()

    val randomUserApiData: LiveData<List<Results>?> = _randomUserApiData
    val navigateToSelectedRandomUser: LiveData<Results?> = _navigateToSelectedRandomUser
    val randomUserStatus: LiveData<RandomUserApiStatus> = _randomUserStatus

    init {
        fetchRandomUser()
    }

    fun fetchRandomUser() = viewModelScope.launch {
        _randomUserStatus.value = LOADING
        val result = withContext(appDispatchers.io) {
            randomUserRepo.getRandomUser()
        }
        when (result) {
            is GenericError -> {
                _randomUserStatus.value = ERROR
            }
            is NetworkError -> {
                _randomUserStatus.value = ERROR
            }
            is Success -> {
                _randomUserApiData.value = result.value?.results
                _randomUserStatus.value = DONE
            }
        }
    }
}