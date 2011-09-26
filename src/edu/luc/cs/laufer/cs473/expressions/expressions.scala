package edu.luc.cs.laufer.cs473.expressions

/**
 * An initial algebra of arithmetic expressions.
 */
abstract class Expr
abstract class CompositeExpr(val left: Expr, val right: Expr) extends Expr {
  if (left == null || right == null) {
    throw new IllegalArgumentException("null subexpression")
  }
}

case class Constant(value: Int) extends Expr
case class Plus(override val left: Expr, override val right: Expr) extends CompositeExpr(left, right)
case class Minus(override val left: Expr, override val right: Expr) extends CompositeExpr(left, right)
case class Times(override val left: Expr, override val right: Expr) extends CompositeExpr(left, right)
case class Div(override val left: Expr, override val right: Expr) extends CompositeExpr(left, right)
