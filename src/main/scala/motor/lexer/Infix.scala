package architect
package motor 
package lexer

import java.util.regex.Pattern

case class Infix(id: String, lbp: Int, rbp: Int, pattern: Pattern) extends DoubleToken{

  override def toString: String = {
    "Infix("+ id +"," + first +"," + second +")"
  }

}