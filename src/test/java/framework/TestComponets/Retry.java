package framework.TestComponets;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	int count=0;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(count<1)
			{
			count++;
			return true;
			}
		return false;
	}

}
