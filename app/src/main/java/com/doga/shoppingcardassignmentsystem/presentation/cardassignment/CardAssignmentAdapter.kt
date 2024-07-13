package com.doga.shoppingcardassignmentsystem.presentation.cardassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.databinding.ItemCardAssignmentRvBinding

class CardAssignmentAdapter(var onDeleteClick: (Int) -> Unit) :
    ListAdapter<ProductEntity, CardAssignmentAdapter.CardAssignmentViewHolder>(
        CardAssignmentDiff()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CardAssignmentViewHolder {
        val binding =
            ItemCardAssignmentRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardAssignmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardAssignmentViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class CardAssignmentViewHolder(
        private val binding: ItemCardAssignmentRvBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductEntity) {
            with(binding) {
                tvProductName.text = String.format("Product Name: %s", item.name)
                tvProductPrice.text = String.format("Product Price: %s", item.price)
                tvProductId.text = String.format("Product ID : %s", item.id)

                btnDelete.setOnClickListener {
                    onDeleteClick(adapterPosition)
                }
            }
        }
    }

    class CardAssignmentDiff : DiffUtil.ItemCallback<ProductEntity>() {
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