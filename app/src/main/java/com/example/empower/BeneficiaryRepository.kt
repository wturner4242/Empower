package com.example.empower

import org.json.JSONArray
import org.json.JSONObject

class BeneficiaryRepository {

    fun getBeneficiaries(): List<Beneficiary> {
        val jsonData = loadJsonData()
        return parseBeneficiaries(jsonData)
    }

    private fun loadJsonData(): String {
        return """
            [
              {
                "lastName": "Smith",
                "firstName": "John",
                "designationCode": "P",
                "beneType": "Spouse",
                "socialSecurityNumber": "XXXXX3333",
                "dateOfBirth": "04201979",
                "middleName": "D",
                "phoneNumber": "3035555555",
                "beneficiaryAddress": {
                  "firstLineMailing": "8515 E Orchard Rd",
                  "scndLineMailing": null,
                  "city": "Greenwood Village",
                  "zipCode": "80111",
                  "stateCode": "CO",
                  "country": "US"
                }
              },
              {
                "lastName": "Smith",
                "firstName": "Jane",
                "designationCode": "C",
                "beneType": "Child",
                "socialSecurityNumber": "XXXXX4664",
                "dateOfBirth": "01112012",
                "middleName": "E",
                "phoneNumber": "3034455555",
                "beneficiaryAddress": {
                  "firstLineMailing": "8515 E Orchard Rd",
                  "scndLineMailing": null,
                  "city": "Greenwood Village",
                  "zipCode": "80111",
                  "stateCode": "CO",
                  "country": "US"
                }
              },
              {
                "lastName": "Smith",
                "firstName": "Mary",
                "designationCode": "C",
                "beneType": "Child",
                "socialSecurityNumber": "XXXXX3645",
                "dateOfBirth": "02122013",
                "middleName": "E",
                "phoneNumber": "2035557558",
                "beneficiaryAddress": {
                  "firstLineMailing": "8515 E Orchard Rd",
                  "scndLineMailing": null,
                  "city": "Greenwood Village",
                  "zipCode": "80111",
                  "stateCode": "CO",
                  "country": "US"
                }
              },
              {
                "lastName": "Smith",
                "firstName": "David",
                "designationCode": "C",
                "beneType": "Child",
                "socialSecurityNumber": "XXXXX7652",
                "dateOfBirth": "09022013",
                "middleName": "E",
                "phoneNumber": "8094567777",
                "beneficiaryAddress": {
                  "firstLineMailing": "8515 E Orchard Rd",
                  "scndLineMailing": null,
                  "city": "Greenwood Village",
                  "zipCode": "80111",
                  "stateCode": "CO",
                  "country": "US"
                }
              },
              {
                "lastName": "Smith",
                "firstName": "Peter",
                "designationCode": "C",
                "beneType": "Child",
                "socialSecurityNumber": "XXXXX8756",
                "dateOfBirth": "10052014",
                "middleName": "E",
                "phoneNumber": "8194587755",
                "beneficiaryAddress": {
                  "firstLineMailing": "8515 E Orchard Rd",
                  "scndLineMailing": null,
                  "city": "Greenwood Village",
                  "zipCode": "80111",
                  "stateCode": "CO",
                  "country": "US"
                }
              }
            ]
        """.trimIndent()
    }

    private fun parseBeneficiaries(json: String): List<Beneficiary> {
        val beneficiariesList = mutableListOf<Beneficiary>()
        val jsonArray = JSONArray(json)

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)

            val beneficiary = Beneficiary(
                lastName = jsonObject.optString("lastName", ""),
                firstName = jsonObject.optString("firstName", ""),
                designationCode = jsonObject.optString("designationCode", ""),
                beneType = jsonObject.optString("beneType", ""),
                socialSecurityNumber = jsonObject.optString("socialSecurityNumber", ""),
                dateOfBirth = jsonObject.optString("dateOfBirth", ""),
                middleName = jsonObject.optString("middleName", ""), // Use optString for safe access
                phoneNumber = jsonObject.optString("phoneNumber", ""),
                beneficiaryAddress = parseBeneficiaryAddress(jsonObject.getJSONObject("beneficiaryAddress"))
            )

            beneficiariesList.add(beneficiary)
        }

        return beneficiariesList
    }

    private fun parseBeneficiaryAddress(jsonObject: JSONObject): BeneficiaryAddress {
        return BeneficiaryAddress(
            firstLineMailing = jsonObject.optString("firstLineMailing", ""),
            scndLineMailing = jsonObject.optString("scndLineMailing", null),
            city = jsonObject.optString("city", ""),
            zipCode = jsonObject.optString("zipCode", ""),
            stateCode = jsonObject.optString("stateCode", ""),
            country = jsonObject.optString("country", "")
        )
    }
}