import com.twitter.finagle.http.Status
import com.twitter.finatra.http.test.EmbeddedHttpServer
import com.twitter.inject.server.FeatureTest

class HelloControllerFeatureTest extends FeatureTest {
  override val server: EmbeddedHttpServer = new EmbeddedHttpServer(
    twitterServer = new FinatraServer)

  "Say Hello" in {
    server.httpGet(
      path = "/hello",
      andExpect = Status.Ok,
      withBody = "Hello From Anmol. Let's Learn Finatra"
    )
  }
}