package cookieClickerImplements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraniesStubTest {

    @Test
    void getProductionRate() {
        int ProductionRate = 5;
        GraniesStub GS  = new GraniesStub("Test", 1, 4, 20);

        assertEquals(ProductionRate, GS.getProductionRate());

    }
}