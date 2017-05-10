package evaca

class SecurityTagLibUnitTests extends grails.test.TagLibUnitTestCase {
	void testIsLoggedIn() {
		String testContent = "You are logged in!"
			mockSession["user"] = "me"
			tagLib.isLoggedIn([: ]) {
			->testContent
		}
		assertEquals testContent,
		tagLib.out.toString()
	}
	void testIsLoggedInNoUser() {
		String testContent = "You are not logged in!"
			tagLib.isLoggedIn([: ]) {
			->testContent
		}
		assertEquals "",
		tagLib.out.toString()
	}
}
