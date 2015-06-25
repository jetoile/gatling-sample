package fr.jetoile.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8081/sample/say/") // Here is the root for all relative URLs

  var scn = BasicScenario.scn

//  setUp(scn.inject(atOnceUsers(6000)).protocols(httpConf))

  setUp(scn.inject(
  rampUsersPerSec(10) to 600 during(100 seconds),
    atOnceUsers(6000)
  ).protocols(httpConf))
}
