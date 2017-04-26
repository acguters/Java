public class primefactor
{
	public static void main(String[] args)
	{
		long number = 600851475143L;
		long result = 0;
		long temp = 0;
		long factor = 2;

		while(number!=1)
		{
			//System.out.println(number);
			if(number%factor==0)
			{
				while(number%factor==0)
				{
					number = number/factor;
				}
				if(factor>result)
				{
					result = factor;
				}
			}
			factor++;
		}

		System.out.println(result);
	}


}