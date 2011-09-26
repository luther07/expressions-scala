package edu.luc.cs.laufer.cs473.expressions

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

import TestFixtures._

object MainParser {
  def main(args : Array[String]) : Unit = {
    val parser = new ExprParser
    val parsedExpr = parser.parseAll(parser.expr, complex1string) 
    println(parsedExpr.get)
    println(complex1)
    println(parsedExpr.get == complex1)
  }
}

@RunWith(classOf[JUnitRunner])
class TestParser extends FunSuite {
  val parser = new ExprParser
  val parsedExpr = parser.parseAll(parser.expr, complex1string) 

  test("parser works") { assert(parsedExpr.get === complex1) }
}
