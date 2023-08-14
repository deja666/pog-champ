package org.pogchamp.lolchampions.presentation.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.pogchamp.lolchampions.R
import org.pogchamp.lolchampions.databinding.ActivityDetailBinding
import org.pogchamp.lolchampions.presentation.base.BaseActivity
import org.pogchamp.lolchampions.presentation.base.UiState
import org.pogchamp.lolchampions.presentation.ui.adapter.ChampionSkinAdapter
import org.pogchamp.lolchampions.presentation.ui.viewmodel.DetailViewModel

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val viewModel: DetailViewModel by viewModels()
    private val skinAdapter: ChampionSkinAdapter by lazy {
        ChampionSkinAdapter(viewModel.championId)
    }
    val onFinishedLoadImage = fun() {
        supportStartPostponedEnterTransition()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind()
        supportPostponeEnterTransition()
        // Test code
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.uiState.collect {
                when (it) {
                    is UiState.Loading -> Log.d(TAG, "xxx UiState : Loading")
                    is UiState.Success -> Log.d(TAG, "xxx UiState : Success")
                    is UiState.Error -> Log.d(TAG, "xxx UiState : Error")
                }
            }
        }

    }

    private fun bind() {
        with(binding) {
            activity = this@DetailActivity
            vm = viewModel
            skinAdapter = this@DetailActivity.skinAdapter
        }
    }

    override fun onBackPressed() {
        supportFinishAfterTransition()
        super.onBackPressed()
    }

    companion object {
        const val TAG = "DetailActivity"
        const val CHAMPION_ID_KEY = "champion_id_key"
        const val CHAMPION_IMAGE_URL = "champion_image_url"
    }
}