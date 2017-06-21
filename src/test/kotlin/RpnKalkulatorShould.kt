import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RpnKalkulatorShould {

    companion object {
        val ONE_DIGIT_INPUT = "1"
        val TWO_DIGIT_INPUT = "20 5 /"

        val ONE_DIGIT_OUTPUT = "1"
        val TWO_DIGIT_OUTPUT = "4"
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
}