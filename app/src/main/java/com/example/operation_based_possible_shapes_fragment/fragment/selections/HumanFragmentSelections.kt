//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.1-SNAPSHOT'.
//
package com.example.operation_based_possible_shapes_fragment.fragment.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.example.operation_based_possible_shapes_fragment.type.GraphQLString
import kotlin.collections.List

public object HumanFragmentSelections {
  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "name",
          type = GraphQLString.type.notNull()
        ).build()
      )
}
