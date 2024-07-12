package com.doga.shoppingcardassignmentsystem.presentation.cardassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.doga.shoppingcardassignmentsystem.R
import com.doga.shoppingcardassignmentsystem.common.viewBinding
import com.doga.shoppingcardassignmentsystem.databinding.FragmentCardAssignmentBinding

class CardAssignmentFragment : Fragment(R.layout.fragment_card_assignment) {

    private val binding by viewBinding(FragmentCardAssignmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}