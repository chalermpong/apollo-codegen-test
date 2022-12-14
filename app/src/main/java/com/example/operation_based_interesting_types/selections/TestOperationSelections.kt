//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.1-SNAPSHOT'.
//
package com.example.operation_based_interesting_types.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledFragment
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.notNull
import com.example.operation_based_interesting_types.type.GraphQLID
import com.example.operation_based_interesting_types.type.GraphQLString
import com.example.operation_based_interesting_types.type.ThingWithID
import kotlin.collections.List

public object TestOperationSelections {
  private val __onHuman: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "name",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __onThingWithName: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "name",
          type = GraphQLString.type.notNull()
        ).build()
      )

  private val __something: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "__typename",
          type = GraphQLString.type.notNull()
        ).build(),
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build(),
        CompiledFragment.Builder(
          typeCondition = "Human",
          possibleTypes = listOf("Human")
        ).selections(__onHuman)
        .build(),
        CompiledFragment.Builder(
          typeCondition = "ThingWithName",
          possibleTypes = listOf("Human", "Human2", "Droid")
        ).selections(__onThingWithName)
        .build()
      )

  private val __something1: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "something",
          type = ThingWithID.type
        ).selections(__something)
        .build(),
        CompiledField.Builder(
          name = "something",
          type = ThingWithID.type
        ).alias("somethingWithoutInterestingType")
        .selections(__something1)
        .build()
      )
}
