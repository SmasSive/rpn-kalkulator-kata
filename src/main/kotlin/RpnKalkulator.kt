import java.util.ArrayList
import javax.naming.OperationNotSupportedException

class RpnKalkulator {

    companion object {
        private val operations = arrayListOf("+", "-", "*", "/")
    }

    var elementStack = arrayListOf<Int>()

    fun calculate(input: String): String {
        input.split(" ").map { unparsedElement -> parse(unparsedElement) }
        return elementStack.format()
    }

    private fun parse(unparsedElement: String) {
        if (isNumber(unparsedElement)) {
            elementStack.add(unparsedElement.toInt())
        } else if (isOperand(unparsedElement)) {
            elementStack.add(calculate(elementStack.pop(), elementStack.pop(), unparsedElement))
        }
    }

    private fun calculate(second: Int?, first: Int?, operation: String) = when (operation) {
        "+" -> first!! + second!!
        "-" -> first!! - second!!
        "*" -> first!! * second!!
        "/" -> first!! / second!!
        else -> throw OperationNotSupportedException()
    }

    private fun isNumber(unparsedElement: String): Boolean {
        try {
            unparsedElement.toInt()
        } catch (nfe: NumberFormatException) {
            return false
        }
        return true
    }

    private fun isOperand(unparsedElement: String): Boolean = operations.contains(unparsedElement)
}

private fun <E> ArrayList<E>.pop(): E? {
    if (this.isEmpty()) {
        return null
    } else {
        return removeAt(size - 1)
    }
}

private fun <E> ArrayList<E>.format(): String {
    var output = ""
    var index = size
    for (element in this) {
        output += element.toString()
        index--
        if (index > 0) {
            output += " "
        }
    }
    return output
}
