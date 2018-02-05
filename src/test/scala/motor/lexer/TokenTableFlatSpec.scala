
package architect
package motor

import org.scalatest._
import prop._
import motor.lexer._
import java.util.regex.Pattern

class TokenTableFlatSpec extends FlatSpec with Matchers{

  "TokenTable" should "return tokens by id." in {

      val tokens = TokenTable()
      
      val number = Nilfix("number", "0", 0, Pattern.compile("([\\d+])"))
      val plus = Infix("plus", 40, 40, Pattern.compile("([+])"))
      val minus = Infix("minus", 40, 40, Pattern.compile("([-])"))
      val mult = Infix("mult", 60, 60, Pattern.compile("([*])"))

      tokens.add(number)
      tokens.add(plus)
      tokens.add(minus)
      tokens.add(mult)

      tokens.get("plus") should be (Some(plus))
      tokens.get("minus") should be (Some(minus))
      tokens.get("mult") should be (Some(mult))
      tokens.get("number") should be (Some(number))


  }

}