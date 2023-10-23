import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriorityQueueTest {

    PriorityQueue<Customer> queue;
    Customer customerA;
    Customer customerB;
    Customer customerC;
    Customer customerD;
    Customer customerF;
    Customer.WorthComparator worth;
    Customer.LoyaltyComparator loyal;
    Customer.WorthPoliteComparator polite;

    @BeforeEach
    void setUp() {
        worth = new Customer.WorthComparator();
        queue = new PriorityQueue<>(worth);
        // int netWorth, int yearsWithCompany, int politeness
        customerA = new Customer(10, 20, 1);
        customerB = new Customer(15, 25, 5);
        customerC = new Customer(20, 20, 10);
        customerD = new Customer(25, 20, 1);
        customerF = new Customer(10, 120, 4);

        loyal = new Customer.LoyaltyComparator();
        polite = new Customer.WorthPoliteComparator();
    }

    @Test
    void testComparator() {
        assertTrue(-1 >= worth.compare(customerA, customerB));
        assertTrue(1 <= worth.compare(customerB, customerA));
        assertTrue(0 == worth.compare(customerA, customerF));

        assertTrue(1 <= polite.compare(customerC, customerB));
        assertTrue(0 == polite.compare(customerB, customerB));
        assertTrue(-1 >= polite.compare(customerA, customerF));
        assertTrue(-1 >= polite.compare(customerB, customerC));

        assertTrue(1 <= loyal.compare(customerB, customerC));
        assertTrue(0 == loyal.compare(customerA, customerC));
        assertTrue(-1 >= loyal.compare(customerC, customerB));
    }

    @Test
	void testQueue() throws QueueUnderFlowException {
	    
		assertTrue(queue.isEmpty());
		queue.push(customerB);
		queue.push(customerC);
		
		assertFalse(queue.isEmpty());
		queue.push(customerA); 
		
		assertFalse(queue.isEmpty());
		queue.push(customerD);
		assertEquals(customerD, queue.pop());
		assertEquals(customerC, queue.pop());
		assertEquals(customerB, queue.pop());
		assertEquals(customerA, queue.pop());
		assertThrows(QueueUnderFlowException.class, () ->{queue.pop();});
		assertTrue(queue.isEmpty());
		
	}
}
