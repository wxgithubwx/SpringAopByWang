package annotation;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    //因为是new所以不需要注入
    BookDao bookDao=new BookDao();
    public void addBook(String name){
       // int i=1/0;
        bookDao.addBook(name);
    }
}
