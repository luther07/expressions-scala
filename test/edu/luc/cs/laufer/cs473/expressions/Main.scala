package edu.luc.cs.laufer.cs473.expressions

import TestFixtures._

object Main {
  def main(args : Array[String]) : Unit = {
    println("p = " + complex1)
    println("evaluate(p) = " + SimpleOperations.evaluate(complex1))
    println("size(p) = " + SimpleOperations.size(complex1))
    println("depth(p) = " + SimpleOperations.depth(complex1))
    println(SimpleOperations.toFormattedString(complex1))
    println("q = " + complex2)
    println("evaluate(q) = " + SimpleOperations.evaluate(complex2))
    println("size(q) = " + SimpleOperations.size(complex2))
    println("depth(q) = " + SimpleOperations.depth(complex2))
    println(SimpleOperations.toFormattedString(complex2))
  }
}
