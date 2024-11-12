import java.util.Scanner;
class addmatrixelements 
{
    static int[] Sum(int[] nums, int target,int n) 
    {
        int ans[]=new int[2];
        for(int i=0;i<n;i++)
        {
          for(int j=0;j<n;j++)
          {
            if(nums[i]+nums[j]==target)
            {
                ans[0]=i;
                ans[1]=j;
            }
          }
        }
        return ans;
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the no of elements in the array : ");
        int n=in.nextInt();
        int nums[]=new int[n];
         System.out.println("Enter the elements in the array : ");
         for (int i=0;i<n;i++)
         {
            nums[i]=in.nextInt();
         }
          System.out.println("Enter the target : ");
          int target=in.nextInt();
          addmatrixelements obj=new addmatrixelements();
          Sum(nums,target,n);
          int ans[]=addmatrixelements.Sum(nums,target,n);
          System.out.println("Output :");
          System.out.println(ans[0]);
          System.out.println(ans[1]);
    }
} 
    

