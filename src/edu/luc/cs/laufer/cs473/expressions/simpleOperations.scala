package edu.luc.cs.laufer.cs473.expressions

object SimpleOperations {

  def evaluate(e: Expr): Int = e match {
    case Constant(c) => c
    case Plus(l, r) => evaluate(l) + evaluate(r)
    case Minus(l, r) => evaluate(l) - evaluate(r)
    case Times(l, r) => evaluate(l) * evaluate(r)
    case Div(l, r) => evaluate(l) / evaluate(r)
  }

  def size(e: Expr): Int = e match {
    case Constant(c) => 1
    case e: CompositeExpr => 1 + size(e.left) + size(e.right)
  }

  def depth(e: Expr): Int = e match {
    case Constant(c) => 1
    case e: CompositeExpr => 1 + scala.math.max(depth(e.left), depth(e.right))
  }

  def toFormattedString(prefix: String)(e: Expr): String = e match {
    case Constant(c) => prefix + c.toString
    case Plus(l, r) => buildExprString(prefix, "Plus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
    case Minus(l, r) => buildExprString(prefix, "Minus", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
    case Times(l, r) => buildExprString(prefix, "Times", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
    case Div(l, r) => buildExprString(prefix, "Div", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
  }

  def toFormattedString(e: Expr): String = toFormattedString(">>")(e)

  def buildExprString(prefix: String, nodeString: String, leftString: String, rightString: String) = {
    val result = new StringBuilder(prefix)
    result.append(nodeString)
    result.append("(")
    result.append(EOL)
    result.append(leftString)
    result.append(", ")
    result.append(EOL)
    result.append(rightString)
    result.append(")")
    result.toString
  }

  val EOL = System.getProperty("line.separator")
  val INDENT = ".."
}

/**
 * These do not generally work.
 */
object ExtendedSimpleOperations {

  def evaluate(e: Expr): Int = e match {
    case Mod(l, r) => evaluate(l) % evaluate(r)
    case UMinus(r) => -evaluate(r)
    case _ => SimpleOperations.evaluate(e)
  }

  def size(e: Expr): Int = e match {
    case Mod(l, r) => 1 + size(l) + size(r)
    case UMinus(r) => 1 + size(r)
    case _ => SimpleOperations.size(e)
  }

  def depth(e: Expr): Int = e match {
    case Mod(l, r) => 1 + scala.math.max(depth(l), depth(r))
    case UMinus(r) => 1 + depth(r)
    case _ => SimpleOperations.depth(e)
  }

  def toFormattedString(prefix: String)(e: Expr): String = e match {
    case Mod(l, r) => SimpleOperations.buildExprString(prefix, "Mod", toFormattedString(prefix + INDENT)(l), toFormattedString(prefix + INDENT)(r))
    case UMinus(r) => buildUnaryExprString(prefix, "UMinus", toFormattedString(prefix + INDENT)(r))
    case _ => SimpleOperations.toFormattedString(prefix)(e)
  }

  def buildUnaryExprString(prefix: String, nodeString: String, exprString: String) = {
    val result = new StringBuilder(prefix)
    result.append(nodeString)
    result.append("(")
    result.append(EOL)
    result.append(exprString)
    result.append(")")
    result.toString
  }

  val EOL = SimpleOperations.EOL
  val INDENT = SimpleOperations.INDENT
}