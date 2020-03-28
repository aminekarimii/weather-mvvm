package com.sqli.weatherappmvvm.helper

import com.sqli.weatherappmvvm.R
import java.text.SimpleDateFormat
import java.util.*

object Helpers {

    fun getDrawable(icon_id: String): Int {
        when (icon_id) {
            "03n" -> return R.drawable.ic_01d
        }
        return 0
    }

    fun getFlag(countryId:String):String{
        return "https://www.countryflags.io/${countryId}/flat/64.png"
    }

    fun getDateTime(s: Int): String? {
        try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = Date(s.toLong())
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }

}