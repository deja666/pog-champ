package org.pogchamp.lolchampions.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.pogchamp.lolchampions.data.model.ChampionInfo
import org.pogchamp.lolchampions.databinding.ItemChampionSkinBinding

class ChampionSkinAdapter(
    private val id: String
) :
    ListAdapter<ChampionInfo.Skin, ChampionSkinAdapter.ChampionSkinViewHolder>(diffCallback) {
    inner class ChampionSkinViewHolder(
        private val binding: ItemChampionSkinBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ChampionInfo.Skin) {
            with(binding) {
                championId = id
                skin = data
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionSkinViewHolder {
        val binding =
            ItemChampionSkinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChampionSkinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChampionSkinViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ChampionInfo.Skin>() {
            override fun areItemsTheSame(
                oldItem: ChampionInfo.Skin,
                newItem: ChampionInfo.Skin
            ): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: ChampionInfo.Skin,
                newItem: ChampionInfo.Skin
            ): Boolean =
                oldItem == newItem
        }
    }
}