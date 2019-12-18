package collections

import org.scalatest.FlatSpec
import FoldDemo._

class FoldDemoTest extends FlatSpec {
  "lengthOfAList" should "return 0 for an empty list" in {
    assert(lengthOfAList(Nil) == 0)
  }

  it should "return the number of elements of a list with numbers in it " in {
    assert(lengthOfAList(List(1, 3, 5, 7, 9)) == 5)
  }

  val marketingByEmailTrue = Consent("email", true, false)
  val marketingByEmailFalse = Consent("email", false, false)
  val marketingByPostFalse = Consent("post", false, false)
  val marketingAnalysisTrue = Consent("analysis", true, false)
  val marketingAnalysisFalse = Consent("analysis", false, false)
  val dailyBriefingTrue = Consent("email-daily-briefing", true, true)
  val dailyBriefingFalse = Consent("email-daily-briefing", false, true)

  val marketingConsentsOnly = List(marketingByEmailTrue, marketingByPostFalse, marketingAnalysisFalse)
  val user = User(
    id = "123",
    name = Some("Gladys West"),
    consents = Nil
  )

  "emailNewsletterConsentCount" should "return 0 if consents is an empty list" in {
    assert(emailNewsletterConsentCount(user) == 0)
  }

  it should "still return 0 if the user has consents, but none about email newsletters" in {
    val userWithMarketingConsentsOnly = user.copy(consents = marketingConsentsOnly)

    assert(emailNewsletterConsentCount(userWithMarketingConsentsOnly) == 0)
  }

  it should "return 1 if the user has marketing consents and one consent about an email newsletter" in {
    val userWithMarketingConsentsOnly = user.copy(consents = dailyBriefingTrue :: marketingConsentsOnly)

    assert(emailNewsletterConsentCount(userWithMarketingConsentsOnly) == 1)
  }

  it should "still count consents for email newsletters that are opt-outs" in {
    val userWithMarketingConsentsOnly = user.copy(consents = dailyBriefingFalse :: marketingConsentsOnly)

    assert(emailNewsletterConsentCount(userWithMarketingConsentsOnly) == 1)
  }

}
