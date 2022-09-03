package com.ltman.testcodegenoutput

import com.apollographql.apollo3.api.parseJsonResponse
import com.example.operation_based_possible_shapes_fragment.TestOperation
import com.example.operation_based_possible_shapes_fragment.fragment.DroidFragment
import com.example.operation_based_possible_shapes_fragment.fragment.ThingWithIDFragment
import com.example.operation_based_possible_shapes_fragment.fragment.ThingWithNameFragment
import com.ltman.testcodegenoutput.util.jsonReader
import org.junit.Assert.*
import org.junit.Test

private const val responseHuman = """
{
    "data": {
        "something": {
            "__typename": "Human",
            "id": "aaa",
            "name": "name ja"
        },
        "something2": {
            "__typename": "Droid",
            "id": "aaa1",
            "model_name": "modelname something2",
            "build_name": "buildname something2"
        }
    }
}
"""

private const val responsePetWithHumanOwner = """
{
    "data": {
        "something": {
            "__typename": "Pet",
            "id": "pet1",
            "name": "name pet1",
            "owner": {
                "__typename": "Human",
                "id": "aaa",
                "name": "name ja"
            }
        },
        "somethingWithOnlyOneShape": {
            "id": "aaa1"
        }
    }
}
"""

private const val responseHumanWithUnknownFriend = """
{
    "data": {
        "something": {
            "__typename": "Human",
            "id": "aaa",
            "name": "name ja",
            "life_status": "alive",
            "friend": {
                "__typename": "Others",
                "name": "Unknown Friend"
            }
        }
    }
}
"""

private const val responseOthers = """
{
    "data": {
        "something": {
            "__typename": "Others",
            "id": "aaa",
            "name": "name ja",
            "life_status": "alive",
            "friend": {
                "__typename": "Human",
                "name": "HumanFriend"
            }
        }
    }
}
"""



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class OperationBasedPossibleShapesFragmentUnitTest {



    @Test
    fun humanResponse() {

        val response = TestOperation().parseJsonResponse(responseHuman.jsonReader())
        assertEquals(
            TestOperation.Data(
                something = TestOperation.Data.HumanThingWithNameSomething(
                    __typename = "Human",
                    thingWithIDFragment = ThingWithIDFragment(
                        __typename = "Human",
                        id = "aaa",
                        onHuman = ThingWithIDFragment.OnHuman(
                            name = "name ja"
                        ),
                        onDroid = null,
                        onPet = null
                    ),
                    thingWithNameFragment = ThingWithNameFragment(
                        name = "name ja"
                    )
                ),
                something2 = TestOperation.Data.DroidSomething2(
                    __typename = "Droid",
                    id = "aaa1",
                    onDroid = TestOperation.Data.Something2.OnDroid(
                        __typename = "Droid",
                        droidFragment = DroidFragment(
                            model_name = "modelname something2",
                            build_name = "buildname something2"
                        )
                    ),
                    humanFragment = null
                )
            ),
            response.data
        )
    }



}
