package christmas.model;

import christmas.model.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {
    @Nested
    @DisplayName("[Order 객체 생성 테스트]")
    class BenefitAmountTest {
        @Nested
        @DisplayName("정보를 담은 문자열을 입력해 객체를 생성한다")
        class CreateOrderByOrderData {
            @ParameterizedTest
            @ValueSource(strings = {"양송이수프1개", "500-1", "제로콜라:1", "해산물파스타-2,레드와인-1"})
            @DisplayName("문자열 패턴에 맞지 않는 경우 예외 처리한다")
            void wrongPattern_exception(String orderData) {
                assertThrows(IllegalArgumentException.class, () -> new Order(orderData));
            }

            @ParameterizedTest
            @ValueSource(strings = {"사이다-1", "콜라-1", "ZERO_COKE-1"})
            @DisplayName("등록되지 않은 메뉴를 입력할 경우 예외 처리한다")
            void invalidMenuName_exception(String orderData) {
                assertThrows(IllegalArgumentException.class, () -> new Order(orderData));
            }

            @ParameterizedTest
            @ValueSource(strings = {"제로콜라-0", "해산물파스타--1", "제로콜라-"+Integer.MAX_VALUE+1})
            @DisplayName("메뉴 개수가 0 이하이거나 int 최대 범위를 벗어나면 예외 처리한다")
            void invalidCountNumber_exception(String orderData) {
                assertThrows(IllegalArgumentException.class, () -> new Order(orderData));
            }
        }

        @Nested
        @DisplayName("메뉴와 개수를 입력해 객체를 생성한다")
        class CreateOrderByMenuAndCount {
            @ParameterizedTest
            @EnumSource(value = Menu.class)
            @DisplayName("어떤 메뉴를 입력하든 객체 생성에 성공한다")
            void allMenuCanCreateOrder(Menu menu) {
                assertDoesNotThrow(() -> new Order(menu, 1));
            }

            @ParameterizedTest
            @ValueSource(ints = {0, -1, Integer.MAX_VALUE+1})
            @DisplayName("메뉴 개수가 0 이하이거나 int 최대 범위를 벗어나면 예외 처리한다")
            void outOrRangeCountNumber_exception(int count) {
                assertThrows(IllegalArgumentException.class, () -> new Order(Menu.CHAMPAGNE, count));
            }
        }
    }

    @Nested
    @DisplayName("Order 객체 값 조회 함수 테스트")
    class OrderGetFunctionTest {
        @Test
        @DisplayName("메뉴와 개수를 패턴에 적용하여 올바르게 반환한다")
        void menuAndCountStringFormat() {
            // given
            final Order order = new Order(Menu.CHRISTMAS_PASTA, 7);

            // when, then
            String result = "크리스마스파스타 7개";
            assertThat(order.getMenuAndCountString()).isEqualTo(result);
        }
        @Test
        @DisplayName("총 금액을 계산하여 반환한다")
        void calculateAmount() {
            // given
            final Menu menu = Menu.CHRISTMAS_PASTA;
            final int count = 7;
            final Order order = new Order(menu, count);

            // when, then
            long result = menu.getPrice() * count;
            assertThat(order.getAmount()).isEqualTo(result);
        }
    }
}
