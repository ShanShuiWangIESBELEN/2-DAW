import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class PilaJunitTest {
    static Pila<Integer> pila;

    @BeforeEach
    void setUp() {
        pila = new pila<>();

    }

    @Test
    @DisplayName("Test 1:")
    void testAnadir() {
        pilaArray.anadir(4);
    }

    @Test
    @DisplayName("Test 2:")
    void testExtraer() {
        pilaArray.extraer();
    }
    @Test
    @DisplayName("Test 3:")
    void testPrimero(){
        pilaArray.primero();
    }
}