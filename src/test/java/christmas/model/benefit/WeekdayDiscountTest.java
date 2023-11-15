package christmas.model.benefit;

import christmas.model.Plan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WeekdayDiscountTest {
    Benefit weekdayDiscountInstance;

    @BeforeEach
    void getInstance() {
        weekdayDiscountInstance = Benefit.getAllInstances().stream()
                .filter(benefit -> benefit.getClass() == WeekdayDiscount.class)
                .findFirst().get();
    }

    @Nested
    @DisplayName("[할인 적용 여부 검증 테스트]")
    class checkBenefitApplicable {
        @ParameterizedTest
        @ValueSource(ints = {3,7,10,14,17,21,24,18,31})
        @DisplayName("이벤트 기간이면서 평일(일~목)이면 해당 이벤트가 적용된다")
        void eventApplicable_true(int day) {
            Plan plan = new Plan(day);
            plan.setOrderList(List.of(
                    "티본스테이크-2",
                    "초코케이크-2",
                    "레드와인-1"
            ));
            assertTrue(weekdayDiscountInstance.applyBenefit(plan));
        }

        @ParameterizedTest
        @ValueSource(ints = {1,2,8,9,15,16,22,23,29,30})
        @DisplayName("평일(일~목)이 아니면 해당 이벤트가 적용되지 않는다")
        void eventApplicable_false(int day) {
            Plan plan = new Plan(day);
            plan.setOrderList(List.of(
                    "티본스테이크-2",
                    "초코케이크-2",
                    "레드와인-1"
            ));
            assertFalse(weekdayDiscountInstance.applyBenefit(plan));
        }
    }

    @Nested
    @DisplayName("[할인 금액 계산 테스트]")
    class calculateDiscountAmountTest {
        @Test
        @DisplayName("할인 금액이 올바르게 계산된다")
        void discountAmount() {
            // given
            Plan plan = new Plan(25);
            plan.setOrderList(List.of(
                    "티본스테이크-2",
                    "초코케이크-2",
                    "레드와인-1"
            ));

            // when, then
            int result = 4046;
            assert (weekdayDiscountInstance.getDiscountAmount(plan) == result);
        }
    }

    @Test
    @DisplayName("할인 제목 및 금액이 올바른 형태로 출력된다.")
    void titleAndAmountPrint() {
        // give
        Plan plan = new Plan(25);
        plan.setOrderList(List.of(
                "티본스테이크-2",
                "초코케이크-2",
                "레드와인-1"
        ));

        // when, then
        final String printFormat = "^평일 할인: -[0-9,]+원$";
        assertTrue(Pattern.matches(printFormat, weekdayDiscountInstance.getTitleAndAmountString(plan)));
    }
}
