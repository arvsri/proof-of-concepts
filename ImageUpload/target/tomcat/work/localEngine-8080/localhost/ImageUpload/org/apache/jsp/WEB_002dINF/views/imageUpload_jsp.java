package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class imageUpload_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fchoose;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fotherwise;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fchoose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fotherwise = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fchoose.release();
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.release();
    _005fjspx_005ftagPool_005fc_005fotherwise.release();
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

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Anucana</title>\r\n");
      out.write("\r\n");
      out.write("<link href=\"http://localhost:8081/contents/css/jquery-ui.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link href=\"http://localhost:8081/contents/css/anucana_style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://localhost:8081/contents/css/jcrop/jquery.Jcrop.css\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://localhost:8081/contents/css/colorbox.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://localhost:8080/ImageUpload/static/style/preloader.css\" />\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://localhost:8081/contents/css/flexslider.css\" type=\"text/css\" media=\"screen\" />\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"http://localhost:8081/contents/images/icons/favicon.ico\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"fontBlack\"> \r\n");
      out.write("\r\n");
      out.write("<div id=\"anucana_outer_wrapper\">\r\n");
      out.write("        <div id=\"anucana_main\">\r\n");
      out.write("            <div id=\"grey_wrapper\" class=\"greyLinen_background\">\r\n");
      out.write("\r\n");
      out.write("                <div style=\"margin-top:10px;\">\r\n");
      out.write("                \r\n");
      out.write("                  <div id=\"container\" style=\"overflow: hidden; position: relative;\">\r\n");
      out.write("                \r\n");
      out.write("                      <div class=\"darkShadeOverlay roundedTopCorners\" style=\"height:200px;\"></div>\r\n");
      out.write("                      <div class=\"darkShadeOverlay roundedBottomCorners\" style=\"height:50px;margin-top:5px;\"></div>\r\n");
      out.write("                      \r\n");
      out.write("                      <div id=\"profileBannerBox\" class=\"communityFontsize col4\">\r\n");
      out.write("                        <table style=\"width:100%\">\r\n");
      out.write("                          <tr>\r\n");
      out.write("                            <td style=\"padding : 30px;width:30%\">\r\n");
      out.write("                              <div id=\"profilePicBlock\">\r\n");
      out.write("                                <img id=\"profilePic\" class=\"profilePicImage\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${imageUploadResponse.imgURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("                                <a class=\"inline\" id=\"imageUploader\" href=\"#inline_content\">\r\n");
      out.write("                                  <img  src=\"http://localhost:8081/contents/images/edit-pen-icon-white.png\" />\r\n");
      out.write("                                </a>\r\n");
      out.write("                              </div> \r\n");
      out.write("                            </td>\r\n");
      out.write("                            <td>\r\n");
      out.write("\t                          <div style=\"float:right; padding-right:10px; position: absolute; top: 38px; right: 5px;\">\r\n");
      out.write("\t                            <a href=\"CommunitySearch.html\">Skip this step</a>\r\n");
      out.write("\t                          </div>\r\n");
      out.write("                            </td>\r\n");
      out.write("                            \r\n");
      out.write("                          </tr>\r\n");
      out.write("                        </table>\r\n");
      out.write("                      </div>\r\n");
      out.write("                  </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div> <!-- end of grey_wrapper -->\r\n");
      out.write("\r\n");
      out.write("        </div> <!-- end of anucana_main -->\r\n");
      out.write("    </div> <!-- end of anucana_wrapper -->\r\n");
      out.write("\r\n");
      out.write("  <script language=\"JavaScript\" type=\"text/javascript\" src=\"http://localhost:8081/contents/js/jquery1.9.1.min.js\" ></script>\r\n");
      out.write("  <script language=\"JavaScript\" type=\"text/javascript\" src=\"http://localhost:8081/contents/js/jquery-ui.js\"></script>\r\n");
      out.write("  <script language=\"JavaScript\" type=\"text/javascript\" src=\"http://localhost:8081/contents/js/jcrop/jquery.Jcrop.min.js\"></script>\r\n");
      out.write("  <script language=\"JavaScript\" type=\"text/javascript\" src=\"http://localhost:8081/contents/js/jquery.colorbox.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("  \r\n");
      out.write("\t  var x = 0;\r\n");
      out.write("\t  var y = 0;\r\n");
      out.write("\t  var x2 = 0;\r\n");
      out.write("\t  var y2 = 0;\r\n");
      out.write("\t  var h = 0;\r\n");
      out.write("\t  var w = 0;\r\n");
      out.write("  \r\n");
      out.write("  $(document).ready(function() {\r\n");
      out.write("        $(\".inline\").colorbox({inline:true});\r\n");
      out.write("        \r\n");
      out.write("        $(document).on(\"cbox_cleanup\", function(){\r\n");
      out.write("          \tlocation.reload();\r\n");
      out.write("         });\r\n");
      out.write("        \r\n");
      out.write("        // html 5 form data \r\n");
      out.write("\t  \tformdata = false;\r\n");
      out.write("        \r\n");
      out.write("        ");
      if (_jspx_meth_c_005fchoose_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        $(\"#uploadFileInput\").change(function() {\r\n");
      out.write("\r\n");
      out.write("        \tif (window.FormData) {\r\n");
      out.write("    \t\t    formdata = new FormData();\r\n");
      out.write("    \t\t}\r\n");
      out.write("\t       \tif(!formdata){\r\n");
      out.write("\t       \t\t$(\"#imageUploadError\").text(\"You are using an old browser. Our image upload functionality might not work properly\");\r\n");
      out.write("\t       \t\treturn;\r\n");
      out.write("\t       \t}\r\n");
      out.write("\t       \tformdata.append(\"image\", this.files[0]);\r\n");
      out.write("\t       \t\r\n");
      out.write("\t   \t    $.ajax({\r\n");
      out.write("\t\t\t\theaders: { \"Accept\" : \"application/json; charset=utf-8\"},\r\n");
      out.write("\t\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\turl: \"/ImageUpload/saveimage\",\r\n");
      out.write("\t\t\t\tdata: formdata,\r\n");
      out.write("\t\t\t\tprocessData: false,\r\n");
      out.write("\t\t\t    contentType: false,\r\n");
      out.write("\t\t\t\tdataType: \"json\",\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tbeforeSend: function( xhr ) {\r\n");
      out.write("\t\t          \t$(\"#imageDrop\").html('<div>loading ... </div><div class=\"loader bubblingG\"><span id=\"bubblingG_1\"></span><span id=\"bubblingG_2\"></span><span id=\"bubblingG_3\"></span></div>').show();\r\n");
      out.write("\t\t          \t$(\"#imageUploadError\").text(\"\");\r\n");
      out.write("\t\t          \t$(\"#cropMe\").hide();\r\n");
      out.write("\t\t            $(\".inline\").colorbox.resize();\r\n");
      out.write("\t\t\t\t},\t\t\t\t\t\r\n");
      out.write("\t\t\t\tsuccess: function(response){\r\n");
      out.write("\t\t\t\t\tvar obj = eval(response);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(obj.imageuploaderror){\r\n");
      out.write("\t\t\t\t\t\thandleImageUploadError(obj.imageuploaderror);\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\t$(\"#cropMe\").attr(\"src\", obj.imageUploadResponse.imgURL + \"?blah=\" + Math.random()).show();\r\n");
      out.write("\t\t\t\t\t\t$(\"#imageDrop\").text(\"Upload image\").hide();\r\n");
      out.write("\t\t\t\t\t\t$(\"#imageUploadError\").text(\"\");\r\n");
      out.write("\t\t\t          \t\r\n");
      out.write("\t\t\t            $('#cropMe').Jcrop({\r\n");
      out.write("\t\t\t                addClass: 'jcrop-centered', // Adds 'jcrop-centered' css class on the image handled by jcrop. \r\n");
      out.write("\t\t\t                setSelect: [0, 160, 160, 0], // Sets a default crop selection before user clicks on image.\r\n");
      out.write("\t\t\t                aspectRatio: 1/1,              // Adds an aspect ratio of 1:1 as we want a square selection.\r\n");
      out.write("\t\t\t                onSelect : function(cord){\r\n");
      out.write("\t\t\t                \tx = cord.x;\r\n");
      out.write("\t\t\t                \ty = cord.y;\r\n");
      out.write("\t\t\t                \tx2 = cord.x2;\r\n");
      out.write("\t\t\t                \ty2 = cord.y2;\r\n");
      out.write("\t\t\t                \tw = cord.w;\r\n");
      out.write("\t\t\t                \th = cord.h;\r\n");
      out.write("\t\t\t                }\r\n");
      out.write("\t\t\t            });\r\n");
      out.write("\t\t\t            \r\n");
      out.write("\t\t\t            $(\"#uploadImageButton\").attr(\"value\",\"Change Image\");\r\n");
      out.write("\t\t\t            $(\"#cropButton\").show();\r\n");
      out.write("\t\t\t            $(\".inline\").colorbox.resize();\t\t            \r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(response){\r\n");
      out.write("\t\t\t\t\thandleImageUploadError(\"Error occurred while uploading the image.\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("   \t \t$(\"#cropButton\").on(\"click\",function(){\r\n");
      out.write("   \t \t\tvar cropCords = \"x=\"+x+\"&y=\"+y+\"&x2=\"+x2+\"&y2=\"+y2+\"&h=\"+h+\"&w=\"+w;\r\n");
      out.write("\t   \t    $.ajax({\r\n");
      out.write("\t\t\t\theaders: { \"Accept\" : \"application/json; charset=utf-8\"},\r\n");
      out.write("\t\t\t\ttype: \"POST\",\r\n");
      out.write("\t\t\t\turl: \"/ImageUpload/cropImage\",\r\n");
      out.write("\t\t\t\tdata:  cropCords,\r\n");
      out.write("\t\t\t\tprocessData: false,\r\n");
      out.write("\t\t\t\tdataType: \"json\",\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tsuccess: function(response){\r\n");
      out.write("\t\t\t\t\tvar obj = eval(response);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tif(obj.imageuploaderror){\r\n");
      out.write("\t\t\t\t\t\t$(\"#imageUploadError\").text(obj.imageuploaderror);\r\n");
      out.write("\t\t\t\t\t}else{\r\n");
      out.write("\t\t\t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror: function(response){\r\n");
      out.write("\t\t\t\t\thandleImageUploadError(\"Error occurred while uploading the image.\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("   \t \t\t\r\n");
      out.write("   \t \t});\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("   \t    function handleImageUploadError(errorMessage){\r\n");
      out.write("   \t    \t\r\n");
      out.write("   \t      \t$(\"#imageDrop\").text(\"Upload image\").show();\r\n");
      out.write("   \t      \t$(\"#cropMe\").hide();\r\n");
      out.write("   \t      \t$(\"#imageUploadError\").text(errorMessage);\r\n");
      out.write("   \t      \t\r\n");
      out.write("   \t        $(\".inline\").colorbox.resize();\t\t            \r\n");
      out.write("   \t    }\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("  </script>\r\n");
      out.write("  <!-- This contains the hidden content for modal window -->\r\n");
      out.write("  <div style=\"display:none\">\r\n");
      out.write("    <div id=\"inline_content\" class=\"lightBox\">\r\n");
      out.write("      \t<div class=\"centered\">\r\n");
      out.write("        \t<span id=\"imageUploadError\" style=\"color:red;font-weight: bold;font-family: sans-serif; font-size: 16px;\"></span>\r\n");
      out.write("      \t</div>\r\n");
      out.write("    \r\n");
      out.write("      \t<div class=\"crop-image-wrapper\">\r\n");
      out.write("        \t<img id=\"cropMe\" src=\"\" style=\"width:400px; margin:50px;\" />\r\n");
      out.write("    \t\t<button id=\"imageDrop\" onclick=\"document.getElementById('uploadFileInput').click()\" title=\"Click Here\">Upload image</button>    \t\r\n");
      out.write("      \t</div>\r\n");
      out.write("    \r\n");
      out.write("      \t<div class=\"centered\">\r\n");
      out.write("        \t<h4>Select a portion of image above and save it as Profile picture</h4>\r\n");
      out.write("      \t</div>\r\n");
      out.write("      \r\n");
      out.write("       \t<div id=\"bottomBar\"  class=\"centered\">\r\n");
      out.write("       \t\t<input id=\"uploadFileInput\" type=\"file\" name=\"datafile\" size=\"40\" />\r\n");
      out.write("       \t\t<input type=\"button\" value=\"Upload Image\" id=\"uploadImageButton\" class=\"blueButton smallButton\" tabindex=\"1\" onclick=\"document.getElementById('uploadFileInput').click()\" />\r\n");
      out.write("       \t\t<input id=\"cropButton\" type=\"button\" value=\"Save Image\" style=\"display:none;\" class=\"blueButton smallButton hidden\" ></input>\r\n");
      out.write("      \t</div>\r\n");
      out.write("\t  </div>\r\n");
      out.write(" \t</div>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_005fchoose_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:choose
    org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_005fchoose_005f0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _005fjspx_005ftagPool_005fc_005fchoose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
    _jspx_th_c_005fchoose_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fchoose_005f0.setParent(null);
    int _jspx_eval_c_005fchoose_005f0 = _jspx_th_c_005fchoose_005f0.doStartTag();
    if (_jspx_eval_c_005fchoose_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        \t");
        if (_jspx_meth_c_005fwhen_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        \t");
        if (_jspx_meth_c_005fotherwise_005f0(_jspx_th_c_005fchoose_005f0, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_005fchoose_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fchoose_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fchoose.reuse(_jspx_th_c_005fchoose_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fwhen_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:when
    org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_005fwhen_005f0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
    _jspx_th_c_005fwhen_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fwhen_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    // /WEB-INF/views/imageUpload.jsp(83,9) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fwhen_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${imageUploadResponse.dummy eq true}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fwhen_005f0 = _jspx_th_c_005fwhen_005f0.doStartTag();
    if (_jspx_eval_c_005fwhen_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t            $(\"#cropMe\").hide();\r\n");
        out.write("        \t");
        int evalDoAfterBody = _jspx_th_c_005fwhen_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fwhen_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fwhen_0026_005ftest.reuse(_jspx_th_c_005fwhen_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fotherwise_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fchoose_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:otherwise
    org.apache.taglibs.standard.tag.common.core.OtherwiseTag _jspx_th_c_005fotherwise_005f0 = (org.apache.taglibs.standard.tag.common.core.OtherwiseTag) _005fjspx_005ftagPool_005fc_005fotherwise.get(org.apache.taglibs.standard.tag.common.core.OtherwiseTag.class);
    _jspx_th_c_005fotherwise_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fotherwise_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fchoose_005f0);
    int _jspx_eval_c_005fotherwise_005f0 = _jspx_th_c_005fotherwise_005f0.doStartTag();
    if (_jspx_eval_c_005fotherwise_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t          \t$(\"#imageDrop\").css(\"display\",\"none\");\r\n");
        out.write("\t          \t$(\"#cropMe\").load( function(){\r\n");
        out.write("\t            \t$(\".inline\").colorbox.resize();\r\n");
        out.write("\t          \t}).attr('src', \"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${imageUploadResponse.imgURL}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\");\r\n");
        out.write("\t          \t$(\"#uploadImageButton\").attr(\"value\",\"Change Image\");\r\n");
        out.write("        \t");
        int evalDoAfterBody = _jspx_th_c_005fotherwise_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fotherwise_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fotherwise.reuse(_jspx_th_c_005fotherwise_005f0);
    return false;
  }
}
