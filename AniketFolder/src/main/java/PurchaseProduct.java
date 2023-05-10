import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("purchase")
public class PurchaseProduct extends HttpServlet {
    public Product getProductById(int productId) {
        Session HibernateUtil=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = null;
        try {
            String hql = "FROM Product P WHERE P.productId = :productId";
            Query query = session.createQuery(hql);
            query.setParameter("productId", productId);
            List<Product> products = query.list();
            if (products != null && !products.isEmpty()) {
                product = products.get(0);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return product;
    }
static int billamount =0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int id = Integer.parseInt(request.getParameter("ProductId"));
        int productQ = Integer.parseInt(request.getParameter("ProductQ"));


        Product product = getProductById(id);
        if (product != null) {
            int quantity = product.getProductQuantity();
            double price = product.getProductPrice();
            if(productQ>quantity){
                out.println("The Quantity you want is greater the avalable");
            }else{
                billamount += productQ*price;

            }
        }

        response.sendRedirect("purchaseproduct.jsp");
    }
}
