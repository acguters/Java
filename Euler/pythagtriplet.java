public class pythagtriplet
{
	public static void main(String[] args)
	{
		final long startTime = System.currentTimeMillis();
		int result = 0;
		int max = 500;
		int temp = 0;

		for(int a=1; a<max;a++)
		{
			for(int b=a; b<max;b++)
			{
				for(int c=b;c<max;c++)
				{
					if(((a*a)+(b*b))==(c*c))
					{
						if((a+b+c)==1000)
						{
							temp = a*b*c;
							if(temp>result)
							{
								result = temp;
								//System.out.println(a+","+b+","+c);
							
}						}
					}
				}
			}
		}
		final long endTime = System.currentTimeMillis();
		System.out.println(result);
		System.out.println((endTime-startTime));
	}
}