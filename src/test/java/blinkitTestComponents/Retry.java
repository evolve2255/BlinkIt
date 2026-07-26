package blinkitTestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	int reRunCount =0;
	int maxTry = 2;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(reRunCount<maxTry) {
			
			reRunCount++;
			return true;
		}
		
		return false;
	}

}
