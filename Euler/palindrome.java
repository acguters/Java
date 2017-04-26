public class palindrome
{
	public static void main(String[] args)
	{
		int max = 999;
		int result = 0;

		for(int i=100; i<=max; i++)
			{
				for(int j=i;j<=max;j++)
				{
					int temp = i*j;
					int fin = temp;
					int length = (int)(Math.log10(temp)+1);
					int [] arr = new int[length];
					for(int k=0; k<length;k++)
					{
						arr[k] = temp%10;
						temp = temp/10;
					}
					if(arr[0]==arr[length-1])
					{
						if(arr[1]==arr[length-2])
						{
							if(arr[2]==arr[length-3])
							{
								if(fin>result)
								{
									result = fin;
								}
								
							}
						}
					}
				}
			}

		System.out.println(result);
	}
}