//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.1-SNAPSHOT'.
//
package com.example.__mytest.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.example.__mytest.type.LifeStatus
import kotlin.Unit

public object LifeStatus_ResponseAdapter : Adapter<LifeStatus> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      LifeStatus {
    val rawValue = reader.nextString()!!
    return LifeStatus.safeValueOf(rawValue)
  }

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: LifeStatus,
  ): Unit {
    writer.value(value.rawValue)
  }
}
