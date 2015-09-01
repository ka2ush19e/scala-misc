package jp.gr.java_conf.ka2ush19e.scala_misc

import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

object Json4sExamples {
  def main(args: Array[String]) {

    val json1 = ("name1" -> "value1") ~ ("name2" -> "value2") ~ ("name3" -> 3) ~ ("name4" -> null)

    println(s"compact(render(json1)): ${compact(render(json1))}")
    println()

    println(s"compact(render(json1)): ${compact(render(json1))}")
    println()

    println(s"pretty(render(json1)): ${pretty(render(json1))}")
    println()

    val json2 = json1 ~ ("name5" -> "value5")
    println(s"compact(render(json1)): ${compact(render(json1))}")
    println(s"compact(render(json2)): ${compact(render(json2))}")
    println()

    val json3 = ("name1" -> "merged") ~ ("name6" -> 6)
    val json4 = json1 merge json3
    println(s"compact(json4): ${compact(render(json4))}")

    val diff = json1 diff json3
    println(s"diff: $diff")

    val headers = Seq("name1", "name2", "name3")
    val datas = Seq("value1", "value2", "value3")

    val j = headers.zip(datas).foldLeft(JObject()) { case (j, (h, d)) => j ~ (h -> d) }
    println(s"compact(render(j)): ${compact(render(j))}")
    

  }
}
