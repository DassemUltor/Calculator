package ru.maxima;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class Calculator {

    //http://localhost:8080/calculate/start?digitOne=3&operation=plus&digitTwo=5
    @GetMapping("/start")
    public String solve(@RequestParam(value = "digitOne", required = false) Double digitOne,
                        @RequestParam(value = "operation", required = false) String operation,
                        @RequestParam(value = "digitTwo", required = false) Double digitTwo,
                        Model model) {

        Double result = switch (operation) {
            case "plus" -> digitOne + digitTwo;
            case "minus" -> digitOne - digitTwo;
            case "multiply" -> digitOne * digitTwo;
            case "division" -> digitOne / digitTwo;
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        };
        model.addAttribute("message", "The result of your expression is " + result);
        return "requestCalculator";
    }
}
