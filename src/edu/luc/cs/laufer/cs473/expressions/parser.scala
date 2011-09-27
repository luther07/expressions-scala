package edu.luc.cs.laufer.cs473.expressions

import scala.util.parsing.combinator._

object ExprParser extends JavaTokenParsers {
  def expr: Parser[Expr] = (
    term ~ "+" ~ term ^^ { case l ~ _ ~ r => Plus(l, r) }
  | term ~ "-" ~ term ^^ { case l ~ _ ~ r => Minus(l, r) }
  | term
  | factor
  )
  def term: Parser[Expr] = (
    factor ~ "*" ~ factor ^^ { case l ~ _ ~ r => Times(l, r) }
  | factor ~ "/" ~ factor ^^ { case l ~ _ ~ r => Div(l, r) }
  | factor
  )
  def factor: Parser[Expr] = (
    wholeNumber ^^ { case s => Constant(s.toInt) }
  | "(" ~ expr ~ ")" ^^ { case _ ~ e ~ _ => e } 
  )
}
