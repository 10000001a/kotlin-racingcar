package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.strategy.FairStrategy

internal class CarTest {
    private val car = Car("car", FairStrategy())

    companion object {
        const val DISTANCE = 5
    }

    @BeforeEach
    fun setUp() {
        for (i in 1..DISTANCE) {
            car.moveForward()
        }
    }

    @Test
    fun getName() {
        assertThat(car.getName()).isEqualTo("car")
    }

    @Test
    fun isWinner() {
        assertThat(car.isWinner(DISTANCE)).isTrue()
    }

    @Test
    fun getDistance() {
        assertThat(car.toString()).isEqualTo("car : ${"-".repeat(DISTANCE)}\n")
    }

    @Test
    fun moveForward() {
        assertThat(car.moveForward()).isEqualTo(DISTANCE + 1)
    }
}