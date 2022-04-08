package com.example.flipgrid.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Data class which consists of the users information which must be passed from one fragment to another
*/
@Parcelize
data class User(
    val firstName: String,
    val website: String,
    val emailAddress: String,
) : Parcelable
