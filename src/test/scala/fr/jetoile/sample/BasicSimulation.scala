package fr.jetoile.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://192.168.0.103:8081/sample/say/") // Here is the root for all relative URLs
	//.baseURL("http://192.168.0.103:8080/tomcat-sample-1.0-SNAPSHOT/services/sample/say/") // Here is the root for all relative URLs
	//.baseURL("http://192.168.0.103:8080/tomcat-sample-1.0-SNAPSHOT/sample/say/") // Here is the root for all relative URLs

  var scn = BasicScenario.scn

//  setUp(scn.inject(atOnceUsers(6000)).protocols(httpConf))

  setUp(scn.inject(
  rampUsersPerSec(10) to 100 during(20 seconds),
//	rampUsers(6000) over(100 seconds),
    atOnceUsers(100)
  ).protocols(httpConf))
}
