package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BadgeTest {
    @Nested
    @DisplayName("[혜택금액 별 뱃지 계산 테스트]")
    class BenefitAmountTest{
        @ParameterizedTest
        @ValueSource(longs = {0, 2_500, 4_999})
        @DisplayName("혜택 금액이 5,000원 미만일 경우 '없음'을 반환한다")
        void defaultBadge(long benefitAmount){
            assert (Badge.getBadgeNameOf(benefitAmount).equals("없음"));
        }

        @ParameterizedTest
        @ValueSource(longs = {5_000, 7_500, 9_999})
        @DisplayName("혜택 금액이 5,000원 이상 10,000원 미만일 경우 '별'을 반환한다")
        void starBadge(long benefitAmount){
            assert (Badge.getBadgeNameOf(benefitAmount).equals("별"));
        }

        @ParameterizedTest
        @ValueSource(longs = {10_000, 15_000, 19_999})
        @DisplayName("혜택 금액이 10,000원 이상 20,000원 미만일 경우 '트리'을 반환한다")
        void treeBadge(long benefitAmount){
            assert (Badge.getBadgeNameOf(benefitAmount).equals("트리"));
        }

        @ParameterizedTest
        @ValueSource(longs = {20_000, 100_000, Long.MAX_VALUE})
        @DisplayName("혜택 금액이 20,000원 이상일 경우 '산타'을 반환한다")
        void santaBadge(long benefitAmount){
            assert (Badge.getBadgeNameOf(benefitAmount).equals("산타"));
        }
    }
}
