package christmas.model;

import christmas.model.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.List;

import static christmas.constant.SystemSetting.MAXIMUM_NUMBER_OF_ORDER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class PlanTest {
    Plan plan;

    @Nested
    @DisplayName("생성자를 통해 방문일을 입력받아 Plan 객체에 설정한다")
    class CreatePlanWithValidDay {
        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 32, 33})
        @DisplayName("이벤트 날짜 범위를 벗어나는 경우 예외 처리한다")
        void wrongDay_exception(int day) {
            assertThrows(IllegalArgumentException.class, () -> new Plan(day));
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 15, 30, 31})
        @DisplayName("이벤트 날짜가 올바르게 입력된 경우 객체를 생성한다")
        void correctDay(int day) {
            assertDoesNotThrow(() -> new Plan(day));
        }
    }

    @Nested
    @DisplayName("Plan 객체에 주문 목록을 설정한다")
    class SetOrderListOfPlan {
        @BeforeEach
        void init() {
            plan = new Plan(25);
        }

        @Test
        @DisplayName("주문 문자열 리스트가 올바르게 입력된 경우 오류를 반환하지 않는다")
        void correctOrderList() {
            // given
            final List<String> orderInputs = List.of("제로콜라-1", "크리스마스파스타-2");

            // when, then
            assertDoesNotThrow(() -> plan.setOrderList(orderInputs));
        }

        @Test
        @DisplayName("주문 데이터 입력값의 형태가 올바르지 않은 경우 예외 처리한다")
        void wrongPatternOrderData_exception() {
            // given
            final List<String> orderInputs = List.of("제로콜라-1", "크리스마스파스타:2");

            // when, then
            assertThrows(IllegalArgumentException.class, () -> plan.setOrderList(orderInputs));
        }

        @Test
        @DisplayName("중복되는 메뉴가 있을 경우 예외 처리한다")
        void duplicateMenu_exception() {
            // given
            final List<String> orderInputs = List.of("제로콜라-1", "크리스마스파스타-2", "크리스마스파스타-1");

            // when, then
            assertThrows(IllegalArgumentException.class, () -> plan.setOrderList(orderInputs));
        }

        @Test
        @DisplayName("주문 개수가 최대 개수를 넘을 경우 예외 처리한다")
        void overMaximumNumberOfOrder() {
            // given
            final int overNumberOfMaximum = MAXIMUM_NUMBER_OF_ORDER + 1;
            final List<String> orderInputs = List.of(
                    "크리스마스파스타-" + overNumberOfMaximum,
                    "제로콜라-50"
            );

            // when, then
            assertThrows(IllegalArgumentException.class, () -> plan.setOrderList(orderInputs));
        }
    }

    @Test
    @DisplayName("주문 총 합계 금액을 반환한다")
    void totalAmount() {
        // given
        plan = new Plan(25);
        plan.setOrderList(List.of(
                "크리스마스파스타-2",
                "시저샐러드-1",
                "샴페인-1"
        ));

        // when
        final int result = 25_000 * 2 + 8_000 + 25_000;

        // then
        assertThat(plan.getTotalAmount()).isEqualTo(result);
    }

    @Nested
    @DisplayName("일정 타입의 메뉴만을 모아 반환한다")
    class checkOrdersMenuType {
        @BeforeEach
        void init() {
            plan = new Plan(25);
            plan.setOrderList(List.of(
                    "티본스테이크-2",
                    "초코케이크-2",
                    "아이스크림-3",
                    "레드와인-6",
                    "제로콜라-1"
            ));
        }

        @Test
        @DisplayName("메인 메뉴 주문만 모아 반환한다")
        void mainMenuOrders() {
            HashMap<String, Integer> result = new HashMap<>();
            result.put("티본스테이크", 2);
            assertOrderListIsCorrect(plan.getMainMenuOrders(), result);
        }

        @Test
        @DisplayName("디저트 메뉴 주문만 모아 반환한다")
        void dessertMenuOrders() {
            HashMap<String, Integer> result = new HashMap<>();
            result.put("초코케이크", 2);
            result.put("아이스크림", 3);
            assertOrderListIsCorrect(plan.getDessertMenuOrders(), result);
        }

        private void assertOrderListIsCorrect(List<Order> orderList, HashMap<String, Integer> result) {
            assert (orderList.size() == result.size());

            for (Order order : orderList) {
                String name = order.getMenuName();
                assert (result.get(name) == order.getCount());
            }
        }
    }

    @Nested
    @DisplayName("[음료만 주문했는지 검증 테스트]")
    class OnlyDrinkOrderTest {
        @Test
        @DisplayName("음료 메뉴만 주문하지 않은 경우 false를 반환한다")
        void onlyDessertOrder_false() {
            plan = new Plan(25);
            plan.setOrderList(List.of(
                    "티본스테이크-2",
                    "초코케이크-2",
                    "레드와인-6"
            ));
            assertFalse(plan.containOnlyDrinkMenus());
        }

        @Test
        @DisplayName("음료 메뉴만 주문한 경우 true를 반환한다")
        void onlyDessertOrder_true() {
            plan = new Plan(25);
            plan.setOrderList(List.of(
                    "레드와인-6",
                    "제로콜라-10"
            ));
            assertTrue(plan.containOnlyDrinkMenus());
        }
    }

    @Nested
    @DisplayName("[혜택 계산 테스트]")
    class BenefitTest {
        @BeforeEach
        void init() {
            plan = new Plan(25);
            plan.setOrderList(List.of(
                    "티본스테이크-2",
                    "초코케이크-2",
                    "레드와인-1"
            ));
            plan.calculateBenefitList();
        }

        @Test
        @DisplayName("혜택 리스트를 반환한다")
        void benefitList() {
            List<String> result = List.of(
                    "크리스마스 디데이 할인: -3,400원",
                    "평일 할인: -4,046원",
                    "특별 할인: -1,000원",
                    "증정 이벤트: -25,000원"
            );
            assertListIsSame(plan.getBenefitList(), result);
        }

        @Test
        @DisplayName("혜택 금액을 반환한다")
        void benefitAmount() {
            int result = 33_446;
            assertEquals(plan.getTotalBenefitAmount(), result);
        }

        @Test
        @DisplayName("할인 후 금액을 반환한다")
        void discountAmount() {
            int result = 191_554;
            assertEquals(plan.getTotalAmountAfterDiscount(), result);
        }


        private void assertListIsSame(List<String> list1, List<String> list2) {
            assert (list1.size() == list2.size());
            for (String data : list1) {
                assert (list2.contains(data));
            }
        }
    }
}
