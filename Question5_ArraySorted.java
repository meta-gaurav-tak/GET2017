public class Question5_ArraySorted {
	public int sortOrder(int[] input){
		int i=1;
		int flag=0;
		if(input[i-1]<=input[i]){
			flag=1;
			for(i=2;i<input.length;i++){
				if(input[i-1]>input[i]){
					flag=0;
					break;
				}
			}
		}
		else{
			flag=2;
			for(i=2;i<input.length;i++){
				if(input[i-1]<input[i]){
					flag=0;
					break;
				}
			}

		}
		return flag;
	}
}
