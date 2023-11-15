package christmas.model.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static christmas.model.menu.Menu.*;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Nested
    @DisplayName("[메뉴 타입 체크 테스트]")
    class MenuTypeCheckTest {

        @ParameterizedTest
        @EnumSource(
                value = Menu.class,
                names = {"MUSHROOM_SOUP", "TAPAS", "CAESAR_SALAD"}
        )
        @DisplayName("양송이수프, 타파스, 시저샐러드는 에피타이저 메뉴이다")
        void appetizerMenus(Menu menu) {
            // given, when, then
            assertMenuTypeCorrect(menu, MenuType.APPETIZER);
        }

        @ParameterizedTest
        @EnumSource(
                value = Menu.class,
                names = {"T_BONE_STEAK", "BARBECUE_LIP", "SEAFOOD_PASTA", "CHRISTMAS_PASTA"}
        )
        @DisplayName("티본스테이크, 바비큐립, 해산물파스타, 크리스마스파스타는 메인 메뉴이다")
        void mainMenus(Menu menu) {
            // given, when, then
            assertMenuTypeCorrect(menu, MenuType.MAIN);
        }

        @ParameterizedTest
        @EnumSource(
                value = Menu.class,
                names = {"CHOCOLATE_CAKE", "ICE_CREAM"}
        )
        @DisplayName("초코케이크, 아이스크림은 디저트 메뉴이다")
        void dessertMenus(Menu menu) {
            // given, when, then
            assertMenuTypeCorrect(menu, MenuType.DESSERT);
        }

        @ParameterizedTest
        @EnumSource(
                value = Menu.class,
                names = {"ZERO_COKE", "RED_WINE", "CHAMPAGNE"}
        )
        @DisplayName("제로콜라, 레드와인, 샴페인은 음료 메뉴이다")
        void drinkMenus(Menu menu) {
            // given, when, then
            assertMenuTypeCorrect(menu, MenuType.DRINK);
        }

        private void assertMenuTypeCorrect(Menu menu, MenuType menuType) {
            if(menuType == MenuType.MAIN) assertTrue(menu.isMain());
            else assertFalse(menu.isMain());

            if(menuType == MenuType.DESSERT) assertTrue(menu.isDessert());
            else assertFalse(menu.isDessert());

            if(menuType == MenuType.DRINK) assertTrue(menu.isDrink());
            else assertFalse(menu.isDrink());
        }
    }

    @Nested
    @DisplayName("[메뉴명을 통한 메뉴 검증 테스트]")
    class ValidMenuTest {
        @ParameterizedTest
        @ValueSource(strings = {
                "양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립",
                "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림",
                "제로콜라", "레드와인", "샴페인"
        })
        @DisplayName("메뉴판에 등록된 메뉴명은 올바른 메뉴이다")
        void correctMenuName(String menuName) {
            // given, when, then
            assertTrue(Menu.isValidMenu(menuName));
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "양송이", "타 ", "사이다"
        })
        @DisplayName("메뉴판에 등록되지 않은 메뉴명은 메뉴가 아니다")
        void wrongMenuName(String menuName) {
            // given, when, then
            assertFalse(Menu.isValidMenu(menuName));
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "양송이수프", "타파스", "시저샐러드", "티본스테이크", "바비큐립",
                "해산물파스타", "크리스마스파스타", "초코케이크", "아이스크림",
                "제로콜라", "레드와인", "샴페인"
        })
        @DisplayName("메뉴판에 등록된 메뉴명을 입력하면 메뉴 객체가 반환된다")
        void correctMenuNameConvert(String menuName) {
            // given, when, then
            assertDoesNotThrow(() -> Menu.of(menuName));
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "양송이", "타 ", "사이다"
        })
        @DisplayName("메뉴판에 등록되지 않은 메뉴명을 입력하면 예외 처리한다")
        void wrongMenuNameConvert_exception(String menuName) {
            // given, when, then
            assertThrows(IllegalArgumentException.class, () -> Menu.of(menuName));
        }
    }

    @Nested
    @DisplayName("[메뉴 파라미터 테스트]")
    class getMenuParameterValueTest {
        @ParameterizedTest
        @EnumSource(value = Menu.class)
        @DisplayName("메뉴의 가격은 음수가 아니다")
        void isOdd_ShouldReturnTrueForOddNumbers(Menu menu) {
            assertTrue(0 <= menu.getPrice());
        }

    }
}
