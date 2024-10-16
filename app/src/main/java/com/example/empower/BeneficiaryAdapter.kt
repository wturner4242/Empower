package com.example.empower

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeneficiaryAdapter(
    private val beneficiaries: List<Beneficiary>,
    private val clickListener: (Beneficiary) -> Unit
) : RecyclerView.Adapter<BeneficiaryAdapter.BeneficiaryViewHolder>() {

    class BeneficiaryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(android.R.id.text1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeneficiaryViewHolder {
        val layout = LinearLayout(parent.context).apply {
            orientation = LinearLayout.VERTICAL
        }
        val textView = TextView(parent.context).apply {
            id = android.R.id.text1
        }
        layout.addView(textView)

        return BeneficiaryViewHolder(layout)
    }

    override fun onBindViewHolder(holder: BeneficiaryViewHolder, position: Int) {
        val beneficiary = beneficiaries[position]

        // display beneficiary list data based on designation code
        when(beneficiary.designationCode){
            "C" -> holder.nameTextView.text = "${beneficiary.firstName} ${beneficiary.lastName}\t\t${beneficiary.beneType}\t\tContingent"
            "P" -> holder.nameTextView.text = "${beneficiary.firstName} ${beneficiary.lastName}\t\t${beneficiary.beneType}\t\tPrimary"
            else -> holder.nameTextView.text = "${beneficiary.firstName} ${beneficiary.lastName}"
        }

        // set click listener for the item
        holder.itemView.setOnClickListener { clickListener(beneficiary) }
    }

    override fun getItemCount(): Int = beneficiaries.size
}