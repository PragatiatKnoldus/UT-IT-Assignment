package com.knoldus.validator

class PasswordValidator {
  def passwordisvalid(pass1: String): Boolean = {
    val regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.\\S)(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$"
    if (pass1.matches(regex) && !pass1.contains(" "))
      true
    else
      false
  }
}