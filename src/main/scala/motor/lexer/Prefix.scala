package architect
package motor 
package lexer

import java.util.regex.Pattern

case class Prefix(id: String, rbp: Int, pattern: Pattern) extends SingleToken{self =>
    override def nud: Option[Prefix] = Some(self)

  override def toString: String = {
    "Prefix("+ id + ")"
  }
}