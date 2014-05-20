package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AsyncUserForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005fcommandName_005faction;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fmaxlength_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005fpassword_0026_005fpath_005fmaxlength_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005fcommandName_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fmaxlength_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fform_005fpassword_0026_005fpath_005fmaxlength_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005fcommandName_005faction.release();
    _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fmaxlength_005fnobody.release();
    _005fjspx_005ftagPool_005fform_005fpassword_0026_005fpath_005fmaxlength_005fnobody.release();
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
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Async Login Form </title>\r\n");
      out.write("<script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t");
      if (_jspx_meth_form_005fform_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("\t  $(document).ready(function(){\r\n");
      out.write("\t\t  $(\"form\").submit(function(event){\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t  \tevent.preventDefault();\r\n");
      out.write("\r\n");
      out.write("\t\t\t  \tvar form = $(this);\r\n");
      out.write("\t\t\t\tvar url = form.attr(\"action\");\r\n");
      out.write("\t\t\t\tvar dataForSubmission = form.serialize();\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\theaders: { \"Accept\" : \"application/json; charset=utf-8\",         \r\n");
      out.write("\t\t                \t   \"Content-Type\" : \"text/plain; charset=utf-8\"   \r\n");
      out.write("\t\t  \t\t\t\t\t },\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\t\turl: url,\r\n");
      out.write("\t\t\t\t\tdata: dataForSubmission,\r\n");
      out.write("\t\t\t\t\tdataType: \"json\",\r\n");
      out.write("\t\t\t\t\tsuccess: function(response){\r\n");
      out.write("\t\t\t\t\t\tif(response.viewError != 'undefined' && response.viewError.fieldErrors != 'undefined' && response.viewError.fieldErrors.length != 0){\r\n");
      out.write("\t\t\t\t\t\t\t// handle error first\r\n");
      out.write("\t\t\t\t\t\t\t$.each(response.viewError.fieldErrors,function( key, value ){\r\n");
      out.write("\t\t\t\t\t\t\t\tform.find(\"#\" + value.field + \"Error\").text(value.errorMessage);\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror: function(response){\r\n");
      out.write("\t\t\t\t\t\tconsole.log(\"Error occured in ajax call\");\r\n");
      out.write("\t\t\t\t\t\tconsole.log(response);\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t  });\r\n");
      out.write("  </script>\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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

  private boolean _jspx_meth_form_005fform_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_005fform_005f0 = (org.springframework.web.servlet.tags.form.FormTag) _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005fcommandName_005faction.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_form_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_form_005fform_005f0.setParent(null);
    // /WEB-INF/views/AsyncUserForm.jsp(13,1) name = method type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setMethod("post");
    // /WEB-INF/views/AsyncUserForm.jsp(13,1) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setAction("user/create");
    // /WEB-INF/views/AsyncUserForm.jsp(13,1) name = commandName type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setCommandName("userLogin");
    int[] _jspx_push_body_count_form_005fform_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_form_005fform_005f0 = _jspx_th_form_005fform_005f0.doStartTag();
      if (_jspx_eval_form_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t<table>\r\n");
          out.write("\t\t\t<tr><td>First Name : </td><td>");
          if (_jspx_meth_form_005finput_005f0(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("</td><td><span class=\"error\" id=\"firstNameError\"></span></td></tr>\r\n");
          out.write("\t\t\t<tr><td>Last Name : </td><td>");
          if (_jspx_meth_form_005finput_005f1(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("</td><td><span class=\"error\" id=\"lastNameError\"></span></td></tr>\r\n");
          out.write("\t\t\t<tr><td>User Name : </td><td>");
          if (_jspx_meth_form_005finput_005f2(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("</td><td><span class=\"error\" id=\"usernameError\"></span></td></tr>\r\n");
          out.write("\t\t\t<tr><td>Password : </td><td>");
          if (_jspx_meth_form_005fpassword_005f0(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("</td><td><span class=\"error\" id=\"passwordError\"></span></td></tr>\r\n");
          out.write("\t\t\t<tr><td>Reenter Password : </td><td>");
          if (_jspx_meth_form_005fpassword_005f1(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("</td><td><span class=\"error\" id=\"passwordRepeatError\"></span></td></tr>\r\n");
          out.write("\t\t\t<tr><td><input type=\"submit\" name=\"Submit\"></input></td><td><input type=\"reset\" name=\"Clear\"></td></tr>\r\n");
          out.write("\t\t</table>\r\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_form_005fform_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_form_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005fform_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005fform_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005fform_005f0.doFinally();
      _005fjspx_005ftagPool_005fform_005fform_0026_005fmethod_005fcommandName_005faction.reuse(_jspx_th_form_005fform_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_form_005finput_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_005finput_005f0 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fmaxlength_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_005finput_005f0.setPageContext(_jspx_page_context);
    _jspx_th_form_005finput_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/views/AsyncUserForm.jsp(15,33) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f0.setPath("firstName");
    // /WEB-INF/views/AsyncUserForm.jsp(15,33) name = maxlength type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f0.setMaxlength("50");
    int[] _jspx_push_body_count_form_005finput_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_form_005finput_005f0 = _jspx_th_form_005finput_005f0.doStartTag();
      if (_jspx_th_form_005finput_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005finput_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005finput_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005finput_005f0.doFinally();
      _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fmaxlength_005fnobody.reuse(_jspx_th_form_005finput_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_form_005finput_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_005finput_005f1 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fmaxlength_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_005finput_005f1.setPageContext(_jspx_page_context);
    _jspx_th_form_005finput_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/views/AsyncUserForm.jsp(16,32) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f1.setPath("lastName");
    // /WEB-INF/views/AsyncUserForm.jsp(16,32) name = maxlength type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f1.setMaxlength("50");
    int[] _jspx_push_body_count_form_005finput_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_form_005finput_005f1 = _jspx_th_form_005finput_005f1.doStartTag();
      if (_jspx_th_form_005finput_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005finput_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005finput_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005finput_005f1.doFinally();
      _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fmaxlength_005fnobody.reuse(_jspx_th_form_005finput_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_form_005finput_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:input
    org.springframework.web.servlet.tags.form.InputTag _jspx_th_form_005finput_005f2 = (org.springframework.web.servlet.tags.form.InputTag) _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fmaxlength_005fnobody.get(org.springframework.web.servlet.tags.form.InputTag.class);
    _jspx_th_form_005finput_005f2.setPageContext(_jspx_page_context);
    _jspx_th_form_005finput_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/views/AsyncUserForm.jsp(17,32) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f2.setPath("username");
    // /WEB-INF/views/AsyncUserForm.jsp(17,32) name = maxlength type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005finput_005f2.setMaxlength("20");
    int[] _jspx_push_body_count_form_005finput_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_form_005finput_005f2 = _jspx_th_form_005finput_005f2.doStartTag();
      if (_jspx_th_form_005finput_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005finput_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005finput_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005finput_005f2.doFinally();
      _005fjspx_005ftagPool_005fform_005finput_0026_005fpath_005fmaxlength_005fnobody.reuse(_jspx_th_form_005finput_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_form_005fpassword_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:password
    org.springframework.web.servlet.tags.form.PasswordInputTag _jspx_th_form_005fpassword_005f0 = (org.springframework.web.servlet.tags.form.PasswordInputTag) _005fjspx_005ftagPool_005fform_005fpassword_0026_005fpath_005fmaxlength_005fnobody.get(org.springframework.web.servlet.tags.form.PasswordInputTag.class);
    _jspx_th_form_005fpassword_005f0.setPageContext(_jspx_page_context);
    _jspx_th_form_005fpassword_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/views/AsyncUserForm.jsp(18,31) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fpassword_005f0.setPath("password");
    // /WEB-INF/views/AsyncUserForm.jsp(18,31) name = maxlength type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fpassword_005f0.setMaxlength("20");
    int[] _jspx_push_body_count_form_005fpassword_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_form_005fpassword_005f0 = _jspx_th_form_005fpassword_005f0.doStartTag();
      if (_jspx_th_form_005fpassword_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005fpassword_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005fpassword_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005fpassword_005f0.doFinally();
      _005fjspx_005ftagPool_005fform_005fpassword_0026_005fpath_005fmaxlength_005fnobody.reuse(_jspx_th_form_005fpassword_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_form_005fpassword_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:password
    org.springframework.web.servlet.tags.form.PasswordInputTag _jspx_th_form_005fpassword_005f1 = (org.springframework.web.servlet.tags.form.PasswordInputTag) _005fjspx_005ftagPool_005fform_005fpassword_0026_005fpath_005fmaxlength_005fnobody.get(org.springframework.web.servlet.tags.form.PasswordInputTag.class);
    _jspx_th_form_005fpassword_005f1.setPageContext(_jspx_page_context);
    _jspx_th_form_005fpassword_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/views/AsyncUserForm.jsp(19,39) name = path type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fpassword_005f1.setPath("passwordRepeat");
    // /WEB-INF/views/AsyncUserForm.jsp(19,39) name = maxlength type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fpassword_005f1.setMaxlength("20");
    int[] _jspx_push_body_count_form_005fpassword_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_form_005fpassword_005f1 = _jspx_th_form_005fpassword_005f1.doStartTag();
      if (_jspx_th_form_005fpassword_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005fpassword_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005fpassword_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005fpassword_005f1.doFinally();
      _005fjspx_005ftagPool_005fform_005fpassword_0026_005fpath_005fmaxlength_005fnobody.reuse(_jspx_th_form_005fpassword_005f1);
    }
    return false;
  }
}
