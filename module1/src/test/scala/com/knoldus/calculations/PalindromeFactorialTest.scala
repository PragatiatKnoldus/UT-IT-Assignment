package com.knoldus.calculations

import org.scalatest.flatspec.AnyFlatSpec

class PalindromeFactorialTest extends AnyFlatSpec {

  "A number" should "be palindrome" in {
    val obj = new PalindromeFactorial
    assert(obj.isPalindrome(121))
  }
  "A number" should "not be palindrome" in {
    val obj = new PalindromeFactorial()
    assert(!obj.isPalindrome(12))
  }
  "A number" should "be palindrome as 0 is palindrome" in {
    val obj = new PalindromeFactorial()
    assert(obj.isPalindrome(0))
  }
  "A number" should "not be palindrome as it is negative" in {
    val obj = new PalindromeFactorial()
    assert(!obj.isPalindrome(-121))
  }
  "A condition" should "be valid as 5 will return 120" in {
  val obj = new PalindromeFactorial()
  assert(120==obj.factorialOf(5))
}
"A condition" should "be valid as 0 will return 1" in {
  val obj = new PalindromeFactorial()
  assert(1==obj.factorialOf(0))
}
  "A condition" should "be invalid as 7 will return 720" in {
  val obj = new PalindromeFactorial()
  assert(!(720==obj.factorialOf(7)))
}

}
