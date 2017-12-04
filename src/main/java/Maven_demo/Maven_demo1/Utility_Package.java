package Maven_demo.Maven_demo1;

import java.util.Random;

public class Utility_Package {

	public int randomNum()
	{

		Random rand = new Random();
		int n=rand.nextInt(54)+1;
		return n;
	}

}
