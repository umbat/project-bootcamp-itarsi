package com.example.first_app

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Prodi(
    val nama: String = "",
    val desc: String = "",
    val logoprodi: Int = 0,
    val titelpimpinan: String = "",
    val fotopimpinan: Int = 0,
    val namapimpinan: String = "",
    val link: String = ""
) : Parcelable