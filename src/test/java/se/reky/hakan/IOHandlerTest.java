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
    @DisplayName("Testa så scanner.nextLine innehåller samma data som den instansieras med")
    void testScannerData() {
        ioHandler = testHandler("test");
        assertEquals("test", ioHandler.nextLine());
    }

    @Test
    @DisplayName("Testa så scannern konverterar en sträng till en integer när vi använder .hasNextInt")
    void testIOHandler() {
        ioHandler = testHandler("1");
        assertTrue(ioHandler.hasNextInt());
    }
}