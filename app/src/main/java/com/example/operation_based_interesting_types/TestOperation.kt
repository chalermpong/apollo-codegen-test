//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '$VERSION'.
//
package com.example.operation_based_interesting_types

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.example.operation_based_interesting_types.adapter.TestOperation_ResponseAdapter
import com.example.operation_based_interesting_types.selections.TestOperationSelections
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
    type = com.example.operation_based_interesting_types.type.Query.type
  )
  .selections(selections = TestOperationSelections.__root)
  .build()

  @ApolloAdaptableWith(TestOperation_ResponseAdapter.Data::class)
  public data class Data(
    public val something: ISomething?,
    public val somethingWithoutInterestingType: SomethingWithoutInterestingType?,
  ) : Query.Data {
    public sealed interface ISomething {
      public val __typename: String

      public val id: String

      /**
       * Synthetic field for inline fragment on Human
       */
      public val onHuman: Something.OnHuman?

      /**
       * Synthetic field for inline fragment on ThingWithName
       */
      public val onThingWithName: Something.OnThingWithName?
    }

    public data class ThingWithNameSomething(
      public override val __typename: String,
      public override val id: String,
      /**
       * Synthetic field for inline fragment on Human
       */
      public override val onHuman: Something.OnHuman?,
      /**
       * Synthetic field for inline fragment on ThingWithName
       */
      public override val onThingWithName: Something.OnThingWithName,
    ) : ISomething

    public data class HumanThingWithNameSomething(
      public override val __typename: String,
      public override val id: String,
      /**
       * Synthetic field for inline fragment on Human
       */
      public override val onHuman: Something.OnHuman,
      /**
       * Synthetic field for inline fragment on ThingWithName
       */
      public override val onThingWithName: Something.OnThingWithName,
    ) : ISomething

    public data class Something(
      public override val __typename: String,
      public override val id: String,
      /**
       * Synthetic field for inline fragment on Human
       */
      public override val onHuman: OnHuman?,
      /**
       * Synthetic field for inline fragment on ThingWithName
       */
      public override val onThingWithName: OnThingWithName?,
    ) : ISomething {
      public data class OnHuman(
        public val name: String,
      )

      public data class OnThingWithName(
        public val name: String,
      )
    }

    public data class SomethingWithoutInterestingType(
      public val id: String,
    )
  }

  public companion object {
    public const val OPERATION_ID: String =
        "f2f4028895e65acb5c76469738f725d252725d1b3d9471b57f476c8c5835ec3e"

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
     *     }
     *     ... on ThingWithName {
     *       name
     *     }
     *   }
     *   somethingWithoutInterestingType: something {
     *     id
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query TestOperation { something { __typename id ... on Human { name } ... on ThingWithName { name } } somethingWithoutInterestingType: something { id } }"

    public const val OPERATION_NAME: String = "TestOperation"
  }
}
