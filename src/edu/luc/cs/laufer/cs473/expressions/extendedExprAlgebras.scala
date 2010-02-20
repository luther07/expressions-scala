package edu.luc.cs.laufer.cs473.expressions

class ExtendedEvaluate extends Evaluate with ExtendedExprAlgebra[Int] {
  override def visitMod(l: Int, r: Int, e: Mod): Int = l % r
  override def visitUMinus(r: Int, e: UMinus): Int = -r
}

object ExtendedEvaluate {
  def apply(e: Expr) = new ExtendedExprFold[Int].apply(new ExtendedEvaluate())(e)
}


