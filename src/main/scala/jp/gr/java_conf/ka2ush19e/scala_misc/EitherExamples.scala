package jp.gr.java_conf.ka2ush19e.scala_misc

object EitherExamples {
  def main(args: Array[String]) {
    val some1: Option[Int] = Some(1)
    val some2: Option[Int] = Some(2)
    val some3: Option[Int] = Some(3)
    val none: Option[Int] = None

    println("-----")
    for {
      v1 <- some1
      v2 <- some2
    } {
      println(v1, v2)
    }
    println()

    println("-----")
    val f2 = for {
      v1 <- some1
      v2 <- some2
      n <- none
    } yield (v1, v2, n)
    f2 match {
      case Some((v1, v2, n)) => println(v1, v2, n)
      case None => println("None!")
    }
    println()

    println("-----")
    val f3 = for {
      v1 <- some1.toRight(new RuntimeException("Error1")).right
      v2 <- some2.toRight(new RuntimeException("Error2")).right
    } yield (v1, v2)
    f3 match {
      case Right((v1, v2)) => println(v1, v2)
      case Left(e) => println(e)
    }
    println()

    println("-----")
    val f4 = for {
      v1 <- some1.toRight(new RuntimeException("Error1")).right
      n <- none.toRight(new RuntimeException("ErrorNone")).right
      v2 <- some2.toRight(new RuntimeException("Error2")).right
    } yield (v1, n, v2)
    f4 match {
      case Right((v1, n, v2)) => println(v1, n, v2)
      case Left(e) => println(e)
    }
    println()

    println("-----")
    println(s"some1.toRight(): ${some1.toRight(-1)}")
    println(s"some1.toRight().right: ${some1.toRight(-1).right}")
    println(s"none.toRight(): ${none.toRight(-1)}")
    println(s"none.toRight().right: ${none.toRight(-1).right}")
    println()

    println("-----")
    val f5 = some1.filter(_ == 1).toRight("some1 is not 1").right
    val f6 = some1.filter(_ == 2).toRight("some1 is not 2").right
    val f7 = for {
      v1 <- f5
      v2 <- f6
    } yield (v1, v2)
    f7 match {
      case Right((v1, v2)) => println(v1, v2)
      case Left(s) => println(s)
    }
    println()

    println("-----")
    val f8 = for {
      v1 <- some1.toRight("Error1").right
      n1 <- none.toRight("ErrorNone1").right
      n2 <- none.toRight("ErrorNone2").right
      v2 <- some2.toRight("Error2").right
    } yield (v1, n1, n2, v2)

    f8 match {
      case Right(s) => println(s)
      case Left(s) => println(s)
    }

    println("-----")
    val f9 = for {
      v1 <- some1.toRight("").right
      v2 <- some2.toRight("").right
    } yield (v1, v2)
    val f10 = f9.merge
    println(f10)

//    val Right("aaa")
  }
}
