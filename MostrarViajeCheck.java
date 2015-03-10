import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MostrarViajeCheck extends HttpServlet {
     
  
  public void init(ServletConfig config) throws ServletException {
    
    super.init(config);
    System.out.println("Iniciando MostrarViajeCheck...");
  } 
        
  
  public void destroy() {
    System.out.println("No hay nada que hacer...");
  } 
          
  
  public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
    devolverPaginaHTML(resp);
  } 
    
  public void devolverPaginaHTML(HttpServletResponse resp) 
      throws IOException {
    
    resp.setContentType("text/html");

    
    PrintWriter out = null;
    try {
      out=resp.getWriter();
    } catch (IOException io) {
      System.out.println("Se ha producido una excepcion");    
    }

    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<TITLE>ELIJA UN VIAJE</TITLE>");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<B><FONT size=+2>ELIJA UN VIAJE: </FONT></B>");

    File file = new File("lista.txt");
    Scanner scanner = new Scanner(file);

    String line = null;
    String strout = "";
   /* strout += "<form action=\"RealizarReserva\" method=GET>";
    strout += "<TABLE border=1>";
    strout += "<TR>";
    strout += "<TH>";
    strout += "&nbsp;";
    strout += "</TH>";
    strout += "<TH>";
    strout += "origen";
    strout += "</TH>";
    strout += "<TH>";
    strout += "destino";
    strout += "</TH>";
    strout += "<TH>";
    strout += "hora";
    strout += "</TH>";
    strout += "</TR>";*/
    while (scanner.hasNext()) {
	    strout += "<form action=\"RealizarReserva\" method=GET>";
        strout += "<TABLE border=1>";
        strout += "<TR>";
        strout += "<TH>";
        strout += "origen";
        strout += "</TH>";
        strout += "<TH>";
        strout += "destino";
        strout += "</TH>";
        strout += "<TH>";
        strout += "hora";
        strout += "</TH>";
        strout += "</TR>";
        line = scanner.nextLine();
        Scanner lineSc = new Scanner(line);
        lineSc.useDelimiter("\t");
        String origen = lineSc.next();
        String destino = lineSc.next();
        String hora = lineSc.next();
        strout += "<TR>";
        
        strout += "<td><input TYPE=\"hidden\" NAME=\"destino\" VALUE=\"" + origen + "\"> origen:" + origen + "</td>";
        
        strout += "<TD>";
        strout += destino;
        strout += "</TD>";
        strout += "<TD>";
        strout += hora;
        strout += "</TD>";
        strout += "</TR>";
		strout += "</TABLE>";
        strout += "<input type=submit>";
        strout += "</FORM>";
       
    }
    out.println(strout);
    out.println("<BR><a href=\"menu.html\">Ir al menu</a>");
    out.println("</BODY>");
    out.println("</HTML>");

  
    out.flush();
    out.close();
  } 
     
  
  public String getServletInfo() {
    return "Este servlet lee los datos de un formulario y los muestra en pantalla";
  } 
}
