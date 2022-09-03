package com.ltman.testcodegenoutput

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Operation
import com.apollographql.apollo3.api.json.BufferedSourceJsonReader
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.parseJsonResponse
import com.example.__mytest.TestOperation
import com.example.__mytest.type.FriendPossibleTypes
import com.example.__mytest.type.LifeStatus
import com.example.__mytest.type.ThingWithID
import com.example.__mytest.type.ThingWithIDPossibleTypes
import com.ltman.testcodegenoutput.util.jsonReader
import okio.Buffer
import okio.BufferedSource
import org.junit.Assert.*
import org.junit.Test
import java.io.InputStream
import java.io.InputStreamReader


private const val responseHuman = """
{
    "data": {
        "something": {
            "__typename": "Human",
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
class ExampleUnitTest {



    @Test
    fun humanResponse() {

        val response = TestOperation().parseJsonResponse(responseHuman.jsonReader())
        assertEquals(
            TestOperation.Data(
                something = TestOperation.Data.Something(
                    __typename = "Human",
                    id = "aaa",
                    onHuman = TestOperation.Data.Something.OnHuman(
                        name = "name ja",
                        life_status = LifeStatus.alive,
                        friend = TestOperation.Data.Something.OnHuman.Friend(
                            __typename = "Human",
                            onHuman = TestOperation.Data.Something.OnHuman.Friend.OnHuman(
                                name = "HumanFriend"
                            ),
                            onHuman2 = null
                        )
                    ),
                    onThingWithName = TestOperation.Data.Something.OnThingWithName(
                        name = "name ja"
                    )
                )
            ),
            response.data
        )
        assertEquals(
            ThingWithIDPossibleTypes.Human,
            response.data!!.something!!.__type
        )
        assertEquals(
            FriendPossibleTypes.Human,
            response.data!!.something!!.onHuman!!.friend.__type
        )
    }

    @Test
    fun humanWithUnknownFriendResponse() {

        val response = TestOperation().parseJsonResponse(responseHumanWithUnknownFriend.jsonReader())
        assertEquals(
            TestOperation.Data(
                something = TestOperation.Data.Something(
                    __typename = "Human",
                    id = "aaa",
                    onHuman = TestOperation.Data.Something.OnHuman(
                        name = "name ja",
                        life_status = LifeStatus.alive,
                        friend = TestOperation.Data.Something.OnHuman.Friend(
                            __typename = "Others",
                            onHuman = null,
                            onHuman2 = null
                        )
                    ),
                    onThingWithName = TestOperation.Data.Something.OnThingWithName(
                        name = "name ja"
                    )
                )
            ),
            response.data
        )
        assertEquals(
            ThingWithIDPossibleTypes.Human,
            response.data!!.something!!.__type
        )
        assertEquals(
            FriendPossibleTypes.UNKNOWN__,
            response.data!!.something!!.onHuman!!.friend.__type
        )
    }

    @Test
    fun unknownResponse() {
        val response = TestOperation().parseJsonResponse(responseOthers.jsonReader())
        assertEquals(
            response.data,
            TestOperation.Data(
                something = TestOperation.Data.Something(
                    __typename = "Others",
                    id = "aaa",
                    onHuman = null,
                    onThingWithName = null
                )
            )
        )
        assertEquals(
            ThingWithIDPossibleTypes.UNKNOWN__,
            response.data!!.something!!.__type
        )
    }

}

