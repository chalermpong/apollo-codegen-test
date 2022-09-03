package com.ltman.testcodegenoutput.util

import com.apollographql.apollo3.api.json.BufferedSourceJsonReader
import com.apollographql.apollo3.api.json.JsonReader
import okio.Buffer

fun String.jsonReader(): JsonReader {
    val buffer = Buffer()
    buffer.writeString(this, Charsets.UTF_8)
    return BufferedSourceJsonReader(buffer)
}