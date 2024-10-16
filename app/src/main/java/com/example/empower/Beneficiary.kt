package com.example.empower

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Beneficiary(
    val lastName: String,
    val firstName: String,
    val designationCode: String,
    val beneType: String,
    val socialSecurityNumber: String,
    val dateOfBirth: String,
    val middleName: String,
    val phoneNumber: String,
    val beneficiaryAddress: BeneficiaryAddress
) : Parcelable
