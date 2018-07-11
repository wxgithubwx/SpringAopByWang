package annotation;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
    public void addBook(String name){
        System.out.println("添加图书,图书名称："+name);
    }
}
