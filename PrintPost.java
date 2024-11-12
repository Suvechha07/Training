// Java program to print Postorder traversal from given Inorder
// and Preorder traversals.
import java.util.*;
public class PrintPost 
{
	static int preIndex = 0;
	void printPost(int[] in, int[] pre, int inStrt, int inEnd)
	{
		if (inStrt > inEnd) 
			return;	 
		int inIndex = search(in, inStrt, inEnd, pre[preIndex++]);
		printPost(in, pre, inStrt, inIndex - 1);
		printPost(in, pre, inIndex + 1, inEnd);
		System.out.print(in[inIndex] + " ");
	}

	int search(int[] in, int startIn, int endIn, int data)
	{
		int i = 0;
		for (i = startIn; i < endIn; i++) 
			if (in[i] == data) 
				return i;		 
		return i;
	}

	// Driver code
	public static void main(String ars[])
	 {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter size of inorder and preorder : ");
		int n=sc.nextInt();
		int in[]=new int[n];
		int pre[]=new int[n];
		System.out.println("Enter inorder elements : ");
		for (int i=0;i<n;i++)
		{
		    in[i]=sc.nextInt();
		  
		}
		System.out.println("Enter preorder elements : ");
		for (int i=0;i<n;i++)
		{
		    pre[i]=sc.nextInt();
		  
	 	}
                System.out.println("The order of postorder elements : ");
		int len = in.length;
		PrintPost tree = new PrintPost();
		tree.printPost(in, pre, 0, len - 1);
	}
}
