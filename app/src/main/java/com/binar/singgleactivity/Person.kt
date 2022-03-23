package com.binar.singgleactivity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val nama: String,
    val email: String,
    val umur: String,
    val alamat: String
): Parcelable
