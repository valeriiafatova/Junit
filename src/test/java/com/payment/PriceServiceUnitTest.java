package com.payment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceServiceUnitTest
{
	private PriceService instance;

	@Before
	public void setUp()
	{
		instance = new PriceService();
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnExceptionWhenPriceIsLowerThanZero()
	{
		instance.validatePrice(-1);
	}

}
