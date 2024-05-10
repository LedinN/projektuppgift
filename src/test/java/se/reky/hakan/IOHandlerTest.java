package se.reky.hakan;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class IOHandlerTest {

    private IOHandler ioHandler;

    private IOHandler testHandler(String dataForScanner) {
        Scanner scanner = new Scanner(dataForScanner);
        return new IOHandler(scanner);
    }

    @Test
    @DisplayName("Ensure Scanner.nextLine returns expected data")
    void should_ReturnExpectedData_When_UsingScannerNextLine() {
        ioHandler = testHandler("test");
        assertEquals("test", ioHandler.nextLine());
    }

    @Test
    @DisplayName("Ensure scanner converts string to integer")
    void should_IdentifyInteger_When_UsingHasNextInt() {
        ioHandler = testHandler("1");
        assertTrue(ioHandler.hasNextInt());
    }
}