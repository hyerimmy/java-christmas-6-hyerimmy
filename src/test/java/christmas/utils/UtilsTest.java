package christmas.utils;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilsTest {
    @AfterEach
    void closeConsole() {
        Console.close();
    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Nested
    @DisplayName("숫자 입력 테스트")
    class ReadNumberTest {
        @Test
        @DisplayName("숫자를 입력할 경우 int값으로 변환하여 반환한다")
        void numberValue() {
            // given
            systemIn("10");

            // when
            final int userInput = Utils.parseInt("10");

            // then
            int result = 10;
            assertThat(userInput).isEqualTo(result);
        }

        @Test
        @DisplayName("숫자가 아닌 값을 입력할 경우 예외처리한다")
        void notNumberValueException() {
            // given
            systemIn("ten");

            // when, then
            assertThrows(IllegalArgumentException.class, () -> Utils.parseInt("ten"));
        }
    }

    @Nested
    @DisplayName("문자열 리스트 입력 테스트")
    class ReadStringListTest {

        @Test
        @DisplayName("콤마로 구분된 2개 이상의 문자열을 입력할 경우 List로 변환하여 반환한다")
        void correctTypeValueWithComma() {
            // given
            systemIn("바비큐립-2,아이스크림-1");

            // when
            List<String> userInput = Utils.readStringList();

            // then
            List<String> result = List.of("바비큐립-2", "아이스크림-1");
            assertThat(userInput).isEqualTo(result);
        }

        @Test
        @DisplayName("콤마가 없는 문자열을 입력할 경우 List로 변환하여 반환한다")
        void correctTypeValue() {
            // given
            systemIn("바비큐립-2");

            // when
            List<String> userInput = Utils.readStringList();

            // then
            List<String> result = List.of("바비큐립-2");
            assertThat(userInput).isEqualTo(result);
        }

        @Test
        @DisplayName("빈 문자열을 입력할 경우 예외 처리한다")
        void EmptyValue() {
            // given
            systemIn("  ");

            // when, then
            assertThrows(IllegalArgumentException.class, Utils::readStringList);
        }

        @Test
        @DisplayName("빈 문자열을 입력할 경우 예외 처리한다")
        void EmptyValueWithComma() {
            // given
            systemIn(",, ,");

            // when, then
            assertThrows(IllegalArgumentException.class, Utils::readStringList);
        }
    }
}
