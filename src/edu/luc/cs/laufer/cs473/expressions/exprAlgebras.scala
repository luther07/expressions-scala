package edu.luc.cs.laufer.cs473.expressions

class Evaluate extends ExprAlgebra[Int] {
  override def visitConstant(c: Constant): Int = c.value
  override def visitPlus(l: Int, r: Int, e: Plus): Int = l + r
  override def visitMinus(l: Int, r: Int, e: Minus): Int = l - r
  override def visitTimes(l: Int, r: Int, e: Times): Int = l * r
  override def visitDiv(l: Int, r: Int, e: Div): Int = l / r
}