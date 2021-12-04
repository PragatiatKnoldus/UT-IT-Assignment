package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {

  val companyName = new CompanyReadDto
  val validateEmail = new EmailValidator
  val userValidator = new UserValidator(companyName,validateEmail)

  val userImpl = new UserImpl(userValidator)

  "User" should "not be created as company does not exists in DB" in {
    val gauriUser: User = User("Gauri","Sharma",28,"Google","gauri.sharma@gmail.com")

    val result = userImpl.createUser(gauriUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as email id is not valid" in {
    val pallavUser: User = User("Pallav","Gupta",23,"Knoldus","pallav.gupta@knoldus")

    val result = userImpl.createUser(pallavUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as company does not exists in DB and email id is not valid" in {
    val gauravUser: User = User("Gaurav","Raj",22,"Microsoft","gaurav.raj@microsoft")

    val result = userImpl.createUser(gauravUser)
    assert(result.isEmpty)
  }

  "User" should "be created" in {
    val pragatiUser: User = User("Pragati","Dubey",22,"Knoldus","pragati.dubey@knoldus.com")

    val result = userImpl.createUser(pragatiUser)
    assert(!result.isEmpty)
  }

}