//prefix sum technique to find the maximum subarray sum
/*given array[]={1,-2,6,-1,3}
 * first we make a prefix array {1,-1,5,4,7}
 * now using the same subarray function we run a loop to find maxsum
 * using formula prefix[end]-prefix[start-1];(start !=0) 
 */

public class prefixsumsubarray {
    public static void prefixarray(int arr[]){
        int prefix[]=new int[arr.length];
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;  //-infinity

        prefix[0]=arr[0];
        for(int i=1;i<prefix.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }

        for(int i=0;i<prefix.length;i++){
            System.out.print(prefix[i]+" ");
        }
        for(int i=0;i<arr.length;i++){
            int start=i;
            for(int j=0;j<arr.length;j++){
                int end=j;
                for(int k=start;k<=end;k++){
                    currsum = start==0?prefix[end]:prefix[end]-prefix[start-1];

                    if(currsum>maxsum){
                        maxsum=currsum;
                    }
                }
            }
        }
        System.out.println("the maximum sum of a subarray is " +maxsum);


    }
    
    public static void main(String args[]){
        int arr[]={1,-2,6,-1,3};prefixarray(arr);
    }
    
}
