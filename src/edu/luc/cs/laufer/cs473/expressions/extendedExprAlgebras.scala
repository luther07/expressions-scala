package edu.luc.cs.laufer.cs473.expressions

class ExtendedEvaluate extends Evaluate with ExtendedExprAlgebra[Int] {
  override def visitMod(l: Int, r: Int, e: Mod): Int = l % r
  override def visitUMinus(r: Int, e: UMinus): Int = -r
}
