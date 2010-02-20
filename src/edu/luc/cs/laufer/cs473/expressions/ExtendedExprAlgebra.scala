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

class ExtendedExprAdvancedFold[A,R](g: A => A)(b: A)(vFactory: A => ExtendedExprAlgebra[R]) extends ExprAdvancedFold[A,R](g)(b)(vFactory) {
  override def apply(x: A)(e: Expr): R = e match {
    case e: Mod => vFactory(x).asInstanceOf[ExtendedExprAlgebra[R]].visitMod(this(g(x))(e.left), this(g(x))(e.right), e)
    case e: UMinus => vFactory(x).asInstanceOf[ExtendedExprAlgebra[R]].visitUMinus(this(g(x))(e.expr), e)
    case _ => super.apply(x)(e)
  }
}