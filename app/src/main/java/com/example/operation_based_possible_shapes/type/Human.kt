//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '$VERSION'.
//
package com.example.operation_based_possible_shapes.type

import com.apollographql.apollo3.api.ObjectType

public class Human {
  public companion object {
    public val type: ObjectType =
        ObjectType.Builder(name = "Human").interfaces(listOf(ThingWithID.type, ThingWithName.type)).build()
  }
}
