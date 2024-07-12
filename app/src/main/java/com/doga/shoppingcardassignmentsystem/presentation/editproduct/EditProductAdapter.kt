package com.doga.shoppingcardassignmentsystem.presentation.editproduct

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.databinding.ItemEditProductRvBinding

class EditProductAdapter(var onRemoveClick: (Int) -> Unit) :
    ListAdapter<ProductEntity, EditProductAdapter.EditProductViewHolder>(
        EditProductDiff()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EditProductViewHolder {
        val binding =
            ItemEditProductRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EditProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EditProductViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class EditProductViewHolder(
        private val binding: ItemEditProductRvBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductEntity) {
            with(binding) {

                tvProductId.text = String.format("Product ID : %s", item.id)
                tvProductName.setText(item.name)
                tvProductPrice.setText(item.price.toString())

                btnRemove.setOnClickListener {
                    onRemoveClick(item.id)
                }
            }
        }
    }

    class EditProductDiff : DiffUtil.ItemCallback<ProductEntity>() {
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