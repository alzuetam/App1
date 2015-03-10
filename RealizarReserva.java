import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class RealizarReserva extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {
     
        HttpSession session = req.getSession(true);
        
        Vector<String> vec = (Vector<String>)session.getAttribute("lista");
        String user = (String)session.getAttribute("user");
    
        if (vec == null) { 
            vec = new Vector<String>();
        } 
        String[] valueArray = req.getParameterValues("destino");
        if (valueArray != null) {
            for (int i=0;i<valueArray.length;i++) {
                String value = valueArray[i];
                vec.addElement(value);
            }
        }
        session.setAttribute("lista", vec);

        res.setContentType("text/html");
        PrintWriter toClient = res.getWriter();
        
        toClient.println("<html>");
        toClient.println("<title>Reservas</title>");
        toClient.println("<body bgcolor=\"white\">");
        toClient.println("<H2>Tus reservas</H2>");
        toClient.println("<table border=\"1\">");
        
        for (int i= 0; i < vec.size() ; i++ ) {
            toClient.println("<tr>");            
            toClient.println("<td>" + vec.elementAt(i) + "</td>");
			toClient.println("</tr>");
        }
        toClient.println("</table>");
        toClient.println("<BR><a href=\"menuinicial.html\"><font color=\"black\" size=\"+1\">Volver al menu</a>");
        toClient.println("</body>");
        toClient.println("</html>");
        toClient.close();
    }
}