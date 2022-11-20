package racingcar.domain

import racingcar.domain.strategy.MoveStrategy

data class Car(
    val participateCarName: ParticipateCarName,
    val currentPosition: Int = 0,
) {
    fun move(moveStrategy: MoveStrategy): Car {
        return when (moveStrategy.isPossibleMove()) {
            true -> this.copy(currentPosition = currentPosition + moveStrategy.getDistance())
            false -> this
        }
    }
}
