package architect
package motor 
package lexer

import java.util.regex.Pattern

case class Postfix(id: String, lbp: Int, rbp: Int, pattern: Pattern) extends DoubleToken{

  override def toString: String = {
    "Postfix("+ id +"," + first +"," + second +")"
  }

}