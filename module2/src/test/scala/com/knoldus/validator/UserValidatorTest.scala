package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Company, User}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class UserValidatorTest extends AnyFlatSpec {
  val pragatiUser: User = User("Pragati","Dubey",22,"Google","pragati.dubey@knoldus.in")
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto: CompanyReadDto = mock[CompanyReadDto]
  val mockedEmailvalidator: EmailValidator = mock[EmailValidator]

  val userValidator = new UserValidator(mockedCompanyReadDto,mockedEmailvalidator)

  "User" should "be valid" in {

    when(mockedCompanyReadDto.getCompanyByName(pragatiUser.companyName)) thenReturn Option(knoldusCompany)
    when(mockedEmailvalidator.emailIdIsValid(pragatiUser.emailId)) thenReturn true

    val result = userValidator.userIsValid(pragatiUser)
    assert(result)
  }

  "User" should "be invalid because his email is not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(pragatiUser.companyName)) thenReturn Option(knoldusCompany)
    when(mockedEmailvalidator.emailIdIsValid(pragatiUser.emailId)) thenReturn false

    val result = userValidator.userIsValid(pragatiUser)
    assert(!result)
  }

  "User" should "be invalid because his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(pragatiUser.companyName)) thenReturn None
    when(mockedEmailvalidator.emailIdIsValid(pragatiUser.emailId)) thenReturn true

    val result = userValidator.userIsValid(pragatiUser)
    assert(!result)
  }

  "User" should "be invalid because his email id is not valid and his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(pragatiUser.companyName)) thenReturn None
    when(mockedEmailvalidator.emailIdIsValid(pragatiUser.emailId)) thenReturn false

    val result = userValidator.userIsValid(pragatiUser)
    assert(!result)
  }



}
