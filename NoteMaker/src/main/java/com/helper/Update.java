package com.helper;

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

@WebServlet("/com.helper.Update")
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hello from Update Servlet");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        int id = Integer.parseInt(req.getParameter("noteId"));
        Session session = FcatoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Note note = (Note)session.get(Note.class,id);

        note.setTitle(title);
        note.setContent(content);
        note.setAddedDate(new Date());

        tx.commit();
        session.close();

        resp.sendRedirect("all.jsp");

    }
}
