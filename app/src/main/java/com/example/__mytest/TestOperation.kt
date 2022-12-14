//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.1-SNAPSHOT'.
//
package com.example.__mytest

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.example.__mytest.adapter.TestOperation_ResponseAdapter
import com.example.__mytest.selections.TestOperationSelections
import com.example.__mytest.type.FriendPossibleTypes
import com.example.__mytest.type.LifeStatus
import com.example.__mytest.type.ThingWithIDPossibleTypes
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

public class TestOperation() : Query<TestOperation.Data> {
  public override fun equals(other: Any?): Boolean = other != null && other::class == this::class

  public override fun hashCode(): Int = this::class.hashCode()

  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    // This operation doesn't have any variable
  }

  public override fun adapter(): Adapter<Data> = TestOperation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.example.__mytest.type.Query.type
  )
  .selections(selections = TestOperationSelections.__root)
  .build()

  @ApolloAdaptableWith(TestOperation_ResponseAdapter.Data::class)
  public data class Data(
    public val something: Something?,
  ) : Query.Data {
    public data class Something(
      public val __typename: String,
      public val id: String,
      /**
       * Synthetic field for inline fragment on Human
       */
      public val onHuman: OnHuman?,
      /**
       * Synthetic field for inline fragment on ThingWithName
       */
      public val onThingWithName: OnThingWithName?,
    ) {
      /**
       * Synthetic field for enumerable possible type of ThingWithID
       */
      public val __type: ThingWithIDPossibleTypes
        get() = ThingWithIDPossibleTypes.safeValueOf(__typename)

      public data class OnHuman(
        public val name: String,
        public val life_status: LifeStatus,
        public val friend: Friend,
      ) {
        public data class Friend(
          public val __typename: String,
          /**
           * Synthetic field for inline fragment on Human
           */
          public val onHuman: OnHuman?,
          /**
           * Synthetic field for inline fragment on Human2
           */
          public val onHuman2: OnHuman2?,
        ) {
          /**
           * Synthetic field for enumerable possible type of Friend
           */
          public val __type: FriendPossibleTypes
            get() = FriendPossibleTypes.safeValueOf(__typename)

          public data class OnHuman(
            public val name: String,
          )

          public data class OnHuman2(
            public val name: String,
          )
        }
      }

      public data class OnThingWithName(
        public val name: String,
      )
    }
  }

  public companion object {
    public const val OPERATION_ID: String =
        "0b174d3b127587c2e08e0aeacf228a4961b198c4c3e417790d8433c7339aa398"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query TestOperation {
     *   something {
     *     __typename
     *     id
     *     ... on Human {
     *       name
     *       life_status
     *       friend {
     *         __typename
     *         ... on Human {
     *           name
     *         }
     *         ... on Human2 {
     *           name
     *         }
     *       }
     *     }
     *     ... on ThingWithName {
     *       name
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query TestOperation { something { __typename id ... on Human { name life_status friend { __typename ... on Human { name } ... on Human2 { name } } } ... on ThingWithName { name } } }"

    public const val OPERATION_NAME: String = "TestOperation"
  }
}
