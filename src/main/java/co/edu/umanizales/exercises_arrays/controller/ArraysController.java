package co.edu.umanizales.exercises_arrays.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/arrays")
public class ArraysController {

    @PostMapping("/sustentation")
    public String sustentation(@RequestBody int[] array){
        return verifyEqu(array);
    }

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

    private String verifyEqu(int[] array){
        int sum = sumArray(array);
        boolean band = false;
        String cadena = "";
        for(int i=0; i<array.length; i++){
            if(sum - array[i] == array[i]){
                cadena += "Pos:" + i + " Número:"+ array[i]+" \n";
                band = true;
            }
        }
        if(!band){
            return "No hay equivalencias";
        } else {
            return cadena;
        }

    }

    private int sumArray(int[] array){
        int sum = 0;
        for(int i=0; i<array.length; i++){
            sum += array[i];
        }
        return sum;
    }

}
