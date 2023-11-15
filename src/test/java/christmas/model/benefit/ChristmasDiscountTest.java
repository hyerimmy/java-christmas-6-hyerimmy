package christmas.model.benefit;

import christmas.model.Plan;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.regex.Pattern;

import static christmas.constant.SystemSetting.ORDER_INPUT_REGEX;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChristmasDiscountTest {
    Benefit christmasDiscountInstance;

    @BeforeEach
    void getInstance() {
        christmasDiscountInstance = Benefit.getAllInstances().stream()
                .filter(benefit -> benefit.getClass() == ChristmasDiscount.class)
                .findFirst().get();
    }

    @Nested
    @DisplayName("[할인 적용 여부 검증 테스트]")
    class checkBenefitApplicable {
        @ParameterizedTest
        @ValueSource(ints = {1,2,24,25})
        @DisplayName("이벤트 기간이면 해당 이벤트가 적용된다")
        void eventApplicable_true(int day) {
            Plan plan = new Plan(day);
            plan.setOrderList(List.of(
                    "티본스테이크-2",
                    "초코케이크-2",
                    "레드와인-1"
            ));
            assertTrue(christmasDiscountInstance.applyBenefit(plan));
        }

        @ParameterizedTest
        @ValueSource(ints = {26,30,31})
        @DisplayName("이벤트 기간이 아니면 해당 이벤트가 적용되지 않는다")
        void eventApplicable_false(int day) {
            Plan plan = new Plan(day);
            plan.setOrderList(List.of(
                    "티본스테이크-2",
                    "초코케이크-2",
                    "레드와인-1"
            ));
            assertFalse(christmasDiscountInstance.applyBenefit(plan));
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

            // when
            christmasDiscountInstance.getDiscountAmount(plan);

            // then
            int result = 3400;
            assert(christmasDiscountInstance.getDiscountAmount(plan) == result);
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
        final String printFormat = "^크리스마스 디데이 할인: -[0-9,]+원$";
        assertTrue(Pattern.matches(printFormat, christmasDiscountInstance.getTitleAndAmountString(plan)));
    }
}
