package jp.gr.java_conf.ka2ush19e.scala_misc

object OptionExamples {
  def main(args: Array[String]) {
    val some1: Option[String] = Some("1")
    val some2: Option[String] = Some("2")
    val some3: Option[String] = Some("3")
    val none: Option[String] = None

    println("isDefined:")
    println(s"  some1.isDefined: ${some1.isDefined}")
    println(s"  none.isDefined: ${none.isDefined}")
    println()

    println("isEmpty:")
    println(s"some1.isEmpty: ${some1.isEmpty}")
    println(s"none.isEmpty: ${none.isEmpty}")
    println()

    println("getOrElse:")
    println( s"""  some1.getOrElse("-1"): ${some1.getOrElse("-1")}""")
    println( s"""  none.getOrElse("-1"): ${none.getOrElse("-1")}""")

    println("map:")
    println(s"  some1.map(_.length): ${some1.map(_.length)}")
    println(s"  none.map(_.length): ${none.map(_.length)}")
    println()

    println("flatMap:")
    println(s"  some1.flatMap(s => Some(s.length)): ${some1.flatMap(s => Some(s.length))}")
    println(s"  none.flatMap(s => Some(s.length)): ${none.flatMap(s => Some(s.length))}")
    println()

    println("filter:")
    println(s"  some1.filter(_.nonEmpty): ${some1.filter(_.nonEmpty)}")
    println(s"  none.filter(_.nonEmpty): ${none.filter(_.nonEmpty)}")
    println()

    println("fold:")
    println(s"  some1.fold(-1)(_.length): ${some1.fold(-1)(_.length)}")
    println(s"  none.fold(-1)(_.length): ${none.fold(-1)(_.length)}")
    println()

    println("For comprehension:")
    for {
      v1 <- some1
      v2 <- some2
      v3 <- some3
    } {
      println(s"  $v1 $v2 $v3")
    }
  }
}
