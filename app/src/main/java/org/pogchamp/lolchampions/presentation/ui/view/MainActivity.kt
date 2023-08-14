package org.pogchamp.lolchampions.presentation.ui.view

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import org.pogchamp.lolchampions.R
import org.pogchamp.lolchampions.databinding.ActivityMainBinding
import org.pogchamp.lolchampions.presentation.base.BaseActivity
import org.pogchamp.lolchampions.presentation.base.UiState
import org.pogchamp.lolchampions.presentation.ui.adapter.ChampionAdapter
import org.pogchamp.lolchampions.presentation.ui.adapter.ChampionItemDecoration
import org.pogchamp.lolchampions.presentation.ui.viewmodel.MainViewModel
import org.pogchamp.lolchampions.presentation.util.getChampionImageUrl

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()
    private val championAdapter: ChampionAdapter by lazy {
        ChampionAdapter(
            onClickedItem = { champion, sharedElements ->
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra(DetailActivity.CHAMPION_ID_KEY, champion.id)
                    putExtra(DetailActivity.CHAMPION_IMAGE_URL, getChampionImageUrl(champion.id))
                }
                val options = ActivityOptions.makeSceneTransitionAnimation(this, sharedElements)
                startActivity(intent, options.toBundle())
            }
        )
    }
    private val championItemDecoration: ChampionItemDecoration by lazy {
        ChampionItemDecoration()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Handler().postDelayed({
//            setContentView(R.layout.splash_screen)
//        },3000)
        bind()

        // Test code
        CoroutineScope(Main).launch {
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
            vm = viewModel
            adapter = championAdapter
            itemDecoration = championItemDecoration
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}

private fun Handler.postDelayed(function: () -> Unit) {

}
