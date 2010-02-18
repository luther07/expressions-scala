package edu.luc.cs.laufer.cs473.expressions

case class Mod(override val left: Expr, override val right: Expr) extends CompositeExpr(left, right)

case class UMinus(expr: Expr) extends Expr {
  if (expr == null) {
    throw new IllegalArgumentException("null subexpression")
  }
}
