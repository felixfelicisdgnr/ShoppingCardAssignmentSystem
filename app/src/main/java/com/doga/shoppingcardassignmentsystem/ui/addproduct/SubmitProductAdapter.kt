package com.doga.shoppingcardassignmentsystem.ui.addproduct

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.databinding.ItemProductRvBinding

class SubmitProductAdapter :
    ListAdapter<ProductEntity, SubmitProductAdapter.SubmitProductViewHolder>(
        CustomerInfoDetailDiff()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubmitProductViewHolder {
        val binding =
            ItemProductRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SubmitProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubmitProductViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class SubmitProductViewHolder(
        private val binding: ItemProductRvBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductEntity) {
            with(binding) {
                tvProductName.text = String.format("Product Name: %s", item.name)
                tvProductPriceName.text = String.format("Product Price: %s", item.price)
                tvProductId.text = String.format("Product ID : %s", item.id)

            }
        }
    }

    class CustomerInfoDetailDiff : DiffUtil.ItemCallback<ProductEntity>() {
        override fun areItemsTheSame(
            oldItem: ProductEntity, newItem: ProductEntity
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductEntity, newItem: ProductEntity
        ): Boolean {
            return oldItem == newItem
        }
    }
}