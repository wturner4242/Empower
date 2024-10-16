package com.example.empower

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class BeneficiaryDetailFragment : Fragment() {
    private lateinit var beneficiary: Beneficiary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            beneficiary = it.getParcelable(ARG_BENEFICIARY) ?: throw IllegalArgumentException("Beneficiary must not be null")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(16, 16, 16, 16)
        }

        val textView = TextView(requireContext()).apply {
            text = "${beneficiary.firstName} ${beneficiary.lastName}\n" +
                    "SSN: ${beneficiary.socialSecurityNumber}\n" +
                    "DOB: ${beneficiary.dateOfBirth}\n" +
                    "Phone: ${beneficiary.phoneNumber}\n" +
                    "Address: ${beneficiary.beneficiaryAddress.firstLineMailing}, " +
                    "${beneficiary.beneficiaryAddress.city}, " +
                    "${beneficiary.beneficiaryAddress.stateCode} ${beneficiary.beneficiaryAddress.zipCode}, " +
                    "${beneficiary.beneficiaryAddress.country}"
        }

        layout.addView(textView)

        return layout
    }

    companion object {
        private const val ARG_BENEFICIARY = "beneficiary"

        fun newInstance(beneficiary: Beneficiary) = BeneficiaryDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_BENEFICIARY, beneficiary)
            }
        }
    }
}