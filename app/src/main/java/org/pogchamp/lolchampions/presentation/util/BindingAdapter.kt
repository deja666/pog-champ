package org.pogchamp.lolchampions.presentation.util

import android.graphics.drawable.Drawable
import android.text.Html
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview
import org.pogchamp.lolchampions.R
import org.pogchamp.lolchampions.data.model.ChampionInfo
import org.pogchamp.lolchampions.domain.model.Champion
import org.pogchamp.lolchampions.presentation.base.UiState
import org.pogchamp.lolchampions.presentation.base.successOrNull
import org.pogchamp.lolchampions.presentation.ui.adapter.ChampionAdapter
import org.pogchamp.lolchampions.presentation.ui.adapter.ChampionSkinAdapter

@BindingAdapter("adapter")
fun RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
}

@BindingAdapter("championItems")
fun RecyclerView.bindChampionItems(uiState: UiState<List<Champion>>) {
    val boundAdapter = adapter
    if (boundAdapter is ChampionAdapter) boundAdapter.submitList(uiState.successOrNull())
}

@BindingAdapter("skinItems")
fun RecyclerView.bindSkinItems(skinItems: List<ChampionInfo.Skin>?) {
    val boundAdapter = adapter
    if (boundAdapter is ChampionSkinAdapter && !skinItems.isNullOrEmpty()) boundAdapter.submitList(
        skinItems
    )
}

@BindingAdapter("itemDecoration")
fun RecyclerView.bindItemDecoration(decor: RecyclerView.ItemDecoration) {
    if (itemDecorationCount == 0) addItemDecoration(decor)
}

@BindingAdapter("skinAdapter")
fun CarouselRecyclerview.bindSkinAdapter(adapter: RecyclerView.Adapter<*>) {
    this.adapter = adapter
    setInfinite(true)
    setAlpha(false)
    setIntervalRatio(0.5f)
    isNestedScrollingEnabled = false
}

@BindingAdapter("showProgress")
fun ProgressBar.bindShowProgress(uiState: UiState<*>) {
    visibility = if (uiState is UiState.Loading) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun ImageView.bindImageUrl(url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(context)
            .load(url)
            .skipMemoryCache(false)
            .into(this)
    }
}

@BindingAdapter(value = ["url", "onFinishedLoad"], requireAll = true)
fun ImageView.bindTransitionImageUrl(url: String?, onFinishedLoad: (() -> Unit)?) {
    if (!url.isNullOrEmpty() && onFinishedLoad != null) {
        val listener = object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                onFinishedLoad()
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                onFinishedLoad()
                return false
            }

        }
        Glide.with(context)
            .load(url)
            .skipMemoryCache(false)
            .listener(listener)
            .into(this)
    }
}

@BindingAdapter(value = ["championId", "skinNum"], requireAll = true)
fun ImageView.bindSkinImageUrl(championId: String?, skinNum: Int?) {
    if (championId != null && skinNum != null) {
        Glide.with(context)
            .load(getSkinImageUrl(championId, skinNum))
            .skipMemoryCache(false)
            .into(this)
    }
}

@BindingAdapter("tags")
fun ChipGroup.bindTags(tags: List<String>?) {
    tags?.forEach { tag ->
        val tagView: Chip = Chip(context).apply {
            text = tag
            isCheckable = false
            isCloseIconVisible = false
            setChipBackgroundColorResource(R.color.purple)
            setTextAppearanceResource(R.style.Text_Tag)
        }
        addView(tagView)
    }
}

@BindingAdapter("htmlText")
fun TextView.bindHtmlText(htmlText: String?) {
    text = Html.fromHtml(htmlText ?: "", Html.FROM_HTML_MODE_COMPACT)
}