package architect
package motor 
package lexer

import scala.collection.mutable.Map

case class TokenTable()  {

  val tokens: Map[String, Token] = Map()

  def head: Option[(String, Token)] = {
    if(isEmpty){
      None
    }else{
      Some(tokens.head)
    }

  }

  def get(id: String): Option[Token] = {

      tokens.get(id) 

  }

  def isEmpty: Boolean = {

    tokens.isEmpty

  }
  def add(token: Token): Token = {

    val newToken = tokens.get(token.id)

    newToken match{
      case Some(op: Token) => {
        
          op
        
      }
     
      case None => {
        tokens += (token.id -> token)
        token

      }
    }
  }
}