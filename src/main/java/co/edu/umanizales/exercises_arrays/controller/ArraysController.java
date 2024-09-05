package co.edu.umanizales.exercises_arrays.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arrays")
public class ArraysController {
    @GetMapping("/{num1}/{num2}")
    public String getPrimesBetweenTwoNumbers(@PathVariable int num1,
                                             @PathVariable int num2){
        if(validateNumberPositive(num1) && validateNumberPositive(num2)){
            if(isPrime(num1)) {
                return "Número 1 es primo";
            }
            else {
                return "luego seguimos";
            }
        }
        else{
            return "Los números deben ser positivos";
        }
    }

    private boolean validateNumberPositive(int number){
        if(number >0) {
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isPrime(int number){
        int contDiv =0;
        int half = number / 2;
        for(int i=2; i<half; i++){
            if(number % i == 0){
                contDiv++;
            }
        }
        if(contDiv == 0){
            return true;
        }
        else{
            return false;
        }
    }

}
