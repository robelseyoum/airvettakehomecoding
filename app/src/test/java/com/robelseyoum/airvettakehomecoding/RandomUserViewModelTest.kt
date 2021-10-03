package com.robelseyoum.airvettakehomecoding

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.robelseyoum.airvettakehomecoding.data.api.ApiResult
import com.robelseyoum.airvettakehomecoding.data.api.RandomUserApiStatus
import com.robelseyoum.airvettakehomecoding.data.model.RandomUser
import com.robelseyoum.airvettakehomecoding.data.repository.RandomUserRepository
import com.robelseyoum.airvettakehomecoding.data.repository.RandomUserRepositoryImp
import com.robelseyoum.airvettakehomecoding.ui.randomuseroverview.RandomUserViewModel
import io.mockk.MockKAnnotations
import junit.framework.Assert
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class RandomUserViewModelTest {

    private val dispatcher = TestCoroutineDispatcher()

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: RandomUserViewModel
    private val randomUserRepo: RandomUserRepositoryImp = mock<RandomUserRepository>()

    @Before
    fun setUpTest() {
        Dispatchers.setMain(dispatcher)
        MockKAnnotations.init(this)
        viewModel = RandomUserViewModel(TestDispatchers, randomUserRepo)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    /******************* TEST FOR Fetching Random Users *************************/

    /***
     * Test cases:
     * fetch random user  return Successfully
     */
    @Test
    fun `when fetch random users returns successfully, it should return the success as result`() =
        runBlockingTest {
            val results = mock<RandomUser>()
            whenever(randomUserRepo.getRandomUser()).thenReturn(ApiResult.Success(results))
            viewModel.fetchRandomUser()
            Assert.assertEquals(results.results, viewModel.randomUserApiData.value)
        }

    /***
     * Test cases:
     * random user throws IOException as NetworkError
     */
    @Test
    fun `when fetch random user throws IOException then it should emit the result as NetworkError`() =
        runBlockingTest {
            whenever(randomUserRepo.getRandomUser()).thenReturn(ApiResult.NetworkError)
            viewModel.fetchRandomUser()
            Assert.assertEquals(RandomUserApiStatus.ERROR, viewModel.randomUserStatus.value)
        }

    /***
     * Test cases:
     * random user throws IOException as GenericError
     */
    @Test
    fun `when fetch random user throws IOException then it should emit the result as GenericError`() =
        runBlockingTest {
            whenever(randomUserRepo.getRandomUser()).thenReturn(ApiResult.GenericError(433, "error message"))
            viewModel.fetchRandomUser()
            Assert.assertEquals(RandomUserApiStatus.ERROR, viewModel.randomUserStatus.value)
        }
}