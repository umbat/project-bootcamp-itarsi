package com.example.first_app

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Prodi(
    val nama: String,
    val desc: String,
    val foto: String,
    val link: String
) : Parcelable