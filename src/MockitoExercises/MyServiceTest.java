package MockitoExercises;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyServiceTest {
    @Test
    public void testMockingAndStubbing() {
        // 1. Create a mock object for the external dependency
        ExternalAPI mockApi = mock(ExternalAPI.class);

        // 2. Stub the method to return a predefined value when called
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Provide the mock object to the service and execute
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert the returned data matches the stub value
        assertEquals("Mock Data", result);
    }

    // --- Exercise 2 & 3: Verifying Interactions & Argument Matching ---
    @Test
    public void testVerifyingAndMatching() {
        ExternalAPI mockApi = mock(ExternalAPI.class);
        MyService service = new MyService(mockApi);

        // Execute a method that triggers an external API call
        service.process("Valid Payload");

        // Exercise 2: Verify that the API method was explicitly invoked
        verify(mockApi).processData("Valid Payload");

        // Exercise 3: Use argument matchers (anyString()) to verify it was called with any text input
        verify(mockApi).processData(anyString());
    }

    // --- Exercise 4 & 7: Handling Void Methods & Exceptions ---
    @Test
    public void testVoidMethodsAndExceptions() {
        ExternalAPI mockApi = mock(ExternalAPI.class);

        // Exercise 7: Stub a void method to throw an exception when a bad input is encountered
        doThrow(new IllegalArgumentException("Invalid Input")).when(mockApi).processData("Bad Input");

        MyService service = new MyService(mockApi);

        // Verify the void method accurately throws the structured error context
        assertThrows(IllegalArgumentException.class, () -> {
            service.process("Bad Input");
        });

        // Exercise 4: Verify the void method interaction took place
        verify(mockApi).processData("Bad Input");
    }

    // --- Exercise 5: Mocking and Stubbing with Multiple Returns ---
    @Test
    public void testMultipleReturns() {
        ExternalAPI mockApi = mock(ExternalAPI.class);

        // Stub consecutive calls to yield different responses sequentially
        when(mockApi.getData())
                .thenReturn("First Call Data")
                .thenReturn("Second Call Data");

        MyService service = new MyService(mockApi);

        // Verify the mock updates its return value across sequential calls
        assertEquals("First Call Data", service.fetchData());
        assertEquals("Second Call Data", service.fetchData());
    }

    // --- Exercise 6: Verifying Interaction Order ---
    @Test
    public void testInteractionOrder() {
        ExternalAPI mockApi = mock(ExternalAPI.class);
        MyService service = new MyService(mockApi);

        // Triggers multiple distinct external calls
        service.runWorkflow();

        // Set up an InOrder verification wrapper for the mock object
        InOrder inOrder = inOrder(mockApi);

        // Assert that Step 1 strictly finished before Step 2 executed
        inOrder.verify(mockApi).executeAction("Step 1");
        inOrder.verify(mockApi).executeAction("Step 2");
    }
}
