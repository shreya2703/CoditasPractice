package org.example;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

        private JdbcTemplate jt;

        public JdbcTemplate getJt() {
            return jt;
        }

        public void setJt(JdbcTemplate jt) {
            this.jt = jt;
        }
        //Insertion
        public int insertBook(Book b){
            String sql="insert into JTBookDetails values(?,?,?,?)";
            Object[] values={null,b.getBookName(),b.getAuthorName(),b.getPrice()};

            return jt.update(sql,values);
        /*return jt.update("insert into JTBookDetails values(?,?,?)",
                		b.getBookName(),b.getAuthorName(),b.getPrice());*/

        }
        //update
        public int updateBook(String bn,float p){
            return jt.update("update JTBookDetails set price=? where bookName=?",p,bn);
        }
        //delete
        public int deleteBook(String bn){
            return jt.update("delete from JTBookDetails where bookName=?",bn);
        }

        //fetchBycondition
        public List<Book> FetchUsingResultset(int bookId){
            // TODO Auto-generated method stub
            String sql="select * from JTBookDetails where bid=?";
            Object[] values={bookId};
            List<Book> book=(List<Book>) jt.query(sql, values, new ResultSetExtractor()
            {
                @Override
                public List<Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
                    List<Book> l=new ArrayList<>();
                    while(rs.next())
                    {
                        Book book=new Book();
                        book.setBid(rs.getInt(1));//column number /name
                        book.setBookName(rs.getString(2));
                        book.setAuthorName(rs.getString(3));
                        book.setPrice(rs.getFloat(4));
                        l.add(book);
                    }
                    return l;
                }
            });
            return  book;
        }
        public List<Book> fetchAllBooks() {
            // TODO Auto-generated method stub
            String sql="select * from JTBookDetails";

            List<Book> lbook=jt.query(sql,new RowMapper() {

                public Object mapRow(ResultSet rs, int arg1) throws SQLException {
                    // TODO Auto-generated method stub

                    Book book=new Book();
                    book.setBid(rs.getInt(1));//column number /name
                    book.setBookName(rs.getString(2));
                    book.setAuthorName(rs.getString(3));
                    book.setPrice(rs.getFloat(4));
                    return book;
                }
            });
            return lbook;
        }





}
