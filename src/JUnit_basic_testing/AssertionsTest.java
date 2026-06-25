package JUnit_basic_testing;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
public class AssertionsTest {

        private Calculator calculator;

        // Exercise 4: Setup method runs automatically BEFORE every test case
        @Before
        public void setUp() {
            calculator = new Calculator();
            System.out.println("Setup completed: JUnit_basic_testing.Calculator initialized.");
        }

        // Exercise 3 & 4: Test case using the AAA pattern and various assertions
        @Test
        public void testAssertions() {
            // 1. Arrange (Setting up data and expectations)
            int expectedResult = 5;
            Object testObject = new Object();

            // 2. Act (Executing the actual method being tested)
            int actualResult = calculator.add(2, 3);

            // 3. Assert (Validating the results using different assertions)
            assertEquals(expectedResult, actualResult); // Assert equals
            assertTrue(5 > 3);                          // Assert true
            assertFalse(5 < 3);                         // Assert false
            assertNull(null);                           // Assert null
            assertNotNull(testObject);                  // Assert not null
        }

        // Exercise 4: Teardown method runs automatically AFTER every test case
        @After
        public void tearDown() {
            calculator = null;
            System.out.println("Teardown completed: Resources cleaned up.");
        }
    }