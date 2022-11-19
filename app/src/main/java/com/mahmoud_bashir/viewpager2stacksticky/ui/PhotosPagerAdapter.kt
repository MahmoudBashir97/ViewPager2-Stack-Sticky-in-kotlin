package com.mahmoud_bashir.viewpager2stacksticky.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahmoud_bashir.viewpager2stacksticky.R
import com.mahmoud_bashir.viewpager2stacksticky.databinding.SingleItemPageBinding
import com.mahmoud_bashir.viewpager2stacksticky.models.Photo

class PhotosPagerAdapter(private val photoList:List<Photo>):
    RecyclerView.Adapter<PhotosPagerAdapter.VH>() {


    class VH(val itemPageBinding: SingleItemPageBinding)
        : RecyclerView.ViewHolder(itemPageBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding = DataBindingUtil.inflate<SingleItemPageBinding>(
            LayoutInflater.from(parent.context), R.layout.single_item_page,parent,false
        )
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemPageBinding.photo = photoList[position]
    }

    override fun getItemCount(): Int = photoList.size


}