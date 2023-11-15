package christmas.utils;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormattedPrinterTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(out));
    }

    @Nested
    @DisplayName("[형식화된 문자열 프린트 테스트]")
    class ReadNumberTest {
        @Test
        @DisplayName("입력된 예외 메시지가 다시 입력해주세요 문구와 함께 출력된다.")
        void exceptionMessage() {
            // given
            final String exceptionMessage = "숫자 형식이 아닙니다.";

            // when
            FormattedPrinter.printlnExceptionWithReEnterMessage(exceptionMessage);

            // then
            final String answer = "숫자 형식이 아닙니다. 다시 입력해 주세요.";
            assertThat(out.toString()).isEqualToIgnoringNewLines(answer);
        }

        @Test
        @DisplayName("입력된 메시지를 헤더 형식으로 출력한다.")
        void headerMessage() {
            // given
            final String headerMessage = "제목";

            // when
            FormattedPrinter.printlnHeaderMessage(headerMessage);

            // then
            final String answer = "<제목>";
            assertThat(out.toString()).isEqualToIgnoringNewLines(answer);
        }
    }
}
