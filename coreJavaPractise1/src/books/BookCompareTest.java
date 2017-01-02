package books;

public class BookCompareTest {
	public static void  main(String [] args){
		Book b1 = new Book("java", new Author("王龙","2312@qq.com",'男'),30 );
		Book b2 = new Book("android", new Author("张三","4312@qq.com",'男'),26,9);
		Book b3 = new Book("java", new Author("小明","2312@qq.com",'男'),30 );
		System.out.println(b1+"\n"+b2+"\n"+b3);
		b1.compareBook(b2);
		b1.compareBook(b3);
		System.out.println("--------------------------------");
		
		
	}
}
