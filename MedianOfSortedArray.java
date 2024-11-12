import java.util.*;
public class MedianOfSortedArray 
{
    public static void main(String[] args) 
    {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the size of array 1 : ");
        int n1=in.nextInt();
        int nums1[]=new int[n1];
        for(int i=0;i<n1;i++)
        {
            System.out.println("Enter array elements : ");
            nums1[i]=in.nextInt();
        }
        
        System.out.println("Enter the size of array 2 : ");
        int n2=in.nextInt();
        int nums2[]=new int[n2];
        for(int i=0;i<n2;i++)
        {
            System.out.println("Enter array elements : ");
            nums2[i]=in.nextInt();
        }
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        if (nums1.length > nums2.length) 
        {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length, n = nums2.length;
        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        double median = 0.0;

        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;

            if (i < m && nums2[j - 1] > nums1[i]) 
            {
                imin = i + 1;
            } 
            else if (i > 0 && nums1[i - 1] > nums2[j])
            {
                imax = i - 1;
            } 
            else 
            {
                int maxOfLeft = 0;
                if (i == 0) 
                {
                    maxOfLeft = nums2[j - 1];  
                }
                else if (j == 0) 
                {
                    maxOfLeft = nums1[i - 1];
                }
                else 
                {
                    maxOfLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                if ((m + n) % 2 == 1)
                {
                    return maxOfLeft;
                }

                int minOfRight = 0;
                if (i == m)
                {
                    minOfRight = nums2[j];
                }
                else if (j == n) 
                {
                    minOfRight = nums1[i];
                }
                else 
                {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }
        return median;
    }
}