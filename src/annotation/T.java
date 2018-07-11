package annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T {
    public static void main(String[] args) {
       ApplicationContext ac = new ClassPathXmlApplicationContext("annotation/applicationContext.xml");
        BookService bookService = (BookService)ac.getBean("bookService");
        bookService.addBook("java");
    }
}
