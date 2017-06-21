import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RpnKalkulatorShould {

    companion object {
        val ONE_DIGIT_INPUT = "1"
        val TWO_DIGIT_INPUT = "20 5 /"
        val TWO_OPERATIONS_INPUT = "4 2 + 3 -"
        val THREE_OPERATIONS_INPUT = "3 5 8 * 7 + *"
        val FOUR_DIGITS_ONE_OPERATION_INPUT = "7 2 - 3 4"

        val ONE_DIGIT_OUTPUT = "1"
        val TWO_DIGIT_OUTPUT = "4"
        val TWO_OPERATIONS_OUTPUT = "3"
        val THREE_OPERATIONS_OUTPUT = "141"
        val FOUR_DIGITS_ONE_OPERATION_OUTPUT = "5 3 4"
    }

    lateinit var rpnKalkulator : RpnKalkulator

    @Before
    fun setUp() {
        rpnKalkulator = RpnKalkulator()
    }

    @Test
    fun return_the_same_digit_when_a_digit_is_sent() {
        val result = rpnKalkulator.calculate(ONE_DIGIT_INPUT)

        assertEquals(ONE_DIGIT_OUTPUT, result)
    }

    @Test
    fun return_operation_result_for_two_digits_and_one_operation() {
        val result = rpnKalkulator.calculate(TWO_DIGIT_INPUT)

        assertEquals(TWO_DIGIT_OUTPUT, result)
    }

    @Test
    fun return_operation_result_for_three_digits_and_two_operations() {
        val result = rpnKalkulator.calculate(TWO_OPERATIONS_INPUT)

        assertEquals(TWO_OPERATIONS_OUTPUT, result)
    }

    @Test
    fun return_operation_result_for_four_digits_and_three_operations() {
        val result = rpnKalkulator.calculate(THREE_OPERATIONS_INPUT)

        assertEquals(THREE_OPERATIONS_OUTPUT, result)
    }

    @Test
    fun return_operation_result_for_four_digits_and_one_operation() {
        val result = rpnKalkulator.calculate(FOUR_DIGITS_ONE_OPERATION_INPUT)

        assertEquals(FOUR_DIGITS_ONE_OPERATION_OUTPUT, result)
    }
}