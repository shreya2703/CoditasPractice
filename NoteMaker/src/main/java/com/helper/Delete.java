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

@WebServlet("/com.helper.Delete")
public class Delete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hello from Delete Servlet");
        int noteId = Integer.parseInt(req.getParameter("note_id"));
        Session session = FcatoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Note note = (Note)session.get(Note.class,noteId);
        session.delete(note);
        tx.commit();
        session.close();
        resp.sendRedirect("all.jsp");

    }
}
