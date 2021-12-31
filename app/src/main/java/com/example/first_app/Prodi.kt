package com.example.first_app

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Prodi(
    var nama: String = "",
    var desc: String = "",
    var titelpimpinan: String = "",
    var namapimpinan: String = "",
    var link: String = "",
    var logoprodi: Int = 0,
    var fotopimpinan: Int = 0
) : Parcelable