package edu.luc.cs.laufer.cs473.expressions

import ExtendedOperations._
import TestFixtures._

object MainExtended {
  def main(args : Array[String]) : Unit = {
    println("p = " + complex1)
    println("evaluate(p) = " + evaluate(complex1))
    println("size(p) = " + size(complex1))
    println("depth(p) = " + depth(complex1))
    println(toFormattedString(complex1))
    println("q = " + complex2)
    println("evaluate(q) = " + evaluate(complex2))
    println("size(q) = " + size(complex2))
    println("depth(q) = " + depth(complex2))
    println(toFormattedString(complex2))
  }
}
