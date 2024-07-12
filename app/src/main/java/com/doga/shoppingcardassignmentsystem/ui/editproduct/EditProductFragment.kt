package com.doga.shoppingcardassignmentsystem.ui.editproduct

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.doga.shoppingcardassignmentsystem.R
import com.doga.shoppingcardassignmentsystem.common.viewBinding
import com.doga.shoppingcardassignmentsystem.databinding.FragmentEditProductBinding

class EditProductFragment : Fragment(R.layout.fragment_edit_product) {

    private val binding by viewBinding(FragmentEditProductBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}