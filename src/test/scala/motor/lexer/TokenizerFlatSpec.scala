package architect
package motor

import org.scalatest._
import prop._
import motor.lexer._
import java.util.regex.Pattern
import java.io.File
import java.io.FileInputStream
import java.nio.channels.FileChannel.MapMode._
import java.nio.charset.StandardCharsets
import java.nio.CharBuffer
import java.util.regex.Pattern

class TokenizerFlatSpec extends FlatSpec with Matchers{

  val file = new File("/home/panda/PandaHome/pandastorage/developing/server/mutator/architect/parser/parser/somefile.txt")
  val fileSize = file.length
  val stream = new FileInputStream(file)
  val buffer = stream.getChannel.map(READ_ONLY, 0, fileSize)
  val result: CharBuffer = StandardCharsets.UTF_8.decode(buffer);
  val tokens = TokenTable()

  val number = Nilfix("number", "0", 0, Pattern.compile("([\\d+])"))
  val plus = Infix("plus", 40, 40, Pattern.compile("([+])"))
  val minus = Infix("minus", 40, 40, Pattern.compile("([-])"))
  val mult = Infix("mult", 60, 60, Pattern.compile("([*])"))

  tokens.add(number)
  tokens.add(plus)
  tokens.add(minus)
  tokens.add(mult)

  "Tokenizer" should "return tokens by id." in {
    
      val tokenizer = Tokenizer(result, tokens)

      if(tokenizer.hasNext){
        val token = tokenizer.get
        token should be (Some(number))
      }

      if(tokenizer.hasNext){
        val token = tokenizer.get
        token should be (Some(plus))
      }

      if(tokenizer.hasNext){
        val token = tokenizer.get
        token should be (Some(minus))
      }

      if(tokenizer.hasNext){
        val token = tokenizer.get
        token should be (Some(mult))
      }


  }

}