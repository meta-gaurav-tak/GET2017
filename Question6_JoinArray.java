public class Question6_JoinArray {
	public int[] join(int a[],int asize,int b[],int bsize,int c[]){
		c=new int[asize+bsize];
		int apointer,bpointer,cpointer;
		for(apointer=bpointer=cpointer=0;apointer<asize && bpointer<bsize && cpointer<c.length;){
			if(a[apointer]<=b[bpointer]){
				c[cpointer]=a[apointer];
				apointer++;
				cpointer++;
			}
				else{
					c[cpointer]=b[bpointer];
					bpointer++;
					cpointer++;
				}
				
			}
		if(apointer==asize){
			for(;bpointer<bsize;bpointer++){
				c[cpointer]=b[bpointer];
				cpointer++;
			}
		}
		else{
				for(;apointer<asize;apointer++){
					c[cpointer]=a[apointer];
					cpointer++;
			}
		}
		System.out.println(cpointer);
		return c;
	}
}
