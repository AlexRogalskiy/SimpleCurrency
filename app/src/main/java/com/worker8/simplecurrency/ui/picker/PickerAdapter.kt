package com.worker8.simplecurrency.ui.picker

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PickerAdapter : ListAdapter<PickerAdapter.PickerRowType, RecyclerView.ViewHolder>(comparator) {
    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PickerViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val pickerRowType = getItem(position)
        (holder as PickerViewHolder).bind(pickerRowType)
    }

    companion object {
        val comparator = object : DiffUtil.ItemCallback<PickerRowType>() {
            override fun areItemsTheSame(oldItem: PickerRowType, newItem: PickerRowType): Boolean {
                return oldItem.currencyCode == newItem.currencyCode
            }

            override fun areContentsTheSame(oldItem: PickerRowType, newItem: PickerRowType): Boolean {
                return oldItem == newItem
            }
        }
    }

    data class PickerRowType(val currencyCode: String, val currencyName: String, val currencyRate: String)
}
