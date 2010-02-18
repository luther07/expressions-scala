package edu.luc.cs.laufer.cs473.expressions

trait ExtendedExprAlgebra[R] extends ExprAlgebra[R] {
  def visitMod(l: R, r: R, e: Mod): R
  def visitUMinus(r: R, e: UMinus): R
}

class ExtendedExprFold[R] extends ExprFold[R] {
  override def apply(v: ExprAlgebra[R])(e: Expr): R = e match {
    case e: Mod => v.asInstanceOf[ExtendedExprAlgebra[R]].visitMod(this(v)(e.left), this(v)(e.right), e)
    case e: UMinus => v.asInstanceOf[ExtendedExprAlgebra[R]].visitUMinus(this(v)(e.expr), e)
    case _ => super.apply(v)(e)
  }
}
