public class Question1_BinToOct{
	public int convertBinaryToOctal(int n){
		int triad=0;
		String octalValue="";
		while(n>0) {
			triad=n%1000;
			octalValue=getOctalEquivalent(triad)+octalValue;
			n=n/1000;
		}
		return Integer.parseInt(octalValue);	
	}
	private int getOctalEquivalent(int bin) {
		int oct=0;
		int no=011;
		System.out.println(no);
		switch(bin){
			case 0:oct=0;
				break;
			case 1:oct=1;
				break;
			case 10:oct=2;
				break;
			case 11:oct=3;
				break;
			case 100:oct=4;
				break;
			case 101:oct=5;
				break;
			case 110:oct=6;
				break;
			case 111:oct=7;
				break;
			}
		return oct;
	}
}
