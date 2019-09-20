package com.payment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PaymentServiceUnitTest
{
	private PaymentService instance;

	@Before
	public void setUp()
	{
		instance = new PaymentService();
	}

	@Test
	public void shouldReturnRandomPaymentResultByThousandTimes()
	{
		boolean result = false;
		int counterSuccess = 0;
		int counterFailure = 0;
		for (int i = 0; i < 1000; i++)
		{
			if (instance.getPaymentResult() == PaymentResult.SUCCESS)
			{
				++counterSuccess;
			}
			else if (instance.getPaymentResult() == PaymentResult.FAILURE)
			{
				++counterFailure;
			}

			if (counterFailure > 0 && counterSuccess > 0)
			{
				result = true;
				break;
			}
		}

		assertTrue(result);
	}
}
