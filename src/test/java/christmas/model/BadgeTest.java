package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BadgeTest {
    @Nested
    @DisplayName("[혜택금액 별 뱃지 계산 테스트]")
    class BenefitAmountTest{
        @ParameterizedTest
        @ValueSource(ints = {0, 2_500, 4_999})
        @DisplayName("혜택 금액이 5,000원 미만일 경우 '없음'을 반환한다")
        void defaultBadge(int benefitAmount){
            assert (Badge.getBadgeNameOf(benefitAmount).equals("없음"));
        }

        @ParameterizedTest
        @ValueSource(ints = {5_000, 7_500, 9_999})
        @DisplayName("혜택 금액이 5,000원 이상 10,000원 미만일 경우 '별'을 반환한다")
        void starBadge(int benefitAmount){
            assert (Badge.getBadgeNameOf(benefitAmount).equals("별"));
        }

        @ParameterizedTest
        @ValueSource(ints = {10_000, 15_000, 19_999})
        @DisplayName("혜택 금액이 10,000원 이상 20,000원 미만일 경우 '트리'을 반환한다")
        void treeBadge(int benefitAmount){
            assert (Badge.getBadgeNameOf(benefitAmount).equals("트리"));
        }

        @ParameterizedTest
        @ValueSource(ints = {20_000, 100_000, Integer.MAX_VALUE})
        @DisplayName("혜택 금액이 20,000원 이상일 경우 '산타'을 반환한다")
        void santaBadge(int benefitAmount){
            assert (Badge.getBadgeNameOf(benefitAmount).equals("산타"));
        }
    }
}
