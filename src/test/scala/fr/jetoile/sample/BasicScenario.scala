package fr.jetoile.sample

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

object BasicScenario {


  var count = 0
  val random = new util.Random
//  def generateMessage(): String = { "message" + random.nextString(20) }
  def generateMessage(): String = { "message" + random.nextInt(100) }


  val feeder = Iterator.continually(Map("email" -> generateMessage() ))

  var scn = scenario("Navigation test ")
  scn = scn
    .repeat(10,"count") {
    feed(feeder)
      .exec(http("req1").get("${email}"))
      .pause(100 milliseconds, 1600 milliseconds)
      .exec(http("req2").get("${email}"))
      .pause(120 milliseconds, 1600 milliseconds)
      .exec(http("req3").get("${email}"))
      .pause(120 milliseconds, 1600 milliseconds)
      .exec(http("req4").get("${email}"))
      .pause(120 milliseconds, 1600 milliseconds)
      .exec(http("req5").get("${email}"))
      .pause(120 milliseconds, 1600 milliseconds)
      .exec(http("req6").get("${email}"))
      .pause(120 milliseconds, 1600 milliseconds)
      .exec(http("req7").get("${email}"))
//      .pause(120 milliseconds, 1600 milliseconds)      
//      .exec(http("req8").get("${email}"))
//      .pause(120 milliseconds, 1600 milliseconds)            
  }
}
