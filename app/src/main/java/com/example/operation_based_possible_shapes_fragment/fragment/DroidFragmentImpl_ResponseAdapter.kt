//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.1-SNAPSHOT'.
//
package com.example.operation_based_possible_shapes_fragment.fragment

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object DroidFragmentImpl_ResponseAdapter {
  public object DroidFragment :
      Adapter<com.example.operation_based_possible_shapes_fragment.fragment.DroidFragment> {
    public val RESPONSE_NAMES: List<String> = listOf("model_name", "build_name")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        com.example.operation_based_possible_shapes_fragment.fragment.DroidFragment {
      var _model_name: String? = null
      var _build_name: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _model_name = StringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _build_name = StringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return com.example.operation_based_possible_shapes_fragment.fragment.DroidFragment(
        model_name = _model_name!!,
        build_name = _build_name!!
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: com.example.operation_based_possible_shapes_fragment.fragment.DroidFragment,
    ): Unit {
      writer.name("model_name")
      StringAdapter.toJson(writer, customScalarAdapters, value.model_name)

      writer.name("build_name")
      StringAdapter.toJson(writer, customScalarAdapters, value.build_name)
    }
  }
}
