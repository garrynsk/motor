package architect
package motor
package parser

import motor.lexer.{TokenTable, Tokenizer, Token}
import java.nio.CharBuffer

case class Parser(tokenTable: TokenTable, buffer: CharBuffer){
  
  val tokenizer = Tokenizer(buffer, tokenTable)
  

  def consume(token: Token, next: Token): Option[Token] = {
    val result: Option[Token] = if(token.rbp <= next.lbp){

      next.led(token.nud, parse)
      
    }else{
      token.nud
    }
    result
  }

  def parse = {
    var result: Option[Token] = None
    while(tokenizer.hasNext){
      val token = tokenizer.get
      val next = tokenizer.get
      println("token " + token)
      println("result " + result)
      token match{
        case Some(tokenValue) => {
          result = next match{
            case Some(nextValue) => {
              consume(tokenValue, nextValue)
            }
            case None => tokenValue.nud
          }
        }
        case None => None
      }

    }
    result
  }

}
