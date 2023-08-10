package com.it.academy.md.jc1.statements;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Test for class Symbol.")
class SymbolTest {
    private Symbol symbol;

    @SuppressFBWarnings("URF_UNREAD_FIELD")
    @BeforeEach
    void init() {
        symbol = new Symbol();
    }

//    static @NotNull Stream<Arguments> provideArguments() {
//        return Stream.of(
//                Arguments.of('1', "digit"),
//                Arguments.of('0', "digit"),
//                Arguments.of('О', "cyrillic"),
//                Arguments.of('Н', "cyrillic"),
//                Arguments.of('O', "latin"),
//                Arguments.of('l', "latin"),
//                Arguments.of('+', "undefined"),
//                Arguments.of('[', "undefined")
//        );
//    }

//    @ParameterizedTest(name = "Symbol: {0}")
//    @MethodSource("provideArguments")
//    @DisplayName("Test for method getSymbolType() from class Symbol.")
//    void test(final char symbols, final String expected) {
//        var actual = symbol.getSymbolType(symbols);
//
//        assertEquals(expected, actual);
//    }
}
