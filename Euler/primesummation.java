public class primesummation
{

	public static void main(String[] args)
	{
		long max = 2000000L;
		long result = 0;
		for(long i=2; i<max; i++)
		{
			if(isPrime(i))
			{
				result += i;
			}
		}

		System.out.print(result);
	}

	public static boolean isPrime(long num)
	{
		for(long i=2; i<=Math.floor(Math.sqrt(num)); i++)
		{
			if((num%2==0) || (num%i==0))
			{
				return false;
			}
		}

		return true;
	}
}

