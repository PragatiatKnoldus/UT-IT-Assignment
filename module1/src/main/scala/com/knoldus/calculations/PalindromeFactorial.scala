package com.knoldus.calculations

class PalindromeFactorial {

    def isPalindrome (number: Int): Boolean = {
      var temp = number
      var r = 0
      var sum = 0
      while (temp > 0) {
        r = temp % 10
        sum = (sum * 10) + r
        temp = temp / 10
      }
      if (sum == number)
        true
      else
        false
    }
    def factorialOf (number: Int): Int = {
      var res: Int = 1
      for (i <-2 to number){
        res *= i
      }
      res
    }
}
