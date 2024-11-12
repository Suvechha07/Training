
class frequency 
{ 

static int frequencyDigits(int n,int d) 
{ 
	int c = 0; 
	while (n > 0) 
	{ 
		if (n % 10 == d) 
			c++; 
		n = n / 10; 
	} 
	return c; 
} 

public static void main(String args[]) 
{ 
	int N = 1122322; 
	int D = 2; 
	
	System.out.println(frequencyDigits(N, D)); 
} 
} 

