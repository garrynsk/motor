package architect
package motor 
package lexer

import java.nio.CharBuffer

case class Tokenizer(buffer: CharBuffer, tokenTable: TokenTable){

  var start: Int = 0

  def hasNext = {
    start < buffer.length
  }

  def get: Option[Token] = {

    if (buffer != null) {

      var resToken: Option[Token] = None

      tokenTable.tokens.takeWhile{token => 
        val matcher = token._2.pattern.matcher(buffer)
        matcher.region(start, buffer.length)

        val res = matcher.lookingAt
        if(res){
          resToken = token._2 match{
            case op: Nilfix => Some(Nilfix(op.id, matcher.group, op.rbp, op.pattern))
            case _ => Some(token._2)
          }
          
          start = matcher.end
        }else{
          start += 1
        }
        
        !res
      }

      resToken
    }else{
      None
    }

  }
}