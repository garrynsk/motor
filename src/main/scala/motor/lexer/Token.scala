package architect
package motor 
package lexer

import java.util.regex.Pattern

trait Token{

  def nud: Option[Token] = None

  def led(left: Option[Token], right: Option[Token]): Option[Token] = None
  
  val rbp: Int 
  
  val lbp: Int

  val id: String

  val pattern: Pattern

}

trait SingleToken extends Token {self =>

  override val lbp: Int = 0
}


trait DoubleToken extends Token {
  val first: Option[Token] = None
  val second: Option[Token] = None

  override def led(left: Option[Token], right: Option[Token]): Option[Infix] = {
    val newToken = new Infix(id, lbp, rbp, pattern){
      override val first: Option[Token] = left
      override val second: Option[Token] = right
    }
    Some(newToken)
  }
}
