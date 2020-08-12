package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.strategy.RacingGameLoseMovementStrategy;
import step4.strategy.RacingGameWinMovementStrategy;

import static org.assertj.core.api.Assertions.*;

@DisplayName("도메인 Car에 대한 기능테스트")
public class CarTest {
    Car car;

    @ParameterizedTest
    @CsvSource(value = {"Lady,Lady", "Jamie,Jamie"})
    @DisplayName("생성자 통해 만든 Car 객체에 대해 초기 이름 조건 입력되는지 확인.")
    void create_Car_Domain_With_Name_Test(String name, String expected) {
        car = new Car(name);
        assertThat(car.getCarName()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"Lavender", "Lanister", "Rasputin"})
    @DisplayName("이름 제약조건 추가 : 5자리 넘어갈 시 Exception")
    void create_Car_Domain_Exception_name_size_restriction(String name) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> car = new Car(name));
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0"})
    @DisplayName("초기 생성 후 차량 이동거리에 대한 내용 체크")
    void create_Car_Domain_And_Check_Initial_Distance(int value, int expected) {
        car = new Car("One");
        assertThat(car.getScore(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1"})
    @DisplayName("입력된 boolean값에 따라 차량이 전진할 것인지, 멈춰있을것인지 결정 - Win Case")
    void check_Strategy_Car_Object_With_Strategy_Interface_Win(int value, int expected) {
        car = new Car("Check");
        car.moveWithStrategy(new RacingGameWinMovementStrategy());
        assertThat(car.getScore(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,0"})
    @DisplayName("입력된 boolean값에 따라 차량이 전진할 것인지, 멈춰있을것인지 결정 - Lose Case")
    void check_Strategy_Car_Object_With_Strategy_Interface_Lose(int value, int expected) {
        car = new Car("Check");
        car.moveWithStrategy(new RacingGameLoseMovementStrategy());
        assertThat(car.getScore(value)).isEqualTo(expected);
    }
}