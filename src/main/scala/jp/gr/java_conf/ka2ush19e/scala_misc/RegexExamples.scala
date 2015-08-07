package jp.gr.java_conf.ka2ush19e.scala_misc

import scala.util.matching.Regex

object RegexExamples {
  def main(args: Array[String]) {

    println("1234".matches("\\d{4}"))
    println("1234".matches("""\d{4}"""))
    println("12345".matches("""\d{4}"""))
    println()

    val r = """\d{4}""".r
    println(r.findFirstIn("1234").nonEmpty)
    println(r.findFirstIn("12345").nonEmpty)
    println()

    "1234" match {
      case r(_*) => println("match")
      case _ => println("unmatch")
    }
    "12345" match {
      case r(_*) => println("match")
      case _ => println("unmatch")
    }
    println()

    val v = """\d{1}\.\d{2}\.\d{2}"""
    println("1.00.00".matches(v))
    println("1w00.00".matches(v))

  }
}
