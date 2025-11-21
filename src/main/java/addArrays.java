import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class addArrays {

    public List<Integer> add(List<Integer> left, List<Integer> right) {

        if (left == null || right == null)
            return null;

        Collections.reverse(left);
        Collections.reverse(right);

        LinkedList<Integer> result = new LinkedList<>();
        int carry = 0;

        for (int i = 0; i < Math.max(left.size(), right.size()); i++) {

            // 1. CORRECCIÓN: Validación segura de nulos
            // Obtenemos el objeto Integer (que puede ser null)
            Integer lVal = (i < left.size()) ? left.get(i) : 0;
            Integer rVal = (i < right.size()) ? right.get(i) : 0;

            // Verificamos explícitamente si es null ANTES de intentar usarlo
            if (lVal == null || rVal == null) {
                throw new IllegalArgumentException("La lista no puede contener elementos nulos");
            }

            int leftDigit = lVal;
            int rightDigit = rVal;

            if (leftDigit < 0 || leftDigit > 9 || rightDigit < 0 || rightDigit > 9)
                throw new IllegalArgumentException();

            int sum = leftDigit + rightDigit + carry;

            result.addFirst(sum % 10);
            carry = sum / 10;
        }

        // 2. CORRECCIÓN: Agregar el acarreo restante
        // Si al terminar el bucle todavía "llevamos 1", hay que agregarlo al principio
        if (carry > 0) {
            result.addFirst(carry);
        }

        // 3. CORRECCIÓN: Eliminar ceros a la izquierda
        // Mientras la lista tenga más de 1 número y el primero sea 0, lo quitamos.
        // Ejemplo: convierte [0, 0, 5] en [5].
        while (result.size() > 1 && result.get(0) == 0) {
            result.remove(0);
        }

        return result;
    }
}