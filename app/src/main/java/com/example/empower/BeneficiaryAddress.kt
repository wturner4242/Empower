package com.example.empower

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BeneficiaryAddress(
    val firstLineMailing: String,
    val scndLineMailing: String?,
    val city: String,
    val zipCode: String,
    val stateCode: String,
    val country: String
) : Parcelable