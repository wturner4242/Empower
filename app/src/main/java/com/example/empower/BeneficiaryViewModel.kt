package com.example.empower

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BeneficiaryViewModel : ViewModel() {

    private val repository = BeneficiaryRepository()
    private val _beneficiaries = MutableLiveData<List<Beneficiary>>()
    val beneficiaries: LiveData<List<Beneficiary>> get() = _beneficiaries

    init {
        loadBeneficiaries()
    }

    private fun loadBeneficiaries() {
        _beneficiaries.value = repository.getBeneficiaries()
    }
}