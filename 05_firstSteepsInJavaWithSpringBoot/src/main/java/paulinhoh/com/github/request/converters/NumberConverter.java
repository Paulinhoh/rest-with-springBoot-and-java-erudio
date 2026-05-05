package paulinhoh.com.github.request.converters;

import paulinhoh.com.github.exception.UnsupportedMathOperationException;

public class NumberConverter {

    public static Double convetToDouble(String strNumber) throws IllegalArgumentException {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");    // 5,00 -> 5.00
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }
}
