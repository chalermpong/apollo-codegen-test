//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.1-SNAPSHOT'.
//
package com.example.__mytest.type

import kotlin.String

/**
 * Auto generated enum class for enumerable possible type of ThingWithName
 */
public enum class ThingWithNamePossibleTypes(
  public val rawValue: String,
) {
  Human("Human"),
  Human2("Human2"),
  Droid("Droid"),
  /**
   * Auto generated constant for unknown __typename values
   */
  UNKNOWN__("UNKNOWN__"),
  ;

  public companion object {
    public fun safeValueOf(rawValue: String): ThingWithNamePossibleTypes =
        values().find { it.rawValue == rawValue } ?: UNKNOWN__
  }
}