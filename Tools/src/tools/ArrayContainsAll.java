package tools;

public class ArrayContainsAll{
	public static <T>boolean containsAll(T[] a,T[] b) {//a是否包含b
		int k=0;
		if(b.length>a.length)
			return false;
		else{
			for(int i = 0;i<b.length;i++){
				for(int j = 0;j<a.length;j++ ){
					if(b[i]==a[j]){
						k++; 
						continue;
					}
				}
			}
		}
		if(k==b.length)
			return true;
		return false;
	}
	
	public static void main(String[] arg){
		Integer[] a = {1,2,3,4,5,6};
		Integer[] b = {2,3,4};
		System.out.println(containsAll(a,b));
		b = new Integer[]{2,8};
		System.out.println(containsAll(a,b));
	}

}
