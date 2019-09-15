package com.worker8.currencylayer.model

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types.newParameterizedType
import java.io.BufferedReader

data class Currency(val code: String, val name: String) {

    companion object {
        private val list by lazy {
            val inputStream = javaClass.classLoader.getResourceAsStream("currencies.json")
            val json = inputStream.bufferedReader().use(BufferedReader::readText)
            Moshi.Builder().build()
                .adapter<List<Currency>>(newParameterizedType(List::class.java, Currency::class.java))
                .fromJson(json)!!
        }

        val ALL = list.associateBy(Currency::code)
    }
}
