package com.example.empower

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BeneficiaryListFragment : Fragment() {

    private lateinit var viewModel: BeneficiaryViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = LinearLayout(requireContext())
        layout.orientation = LinearLayout.VERTICAL

        recyclerView = RecyclerView(requireContext()).apply {
            layoutManager = LinearLayoutManager(context)
        }
        layout.addView(recyclerView)

        viewModel = ViewModelProvider(this).get(BeneficiaryViewModel::class.java)
        viewModel.beneficiaries.observe(viewLifecycleOwner, Observer { beneficiaries ->
            recyclerView.adapter = BeneficiaryAdapter(beneficiaries) { beneficiary ->
                // Handle item click
                Log.d("BeneficiaryListFragment", "Navigating to details with beneficiary: $beneficiary")
                val detailFragment = BeneficiaryDetailFragment.newInstance(beneficiary)
                (activity as MainActivity).replaceFragment(detailFragment)
            }
        })

        return layout
    }


}