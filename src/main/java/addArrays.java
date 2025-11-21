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

            //Si un elemento dentro de cualquier lista es null, arroja IllegalArgumentException
            Integer lVal;
            Integer rVal;
            try {
                lVal = (i < left.size()) ? left.get(i) : 0;
                rVal = (i < right.size()) ? right.get(i) : 0;
            } catch (Exception e) {
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

        return result;
    }
}