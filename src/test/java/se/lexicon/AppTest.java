package se.lexicon;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        Person person1 = new Person(1, "Casper", "Nilsson", "caspernilsson13@gmail.com");
        String expectedOutput = "id: 1, name: Casper Nilsson, email: caspernilsson13@gmail.com";
        assert person1.toString().equals(expectedOutput) : "Output";


        AppUser user1 = new AppUser("CasNil", "test123", AppRole.ROLE_APP_ADMIN);
        AppUser user2 = new AppUser("CasNil", "test123", AppRole.ROLE_APP_ADMIN);
        assertTrue(user1.equals(user2));
        assertEquals(user1.hashCode(),user2.hashCode());

    }

}
