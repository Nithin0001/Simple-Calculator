package com.example.calculator;
public class Arithmetic_Logic {
    public double calculation(double num1, double num2, int operation){
        switch(operation){
        case 1 :
            return num1 + num2;
        case 2 :
            return num1 - num2;
        case 3 :
            return num1 * num2;
        case 4 :
            if(num2 == 0)
                return 0;
            else
                return num1 / num2;
        default :
           return -1;
        }
   }
}
