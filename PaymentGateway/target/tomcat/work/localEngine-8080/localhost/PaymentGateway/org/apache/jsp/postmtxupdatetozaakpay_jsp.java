package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.zaakpay.api.lib.ChecksumCalculator;
import com.zaakpay.api.lib.ParamSanitizer;
import java.util.Enumeration;

public final class postmtxupdatetozaakpay_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Zaakpay</title>\r\n");

            //  Please insert your own secret key here
            String secretKey = "Your secret key goes here";
            String allParamValue = ChecksumCalculator.getAllNotEmptyParamValue(request).trim();
            String checksum = ChecksumCalculator.calculateChecksum(secretKey, allParamValue);
            request.setAttribute("checksum", checksum);

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function submitForm(){\r\n");
      out.write("\t\t\tvar form = document.forms[0];\r\n");
      out.write("\t\t\tform.submit();\r\n");
      out.write("\t\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"javascript:submitForm()\">\r\n");
      out.write("<center>\r\n");
      out.write("<table width=\"500px;\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\">Do Not Refresh or Press Back <br/> Redirecting to Zaakpay</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\" valign=\"middle\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<form action=\"https://api.zaakpay.com/updatetransaction\" method=\"post\">\r\n");
      out.write("\t\t\t");

				Enumeration paramNames = request.getParameterNames();
				while (paramNames.hasMoreElements()) {
					String param = (String)paramNames.nextElement();
			
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"");
      out.print(param);
      out.write("\" value=\"");
      out.print(ParamSanitizer.sanitizeParam(request.getParameter(param)));
      out.write("\" />\r\n");
      out.write("\t\t\t");

				}
			
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"checksum\" value=\"");
      out.print(request.getAttribute("checksum"));
      out.write("\" />\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</center>\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
