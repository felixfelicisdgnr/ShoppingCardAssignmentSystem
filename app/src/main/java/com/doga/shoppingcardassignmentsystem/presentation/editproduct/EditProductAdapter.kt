package com.doga.shoppingcardassignmentsystem.presentation.editproduct

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.doga.shoppingcardassignmentsystem.data.model.entity.ProductEntity
import com.doga.shoppingcardassignmentsystem.databinding.ItemEditProductRvBinding

class EditProductAdapter(
    var onRemoveClick: (Int) -> Unit,
    var onUpdateClick: (Int, String, Double) -> Unit
) : ListAdapter<ProductEntity, EditProductAdapter.EditProductViewHolder>(
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

                btnSubmit.setOnClickListener {

                    val price = tvProductPrice.text.toString().toDoubleOrNull()
                    if (price == null || price < 0.01 || price > 99.99) {
                        Toast.makeText(
                            it.context,
                            "Fiyat aralığı 0.01 ile 99.99 arasında olmalıdır.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        onUpdateClick(item.id, tvProductName.text.toString(), price)
                    }

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