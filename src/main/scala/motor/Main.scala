package architect
package motor

import java.io.File
import java.io.FileInputStream
import java.nio.channels.FileChannel.MapMode._
import java.nio.charset.StandardCharsets
import java.nio.CharBuffer
import motor.lexer._
import motor.parser._
import java.util.regex.Pattern

object Main extends App {
  
      val file = new File("/home/panda/PandaHome/pandastorage/developing/server/mutator/architect/parser/parser/somefile.txt")
      val fileSize = file.length
      val stream = new FileInputStream(file)
      val buffer = stream.getChannel.map(READ_ONLY, 0, fileSize)
      val result: CharBuffer = StandardCharsets.UTF_8.decode(buffer);

      val IntRegEx = "([\\d+])".r
      val PlusRegEx = "([+])".r
      val MinusRegEx = "([-])".r
      val MultRegEx = "([*])".r
      val DivRegEx = "([/])".r
      val EqRegEx = "([=])".r

      val tokens = TokenTable()

      val number = Nilfix("number", "0", 0, Pattern.compile("([\\d+])"))
      val plus = Infix("plus", 40, 40, Pattern.compile("([+])"))
      val minus = Infix("minus", 40, 40, Pattern.compile("([-])"))
      val mult = Infix("mult", 60, 60, Pattern.compile("([*])"))

      tokens.add(number)
      tokens.add(plus)
      tokens.add(minus)
      tokens.add(mult)

      val parser = Parser(tokens, result)
      println(parser.parse)
  


}