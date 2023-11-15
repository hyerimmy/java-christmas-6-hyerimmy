package christmas.model.benefit;

import christmas.model.Plan;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BenefitTest {
    @Nested
    @DisplayName("[이벤트 적용 검증 테스트]")
    class eventApplicable{
        @Test
        @DisplayName("총 계산 금액이 최소 금액을 만족하고 음료만 주문한 것이 아니라면 이벤트 적용가능하다.")
        void eventApplicable_true(){
            Plan plan = new Plan(25);
            plan.setOrderList(List.of(
                    "티본스테이크-2",
                    "초코케이크-2",
                    "레드와인-1"
            ));
            assertTrue(Benefit.isEventApplicable(plan));
        }

        @Test
        @DisplayName("총 계산 금액이 최소 금액보다 적으면 이벤트 적용 대상이 아니다.")
        void eventApplicable_amount_false(){
            Plan plan = new Plan(25);
            plan.setOrderList(List.of(
                    "양송이수프-1"
            ));
            assertFalse(Benefit.isEventApplicable(plan));
        }

        @Test
        @DisplayName("음료만 주문한 것이라면 이벤트 적용 대상이 아니다.")
        void eventApplicable_menuType_false(){
            Plan plan = new Plan(25);
            plan.setOrderList(List.of(
                    "레드와인-5"
            ));
            assertFalse(Benefit.isEventApplicable(plan));
        }
    }
}
