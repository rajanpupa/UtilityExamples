package forExample;

public class Example {
	
	int find (int a, int[] arr){
		if(arr==null || arr.length==0)return -1;
		if(arr.length==1 && arr[0]!=a) return -1;
		
		int start = 0, end = arr.length-1;
		int mid;
		while(start<=end){
			
			if(end-start<2){
				if(arr[start]==a)return start;
				if(arr[end]==a) return end;
				else return -1;
			}
			
			mid=start + (end-start)/2;
			
			
			
			//System.out.printf("start=%d, end=%d, mid=%d \n", start, end, mid);
			
			if(arr[mid]==a)return mid;

			if(arr[start]<arr[mid]){
				if(a>arr[mid]) start = mid+1;
				else end = mid-1;
			}else{
				if(a<arr[mid]){
					end=mid-1;
				}else if(a>arr[mid] && a>=arr[start]){
					end=mid-1;
				}else{
					start = mid+1;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int a = 5;
		int[] arr = {15,16,19,20,25,1,3,4,5,7,10,14};
		
		Example e = new Example();
		
		//int i=9;
		for(int i=0; i<arr.length; i++)
			System.out.printf("index of %d is: %d \n",arr[i], e.find(arr[i], arr));
	}
}
