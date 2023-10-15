package com.example.music_player

import android.os.Parcel
import android.os.Parcelable

data class OutData(val title: String?, val casi: String?, val file: Int, val Lyrics: String?) : Parcelable {
    constructor(parcel: Parcel) : this(

        parcel.readString(),
        parcel.readString(),
        parcel.readInt() ,
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(title)
        parcel.writeString(casi)
        parcel.writeInt(file)
        parcel.writeString(Lyrics)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OutData> {
        override fun createFromParcel(parcel: Parcel): OutData {
            return OutData(parcel)
        }

        override fun newArray(size: Int): Array<OutData?> {
            return arrayOfNulls(size)
        }
    }
}