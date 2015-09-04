package com.fdmgroup.assignment.Calculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	private String expression;

	@Before
	public void setUp() throws Exception {	
	}

	@Test
	public void testReturnOneValue(){		
		expression = "4";
		assertEquals(4.0, Calculator.evaluateExp(expression), 0.0);		
	}

	@Test
	public void testReturnOneMinusValueHasASpaceBeforValue(){		
		expression = "- 4";
		assertEquals(-4.0, Calculator.evaluateExp(expression), 0.0);		
	}
	
	@Test
	public void testReturnOneMinusValue(){		
		expression = "-4";
		assertEquals(-4.0, Calculator.evaluateExp(expression), 0.0);		
	}
	
	@Test
	public void testReturnTheSumOfTwoValues(){		
		expression = "4 + 4";
		assertEquals(8.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testtestReturnTheSumOfThreeValues(){		
		expression = "4 + 2 + 4";
		assertEquals(10.0, Calculator.evaluateExp(expression), 0.0);		
	}			
	
	@Test
	public void testReturnTheSumOfFourValues(){		
		expression = "4 + 2 + 4 + 5";
		assertEquals(15.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testReturnTheSumOfMultipleValues(){		
		expression = "4 + 2 + 4 + 5 + 10 + 20 + 30";
		assertEquals(75.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testReturnOneValueMinusAnotherOne(){		
		expression = "6 - 2";
		assertEquals(4.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testReturnOneValueMinusAnotherTwo(){		
		expression = "16 - 2 - 4";
		assertEquals(10.0, Calculator.evaluateExp(expression), 0.0);		
	}	

	@Test
	public void testReturnOneValueMinusAnotherThree(){		
		expression = "16 - 2 - 4 - 4";
		assertEquals(6.0, Calculator.evaluateExp(expression), 0.0);		
	}		
	
	@Test
	public void testReturnOneValueMinusMultipleValues(){		
		expression = "16 - 2 - 4 - 4 - 4 - 2";
		assertEquals(0.0, Calculator.evaluateExp(expression), 0.0);		
	}		
	
	@Test
	public void testReturnMinusValueMBySubtractOneValue(){		
		expression = "2 - 4";
		assertEquals(-2.0, Calculator.evaluateExp(expression), 0.0);		
	}		
	
	@Test
	public void testReturnMinusValueMBySubtractTwoValues(){		
		expression = "2 - 4 - 4";
		assertEquals(-6.0, Calculator.evaluateExp(expression), 0.0);		
	}		
	
	@Test
	public void testReturnMinusValueMBySubtractThreeValues(){		
		expression = "2 - 4 - 4 - 4";
		assertEquals(-10.0, Calculator.evaluateExp(expression), 0.0);		
	}
	
	@Test
	public void testReturnMinusValueMBySubtractMultipleValues(){		
		expression = "2 - 4 - 4 - 4 - 10 - 20 - 30";
		assertEquals(-70.0, Calculator.evaluateExp(expression), 0.0);		
	}
	
	@Test
	public void testtwomultiple(){		
		expression = "2 * 4";
		assertEquals(8.0, Calculator.evaluateExp(expression), 0.0);		
	}
	
	@Test
	public void testthreemultiple(){		
		expression = "2 * 4 * 2";
		assertEquals(16.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testthreemiunsmultiple(){		
		expression = "-2 * -4 * -2";
		assertEquals(-16.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	public void testthreemiunsmultiple2(){		
		expression = "- 2 * - 4 * - 2";
		assertEquals(-16.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testtwodivision(){		
		expression = "4 / 2";
		assertEquals(2.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testthreedivision(){		
		expression = "4 / 2 / 2";
		assertEquals(1.0, Calculator.evaluateExp(expression), 0.0);		
	}	
		
	@Test
	public void testfourdivision(){		
		expression = "4 / 2 / 2 / 2";
		assertEquals(0.5, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testmultipledivision(){		
		expression = "256 / 2 / 2 / 2 / 2 / 2 / 2";
		assertEquals(4.0, Calculator.evaluateExp(expression), 0.0);		
	}		
	
	@Test
	public void testtwominusdivision2(){		
		expression = "4 / -2";
		assertEquals(-2.0, Calculator.evaluateExp(expression), 0.0);		
	}
	
	@Test
	public void testthreeminusdivision2(){		
		expression = "4 / -2 / -2";
		assertEquals(1.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testfourminusdivision2(){		
		expression = "4 / -2 / -2 / -1";
		assertEquals(-1.0, Calculator.evaluateExp(expression), 0.0);		
	}		
	
	@Test
	public void testtwopower(){		
		expression = "4 ^ 2";
		assertEquals(16.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testtwominuspower(){		
		expression = "- 4 ^ -2";
		assertEquals(-0.07, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testminuspower(){		
		expression = "-4 ^ 2";
		assertEquals(16, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test
	public void testthreepower(){		
		expression = "4 ^ 2 ^ 2";
		assertEquals(256.0, Calculator.evaluateExp(expression), 0.0);		
	}		
	
	@Test
	public void testoneparentheses(){		
		expression = "- ( 4 + 2 ) - 2";
		assertEquals(-8.0, Calculator.evaluateExp(expression), 0.0);		
	}
	
	public void testtwoparentheses(){		
		expression = "- ( 4 + 2 ) - ( 2 + 1 )";
		assertEquals(-9.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	public void testtwoparentheses2(){		
		expression = "- ( 4 + 2 ) / ( 2 + 1 )";
		assertEquals(-2.0, Calculator.evaluateExp(expression), 0.0);		
	}
	
	public void testtwoparentheses3(){		
		expression = "- ( 4 + 1 ) ^ ( 1 + 1 )";
		assertEquals(-25.0, Calculator.evaluateExp(expression), 0.0);		
	}
	
	public void testtwoparentheses4(){		
		expression = "- ( 4 + 1 ) ^ ( 1 + 1 )";
		assertEquals(-25.0, Calculator.evaluateExp(expression), 0.0);		
	}

	@Test	
	public void testcombination(){		
		expression = "3 ^ 4 + 5 * 6 + ( 7 - 8 ) / 9";
		assertEquals(110.88, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test	
	public void testtestcombination1(){		
		expression = "6 * 8 / 7 + 6 - 9 + 5 / 4 * 3 - 8 + 6";
		assertEquals(5.6, Calculator.evaluateExp(expression), 0.0);		
	}		
	
	@Test	
	public void testtestcombination2(){		
		expression = "- ( 2 * 10 / 4 + 1 ) ^ 2 + 10 + 5 * 3 - 8 + 6";
		assertEquals(-13.0, Calculator.evaluateExp(expression), 0.0);		
	}		
		
	@Test	
	public void testtestcombination3(){		
		expression = "( - ( 2 * 10 / 4 + 1 ) ^ 2 ) ^ 2 + 10 + 5 * 3 - 8 + 6";
		assertEquals(1319.0, Calculator.evaluateExp(expression), 0.0);		
	}	
	
	@Test	
	public void testtestcombination4(){		
		expression = "- ( ( 16.345 / 2.743 ) / ( 4.567 * 3.905 - 10.53 ) ^ 1.5 ) ^ ( -2.1 ) * 3.7 - 60.433 / 30.97 + 100";
		assertEquals(52.27, Calculator.evaluateExp(expression), 0.0);		
	}	
}
