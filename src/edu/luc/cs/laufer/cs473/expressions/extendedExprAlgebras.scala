package edu.luc.cs.laufer.cs473.expressions

class ExtendedEvaluate extends Evaluate with ExtendedExprAlgebra[Int] {
  override def visitMod(l: Int, r: Int, e: Mod): Int = l % r
  override def visitUMinus(r: Int, e: UMinus): Int = -r
}

object ExtendedEvaluate {
  def apply(e: Expr) = new ExtendedExprFold[Int].apply(new ExtendedEvaluate())(e)
}


class ExtendedPrint(prefix: String) extends Print(prefix) with ExtendedExprAlgebra[String] {
  override def visitMod(l: String, r: String, e: Mod) = buildExprString("Mod", l, r)
  override def visitUMinus(r: String, e: UMinus) = buildUnaryExprString("UMinus", r)
  protected def buildUnaryExprString(nodeString: String, exprString: String) = {
    val result = new StringBuilder(prefix)
    result.append(nodeString)
    result.append("(")
    result.append(Print.EOL)
    result.append(exprString)
    result.append(")")
    result.toString
  }
}

object ExtendedPrint {
//class ExprAdvancedFold[A,R](g: A => A)(b: A)(vFactory: A => ExprAlgebra[R])
  def apply(e: Expr) = new ExtendedExprAdvancedFold[String, String](_ + Print.INDENT)(">>")(new ExtendedPrint(_))(e)
}