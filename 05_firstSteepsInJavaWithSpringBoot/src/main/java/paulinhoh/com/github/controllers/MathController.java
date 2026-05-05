package paulinhoh.com.github.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import paulinhoh.com.github.exception.UnsupportedMathOperationException;
import paulinhoh.com.github.math.SimpleMath;
import paulinhoh.com.github.request.converters.NumberConverter;

@RestController
@RequestMapping("/math")
public class MathController {

    private SimpleMath math = new SimpleMath();

    // http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("please set a numeric value!");
        return math.sum(NumberConverter.convetToDouble(numberOne), NumberConverter.convetToDouble(numberTwo));
    }


    // http://localhost:8080/math/sub/3/5
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("please set a numeric value!");
        return math.sub(NumberConverter.convetToDouble(numberOne), NumberConverter.convetToDouble(numberTwo));
    }


    // http://localhost:8080/math/div/3/5
    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("please set a numeric value!");
        return math.div(NumberConverter.convetToDouble(numberOne), NumberConverter.convetToDouble(numberTwo));
    }


    // http://localhost:8080/math/mult/3/5
    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("please set a numeric value!");
        return math.mult(NumberConverter.convetToDouble(numberOne), NumberConverter.convetToDouble(numberTwo));
    }


    // http://localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("please set a numeric value!");
        return math.mean(NumberConverter.convetToDouble(numberOne), NumberConverter.convetToDouble(numberTwo));
    }


    // http://localhost:8080/math/squareroot/9
    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        if (!NumberConverter.isNumeric(number))
            throw new UnsupportedMathOperationException("please set a numeric value!");
        return math.squareRoot(NumberConverter.convetToDouble(number));
    }
}
