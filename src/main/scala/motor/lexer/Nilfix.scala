
package architect
package motor 
package lexer

import java.util.regex.Pattern

case class Nilfix(id: String, value: String, rbp: Int, pattern: Pattern) extends SingleToken{self =>
    override def nud: Option[Nilfix] = Some(self)

  override def toString: String = {
    "Nilfix("+ id +"," + value + ")"
  }
}