package learnException;

class TestException {
	public static void main(String [] args){
		int i=0;
		try {
			if(i==0)
				throw new MyException();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
}
