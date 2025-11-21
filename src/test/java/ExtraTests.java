import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ExtraTests {
    @Test
    public void testCuandoLeftListContieneElementoNegativo_DeberiaArrojarException() {
        List<Integer> left = Arrays.asList(1, -5, 3); 
        List<Integer> right = Arrays.asList(1, 2, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            new addArrays().add(left, right);
        }, "El método debería lanzar IllegalArgumentException si hay dígitos negativos");
    }

    @Test
    public void testElementosNulosInternos() {
        List<Integer> left = Arrays.asList(1, null, 5);
        List<Integer> right = Arrays.asList(2, 3);

        assertThrows(IllegalArgumentException.class, () -> {
            new addArrays().add(left, right);
        }, "Se esperaba una excepción controlada, no un NullPointerException del sistema");
    }
}
