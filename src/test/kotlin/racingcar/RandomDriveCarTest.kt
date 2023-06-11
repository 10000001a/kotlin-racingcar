package racingcar

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.RandomDriveCar
import racingcar.domain.RandomNumberGenerator

class RandomDriveCarTest {

    private val randomNumberGenerator: RandomNumberGenerator = mockk()

    @Test
    fun `drive car`() {
        val minDriveRandomNumber: Long = 1
        val car = RandomDriveCar(
            carNumber = 1,
            randomNumberGenerator = randomNumberGenerator,
            minDriveRandomNumber = minDriveRandomNumber,
            name = "UNKNOWN",
        )

        every { randomNumberGenerator.generate() } returns minDriveRandomNumber

        car.drive()

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `stop car`() {
        val minDriveRandomNumber: Long = 20
        val car = RandomDriveCar(
            carNumber = 1,
            randomNumberGenerator = randomNumberGenerator,
            minDriveRandomNumber = minDriveRandomNumber,
            name = "UNKNOWN",
        )

        every { randomNumberGenerator.generate() } returns minDriveRandomNumber - 1

        car.drive()

        assertThat(car.position).isEqualTo(0)
    }
}