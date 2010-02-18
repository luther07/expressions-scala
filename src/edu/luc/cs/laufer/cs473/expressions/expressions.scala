package edu.luc.cs.laufer.cs473.expressions

/**
 * An initial algebra of arithmetic expressions.
 */
abstract class Expr

case class Constant(value: Int) extends Expr

abstract case class CompositeExpr(left: Expr, right: Expr) extends Expr {
  if (left == null || right == null) {
    throw new IllegalArgumentException("null subexpression")
  }
}

case class Plus(override val left: Expr, override val right: Expr) extends CompositeExpr(left, right)
case class Minus(override val left: Expr, override val right: Expr) extends CompositeExpr(left, right)
case class Times(override val left: Expr, override val right: Expr) extends CompositeExpr(left, right)
case class Div(override val left: Expr, override val right: Expr) extends CompositeExpr(left, right)
