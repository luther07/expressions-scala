package edu.luc.cs.laufer.cs473.expressions

/**
 * The category of expression algebras.
 */
trait ExprAlgebra[R] {
  def visitConstant(c: Constant): R
  def visitPlus(l: R, r: R, e: Plus): R
  def visitMinus(l: R, r: R, e: Minus): R
  def visitTimes(l: R, r: R, e: Times): R
  def visitDiv(l: R, r: R, e: Div): R
  /**
   * The catamorphism for expressions.
   */
  def fold[R](v: ExprAlgebra[R])(e: Expr): R = e match {
    case c: Constant => v.visitConstant(c)
    case e: Plus => v.visitPlus(v.fold(v)(e.left), fold(v)(e.right), e)
    case e: Minus => v.visitMinus(v.fold(v)(e.left), fold(v)(e.right), e)
    case e: Times => v.visitTimes(v.fold(v)(e.left), fold(v)(e.right), e)
    case e: Div => v.visitDiv(v.fold(v)(e.left), fold(v)(e.right), e)
  }
  def apply(e: Expr) = fold(this)(e)
}
