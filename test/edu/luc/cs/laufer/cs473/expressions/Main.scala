package edu.luc.cs.laufer.cs473.expressions

import expressions._

object evaluate extends Evaluate
object extendedEvaluate extends ExtendedEvaluate

object Main {
  def main(args : Array[String]) : Unit = {
    val p =
      Div(
        Minus(
          Plus(
            Constant(1),
            Constant(2)
          ),
          Times(
            Constant(3),
            Constant(4)
          )
        ),
        Constant(5)
      );
    println("p = " + p)
    println("evaluate(p) = " + evaluate(p))

    val q =
        Mod(
          Minus(
            Plus(
              Constant(1),
              Constant(2)
            ),
            Times(
              UMinus(
                Constant(3)
              ),
              Constant(4)
            )
          ),
          Constant(5)
        );

    println("q = " + q)
    println("evaluate(q) = " + extendedEvaluate(q))
  }
}
