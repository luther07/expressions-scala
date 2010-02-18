package edu.luc.cs.laufer.cs473.expressions

trait ExtendedExprAlgebra[R] extends ExprAlgebra[R] {
  def visitMod(l: R, r: R, e: Mod): R
  def visitUMinus(r: R, e: UMinus): R
  override def fold[R](v: ExprAlgebra[R])(e: Expr): R = e match {
    case e: Mod => v.asInstanceOf[ExtendedExprAlgebra[R]].visitMod(fold(v)(e.left), fold(v)(e.right), e)
    case e: UMinus => v.asInstanceOf[ExtendedExprAlgebra[R]].visitUMinus(fold(v)(e.expr), e)
    case _ => super.fold(v)(e)
  }
}
