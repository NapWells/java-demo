package books;

import java.util.HashSet;
import java.util.Set;

public class BookSetTest {
	public static void main(String [] args){
		Book b1 = new Book("java", new Author("王龙","2312@qq.com",'男'),30 );
		Book b2 = new Book("android", new Author("张三","4312@qq.com",'男'),26,9);
		Book b3 = new Book("java", new Author("小明","2312@qq.com",'男'),30 );
		Book b4 = new Book("Ios",new Author("师父","341234@qq.com",'女'),24,45);
		Set<Book> books = new HashSet<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		for(Book book:books)
			System.out.println(book);
	}
}
