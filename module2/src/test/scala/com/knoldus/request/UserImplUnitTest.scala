package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplUnitTest extends AnyFlatSpec {

  val mockedUserValidator = mock[UserValidator]
  val pragatiUser: User = User("Pragati","Dubey",22,"knoldus","pragati.dubey@knoldus.com")

  "User" should "be created" in {
    val userImpl = new UserImpl(mockedUserValidator)

    when(mockedUserValidator.userIsValid(pragatiUser)) thenReturn(true)
    val result = userImpl.createUser(pragatiUser)
    assert(!result.isEmpty)
  }

  "User" should "not be created" in {
    val userImpl = new UserImpl(mockedUserValidator)

    when(mockedUserValidator.userIsValid(pragatiUser)) thenReturn(false)
    val result = userImpl.createUser(pragatiUser)
    assert(result.isEmpty)
  }

}