package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class PasswordValidatorTest extends AnyFlatSpec {

  "A password" should "be invalid as it contains a blank space" in {
    val pass = new PasswordValidator()
    assert(!pass.passwordisvalid("Dubey Pr@29"))
  }

  "A password" should "be invalid as it does not contain a digit" in {
    val pass = new PasswordValidator()
    assert(!pass.passwordisvalid("Dubey@Pr"))
  }

  "A password" should "be invalid as it contains less than 8 characters" in {
    val pass = new PasswordValidator()
    assert(!pass.passwordisvalid("Dub@P2"))
  }

  "A password" should "be invalid as contains more than 15 characters" in {
    val pass = new PasswordValidator()
    assert(!pass.passwordisvalid("Dubey@Pragati29zxbnm"))
  }

  "A password" should "be invalid as it does not contain any lower case character" in {
    val pass = new PasswordValidator()
    assert(!pass.passwordisvalid("DUBEY@PR29"))
  }

  "A password" should "be invalid as it does not contain any upper case character" in {
    val pass = new PasswordValidator()
    assert(!pass.passwordisvalid("dubey@pr29"))
  }

  "A password" should "be invalid as it does not contain any special character" in {
    val pass = new PasswordValidator()
    assert(!pass.passwordisvalid("dubeyPr29"))
  }

  "A password" should "be valid as it has all necessary features" in {
    val pass = new PasswordValidator()
    assert(pass.passwordisvalid("Dubeypr@29"))
  }

}
