package com.rspb.pertama

import android.os.Parcel
import android.os.Parcelable

data class Pertama(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel,flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(age)
        parcel.writeString(email)
        parcel.writeString(city)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pertama> {
        override fun createFromParcel(parcel: Parcel): Pertama {
            return Pertama(parcel)
        }

        override fun newArray(size: Int): Array<Pertama?> {
            return arrayOfNulls(size)
        }
    }
}
