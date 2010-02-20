package edu.luc.cs.laufer.cs473.expressions

class Evaluate extends ExprAlgebra[Int] {
  override def visitConstant(c: Constant) = c.value
  override def visitPlus(l: Int, r: Int, e: Plus) = l + r
  override def visitMinus(l: Int, r: Int, e: Minus) = l - r
  override def visitTimes(l: Int, r: Int, e: Times) = l * r
  override def visitDiv(l: Int, r: Int, e: Div) = l / r
}

object Evaluate {
  def apply(e: Expr) = new ExprFold[Int].apply(new Evaluate())(e)
}

class Print(prefix: String) extends ExprAlgebra[String] {
  override def visitConstant(c: Constant)  = prefix + c.value.toString
  override def visitPlus(l: String, r: String, e: Plus) = buildExprString("Plus", l, r)
  override def visitMinus(l: String, r: String, e: Minus) = buildExprString("Minus", l, r)
  override def visitTimes(l: String, r: String, e: Times) = buildExprString("Times", l, r)
  override def visitDiv(l: String, r: String, e: Div) = buildExprString("Div", l, r)
  protected def buildExprString(nodeString: String, leftString: String, rightString: String) = {
    val result = new StringBuilder(prefix)
    result.append(nodeString)
    result.append("(")
    result.append(Print.EOL)
    result.append(leftString)
    result.append(", ")
    result.append(Print.EOL)
    result.append(rightString)
    result.append(")")
    result.toString
  }
}

object Print {
  val EOL = System.getProperty("line.separator")
  val INDENT = ".."
  def apply(e: Expr) = new ExprAdvancedFold[String, String](_ + INDENT)(">>")(new Print(_))(e)
}