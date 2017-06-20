import junit.framework.Assert.assertEquals
import org.junit.Test

class RpnKalkulatorShould {

    companion object {
        val ONE_DIGIT_INPUT = "1"
    }

    @Test
    fun return_the_same_digit_when_a_digit_is_sent() {
        val rpnKalkulator = RpnKalkulator()

        val result = rpnKalkulator.calculate(ONE_DIGIT_INPUT)

        assertEquals(ONE_DIGIT_INPUT, result)
    }
}