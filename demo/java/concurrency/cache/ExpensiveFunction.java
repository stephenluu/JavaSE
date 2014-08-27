package concurrency.cache;

import java.math.BigInteger;

public class ExpensiveFunction implements Computable<String,BigInteger>{


	@Override
	public BigInteger compute(String arg) {
		//长时间计算
		return new BigInteger(arg);
	}
	
}
