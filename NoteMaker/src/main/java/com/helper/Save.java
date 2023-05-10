package com.helper;

import com.helper.FcatoryProvider;
import com.helper.Note;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/com.helper.Save")
public class Save extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String title = req.getParameter("title");
        String content = req.getParameter("content");

        Note note = new Note(title,content,new Date());
        Session session = FcatoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(note);
        tx.commit();
        session.close();
        resp.setContentType("Text/HTML");
        PrintWriter out = resp.getWriter();
        out.println("Note added successfully");
        out.println("</br>");
        out.println("<a href='all.jsp'>View All Notes</a>");



    }
}
