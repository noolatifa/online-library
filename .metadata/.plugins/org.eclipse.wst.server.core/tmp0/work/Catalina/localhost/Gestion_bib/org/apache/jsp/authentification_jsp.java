/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.1
 * Generated at: 2023-12-13 00:12:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class authentification_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n");
      out.write("<title>Gestion d'une Bibliothèque</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"main\">\r\n");
      out.write("\r\n");
      out.write("		<!-- Sing in  Form -->\r\n");
      out.write("		<section class=\"sign-in\">\r\n");
      out.write("			<div class=\"container\">\r\n");
      out.write("				<div class=\"signin-content\">\r\n");
      out.write("					<div class=\"signin-image\">\r\n");
      out.write("						<figure>\r\n");
      out.write("    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/img/signin-image.jpg\" alt=\"Sign up image\">\r\n");
      out.write("</figure>\r\n");
      out.write("\r\n");
      out.write("						<a href=\"signup.jsp\" class=\"signup-image-link\">Créer un compte</a>\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("					<div class=\"signin-form\">\r\n");
      out.write("						<h2 class=\"form-title\">Connectez-vous</h2>\r\n");
      out.write("                        ");
 String errorMessage = (String) request.getAttribute("errorMessage"); 
      out.write("\r\n");
      out.write("                        ");
 if (errorMessage != null && !errorMessage.isEmpty()) { 
      out.write("\r\n");
      out.write("                            <p style=\"color: red;\">");
      out.print( errorMessage );
      out.write("</p>\r\n");
      out.write("                        ");
 } 
      out.write("\r\n");
      out.write("						<form method=\"post\" action=\"AuthentificationServlet\" class=\"register-form\"\r\n");
      out.write("							id=\"login-form\">\r\n");
      out.write("							<div class=\"form-group\">\r\n");
      out.write("								<label for=\"email\"><i\r\n");
      out.write("									class=\"zmdi zmdi-account material-icons-name\"></i></label> <input\r\n");
      out.write("									type=\"text\" name=\"email\" id=\"email\"\r\n");
      out.write("									placeholder=\"Adresse email\" />\r\n");
      out.write("							</div>\r\n");
      out.write("							<div class=\"form-group\">\r\n");
      out.write("								<label for=\"password\"><i class=\"zmdi zmdi-lock\"></i></label> <input\r\n");
      out.write("									type=\"password\" name=\"motDePasse\" id=\"motDePasse\"\r\n");
      out.write("									placeholder=\"Mot de passe\" />\r\n");
      out.write("							</div>\r\n");
      out.write("							\r\n");
      out.write("							<div class=\"form-group form-button\">\r\n");
      out.write("								<input type=\"submit\" name=\"signin\" id=\"signin\"\r\n");
      out.write("									class=\"form-submit\" value=\"Se Connecter\" />\r\n");
      out.write("							</div>\r\n");
      out.write("							\r\n");
      out.write("						</form>\r\n");
      out.write("						\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</section>\r\n");
      out.write("\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("display-flex, .display-flex, .display-flex-center, .signup-content, .signin-content, .social-login, .socials {\r\n");
      out.write("  display: flex;\r\n");
      out.write("  display: -webkit-flex; }\r\n");
      out.write("list-type-ulli, .socials {\r\n");
      out.write("  list-style-type: none;\r\n");
      out.write("  margin: 0;\r\n");
      out.write("  padding: 0; }\r\n");
      out.write("a:focus, a:active {\r\n");
      out.write("  text-decoration: none;\r\n");
      out.write("  outline: none;\r\n");
      out.write("  transition: all 300ms ease 0s;\r\n");
      out.write("  -moz-transition: all 300ms ease 0s;\r\n");
      out.write("  -webkit-transition: all 300ms ease 0s;\r\n");
      out.write("  -o-transition: all 300ms ease 0s;\r\n");
      out.write("  -ms-transition: all 300ms ease 0s; }\r\n");
      out.write("\r\n");
      out.write("input, select, textarea {\r\n");
      out.write("  outline: none;\r\n");
      out.write("  appearance: unset !important;\r\n");
      out.write("  -moz-appearance: unset !important;\r\n");
      out.write("  -webkit-appearance: unset !important;\r\n");
      out.write("  -o-appearance: unset !important;\r\n");
      out.write("  -ms-appearance: unset !important; }\r\n");
      out.write("\r\n");
      out.write("input::-webkit-outer-spin-button, input::-webkit-inner-spin-button {\r\n");
      out.write("  appearance: none !important;\r\n");
      out.write("  -moz-appearance: none !important;\r\n");
      out.write("  -webkit-appearance: none !important;\r\n");
      out.write("  -o-appearance: none !important;\r\n");
      out.write("  -ms-appearance: none !important;\r\n");
      out.write("  margin: 0; }\r\n");
      out.write("\r\n");
      out.write("input:focus, select:focus, textarea:focus {\r\n");
      out.write("  outline: none;\r\n");
      out.write("  box-shadow: none !important;\r\n");
      out.write("  -moz-box-shadow: none !important;\r\n");
      out.write("  -webkit-box-shadow: none !important;\r\n");
      out.write("  -o-box-shadow: none !important;\r\n");
      out.write("  -ms-box-shadow: none !important; }\r\n");
      out.write("\r\n");
      out.write("input[type=checkbox] {\r\n");
      out.write("  appearance: checkbox !important;\r\n");
      out.write("  -moz-appearance: checkbox !important;\r\n");
      out.write("  -webkit-appearance: checkbox !important;\r\n");
      out.write("  -o-appearance: checkbox !important;\r\n");
      out.write("  -ms-appearance: checkbox !important; }\r\n");
      out.write("\r\n");
      out.write("input[type=radio] {\r\n");
      out.write("  appearance: radio !important;\r\n");
      out.write("  -moz-appearance: radio !important;\r\n");
      out.write("  -webkit-appearance: radio !important;\r\n");
      out.write("  -o-appearance: radio !important;\r\n");
      out.write("  -ms-appearance: radio !important; }\r\n");
      out.write("\r\n");
      out.write("img {\r\n");
      out.write("  max-width: 100%;\r\n");
      out.write("  height: auto; }\r\n");
      out.write("\r\n");
      out.write("figure {\r\n");
      out.write("  margin: 0; }\r\n");
      out.write("\r\n");
      out.write("p {\r\n");
      out.write("  margin-bottom: 0px;\r\n");
      out.write("  font-size: 15px;\r\n");
      out.write("  color: #777; }\r\n");
      out.write("\r\n");
      out.write("h2 {\r\n");
      out.write("  line-height: 1.66;\r\n");
      out.write("  margin: 0;\r\n");
      out.write("  padding: 0;\r\n");
      out.write("  font-weight: bold;\r\n");
      out.write("  color: #222;\r\n");
      out.write("  font-family: Poppins;\r\n");
      out.write("  font-size: 35px; }\r\n");
      out.write("\r\n");
      out.write(".main {\r\n");
      out.write("  background: #f8f8f8;\r\n");
      out.write("  padding: 50px 0; }\r\n");
      out.write("\r\n");
      out.write(".clear {\r\n");
      out.write("  clear: both; }\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("  font-size: 13px;\r\n");
      out.write("  line-height: 1.8;\r\n");
      out.write("  color: #222;\r\n");
      out.write("  background: #f8f8f8;\r\n");
      out.write("  font-weight: 400;\r\n");
      out.write("  font-family: Poppins; }\r\n");
      out.write("\r\n");
      out.write(".container {\r\n");
      out.write("  width: 900px;\r\n");
      out.write("  background: #fff;\r\n");
      out.write("  margin: 0 auto;\r\n");
      out.write("  box-shadow: 0px 15px 16.83px 0.17px rgba(0, 0, 0, 0.05);\r\n");
      out.write("  -moz-box-shadow: 0px 15px 16.83px 0.17px rgba(0, 0, 0, 0.05);\r\n");
      out.write("  -webkit-box-shadow: 0px 15px 16.83px 0.17px rgba(0, 0, 0, 0.05);\r\n");
      out.write("  -o-box-shadow: 0px 15px 16.83px 0.17px rgba(0, 0, 0, 0.05);\r\n");
      out.write("  -ms-box-shadow: 0px 15px 16.83px 0.17px rgba(0, 0, 0, 0.05);\r\n");
      out.write("  border-radius: 20px;\r\n");
      out.write("  -moz-border-radius: 20px;\r\n");
      out.write("  -webkit-border-radius: 20px;\r\n");
      out.write("  -o-border-radius: 20px;\r\n");
      out.write("  -ms-border-radius: 20px; }\r\n");
      out.write("\r\n");
      out.write(".display-flex {\r\n");
      out.write("  justify-content: space-between;\r\n");
      out.write("  -moz-justify-content: space-between;\r\n");
      out.write("  -webkit-justify-content: space-between;\r\n");
      out.write("  -o-justify-content: space-between;\r\n");
      out.write("  -ms-justify-content: space-between;\r\n");
      out.write("  align-items: center;\r\n");
      out.write("  -moz-align-items: center;\r\n");
      out.write("  -webkit-align-items: center;\r\n");
      out.write("  -o-align-items: center;\r\n");
      out.write("  -ms-align-items: center; }\r\n");
      out.write("\r\n");
      out.write(".display-flex-center {\r\n");
      out.write("  justify-content: center;\r\n");
      out.write("  -moz-justify-content: center;\r\n");
      out.write("  -webkit-justify-content: center;\r\n");
      out.write("  -o-justify-content: center;\r\n");
      out.write("  -ms-justify-content: center;\r\n");
      out.write("  align-items: center;\r\n");
      out.write("  -moz-align-items: center;\r\n");
      out.write("  -webkit-align-items: center;\r\n");
      out.write("  -o-align-items: center;\r\n");
      out.write("  -ms-align-items: center; }\r\n");
      out.write("\r\n");
      out.write(".position-center {\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  top: 50%;\r\n");
      out.write("  left: 50%;\r\n");
      out.write("  transform: translate(-50%, -50%);\r\n");
      out.write("  -moz-transform: translate(-50%, -50%);\r\n");
      out.write("  -webkit-transform: translate(-50%, -50%);\r\n");
      out.write("  -o-transform: translate(-50%, -50%);\r\n");
      out.write("  -ms-transform: translate(-50%, -50%); }\r\n");
      out.write("\r\n");
      out.write(".signup {\r\n");
      out.write("  margin-bottom: 50px;\r\n");
      out.write("    \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".signup-content {\r\n");
      out.write("  padding: 75px 0; }\r\n");
      out.write("  .signin-form{\r\n");
      out.write("    margin-top: 5%; \r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write(".signup-form, .signup-image, .signin-form, .signin-image {\r\n");
      out.write("  width: 50%;\r\n");
      out.write("  overflow: hidden; }\r\n");
      out.write("\r\n");
      out.write(".signup-image {\r\n");
      out.write("  margin: 0 55px; }\r\n");
      out.write("\r\n");
      out.write(".form-title {\r\n");
      out.write("  margin-bottom: 33px;\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write(".signup-image {\r\n");
      out.write("  margin-top: 45px; }\r\n");
      out.write("\r\n");
      out.write("figure {\r\n");
      out.write("  margin-bottom: 50px;\r\n");
      out.write("  text-align: center; }\r\n");
      out.write("\r\n");
      out.write(".form-submit {\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  background: #6dabe4;\r\n");
      out.write("  color: #fff;\r\n");
      out.write("  border-bottom: none;\r\n");
      out.write("  width: auto;\r\n");
      out.write("  padding: 15px 39px;\r\n");
      out.write("  border-radius: 5px;\r\n");
      out.write("  -moz-border-radius: 5px;\r\n");
      out.write("  -webkit-border-radius: 5px;\r\n");
      out.write("  -o-border-radius: 5px;\r\n");
      out.write("  -ms-border-radius: 5px;\r\n");
      out.write("  margin-top: 25px;\r\n");
      out.write("  cursor: pointer; }\r\n");
      out.write("  .form-submit:hover {\r\n");
      out.write("    background: #4292dc; }\r\n");
      out.write("\r\n");
      out.write("#signin {\r\n");
      out.write("  margin-top: 16px; }\r\n");
      out.write("\r\n");
      out.write(".signup-image-link {\r\n");
      out.write("  font-size: 14px;\r\n");
      out.write("  color: #222;\r\n");
      out.write("  display: block;\r\n");
      out.write("  text-align: center; }\r\n");
      out.write("\r\n");
      out.write(".term-service {\r\n");
      out.write("  font-size: 13px;\r\n");
      out.write("  color: #222; }\r\n");
      out.write("\r\n");
      out.write(".signup-form {\r\n");
      out.write("  margin-left: 75px;\r\n");
      out.write("  margin-right: 75px;\r\n");
      out.write("  padding-left: 34px; }\r\n");
      out.write("\r\n");
      out.write(".register-form {\r\n");
      out.write("  width: 100%; }\r\n");
      out.write("\r\n");
      out.write(".form-group {\r\n");
      out.write("  position: relative;\r\n");
      out.write("  margin-bottom: 25px;\r\n");
      out.write("  overflow: hidden; }\r\n");
      out.write("  .form-group:last-child {\r\n");
      out.write("    margin-bottom: 0px; }\r\n");
      out.write("\r\n");
      out.write("input {\r\n");
      out.write("  width: 100%;\r\n");
      out.write("  display: block;\r\n");
      out.write("  border: none;\r\n");
      out.write("  border-bottom: 1px solid #999;\r\n");
      out.write("  padding: 6px 30px;\r\n");
      out.write("  font-family: Poppins;\r\n");
      out.write("  box-sizing: border-box; }\r\n");
      out.write("  input::-webkit-input-placeholder {\r\n");
      out.write("    color: #999; }\r\n");
      out.write("  input::-moz-placeholder {\r\n");
      out.write("    color: #999; }\r\n");
      out.write("  input:-ms-input-placeholder {\r\n");
      out.write("    color: #999; }\r\n");
      out.write("  input:-moz-placeholder {\r\n");
      out.write("    color: #999; }\r\n");
      out.write("  input:focus {\r\n");
      out.write("    border-bottom: 1px solid #222; }\r\n");
      out.write("    input:focus::-webkit-input-placeholder {\r\n");
      out.write("      color: #222; }\r\n");
      out.write("    input:focus::-moz-placeholder {\r\n");
      out.write("      color: #222; }\r\n");
      out.write("    input:focus:-ms-input-placeholder {\r\n");
      out.write("      color: #222; }\r\n");
      out.write("    input:focus:-moz-placeholder {\r\n");
      out.write("      color: #222; }\r\n");
      out.write("\r\n");
      out.write("input[type=checkbox]:not(old) {\r\n");
      out.write("  width: 2em;\r\n");
      out.write("  margin: 0;\r\n");
      out.write("  padding: 0;\r\n");
      out.write("  font-size: 1em;\r\n");
      out.write("  display: none; }\r\n");
      out.write("\r\n");
      out.write("input[type=checkbox]:not(old) + label {\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  line-height: 1.5em;\r\n");
      out.write("  margin-top: 6px; }\r\n");
      out.write("\r\n");
      out.write("input[type=checkbox]:not(old) + label > span {\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  width: 13px;\r\n");
      out.write("  height: 13px;\r\n");
      out.write("  margin-right: 15px;\r\n");
      out.write("  margin-bottom: 3px;\r\n");
      out.write("  border: 1px solid #999;\r\n");
      out.write("  border-radius: 2px;\r\n");
      out.write("  -moz-border-radius: 2px;\r\n");
      out.write("  -webkit-border-radius: 2px;\r\n");
      out.write("  -o-border-radius: 2px;\r\n");
      out.write("  -ms-border-radius: 2px;\r\n");
      out.write("  background: white;\r\n");
      out.write("  background-image: -moz-linear-gradient(white, white);\r\n");
      out.write("  background-image: -ms-linear-gradient(white, white);\r\n");
      out.write("  background-image: -o-linear-gradient(white, white);\r\n");
      out.write("  background-image: -webkit-linear-gradient(white, white);\r\n");
      out.write("  background-image: linear-gradient(white, white);\r\n");
      out.write("  vertical-align: bottom; }\r\n");
      out.write("\r\n");
      out.write("input[type=checkbox]:not(old):checked + label > span {\r\n");
      out.write("  background-image: -moz-linear-gradient(white, white);\r\n");
      out.write("  background-image: -ms-linear-gradient(white, white);\r\n");
      out.write("  background-image: -o-linear-gradient(white, white);\r\n");
      out.write("  background-image: -webkit-linear-gradient(white, white);\r\n");
      out.write("  background-image: linear-gradient(white, white); }\r\n");
      out.write("\r\n");
      out.write("input[type=checkbox]:not(old):checked + label > span:before {\r\n");
      out.write("  content: '\\f26b';\r\n");
      out.write("  display: block;\r\n");
      out.write("  color: #222;\r\n");
      out.write("  font-size: 11px;\r\n");
      out.write("  line-height: 1.2;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  font-weight: bold; }\r\n");
      out.write("\r\n");
      out.write(".agree-term {\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  width: auto; }\r\n");
      out.write("\r\n");
      out.write("label {\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  left: 0;\r\n");
      out.write("  top: 50%;\r\n");
      out.write("  transform: translateY(-50%);\r\n");
      out.write("  -moz-transform: translateY(-50%);\r\n");
      out.write("  -webkit-transform: translateY(-50%);\r\n");
      out.write("  -o-transform: translateY(-50%);\r\n");
      out.write("  -ms-transform: translateY(-50%);\r\n");
      out.write("  color: #222; }\r\n");
      out.write("\r\n");
      out.write(".label-has-error {\r\n");
      out.write("  top: 22%; }\r\n");
      out.write("\r\n");
      out.write("label.error {\r\n");
      out.write("  position: relative;\r\n");
      out.write("  background: url(\"../images/unchecked.gif\") no-repeat;\r\n");
      out.write("  background-position-y: 3px;\r\n");
      out.write("  padding-left: 20px;\r\n");
      out.write("  display: block;\r\n");
      out.write("  margin-top: 20px; }\r\n");
      out.write("\r\n");
      out.write("label.valid {\r\n");
      out.write("  display: block;\r\n");
      out.write("  position: absolute;\r\n");
      out.write("  right: 0;\r\n");
      out.write("  left: auto;\r\n");
      out.write("  margin-top: -6px;\r\n");
      out.write("  width: 20px;\r\n");
      out.write("  height: 20px;\r\n");
      out.write("  background: transparent; }\r\n");
      out.write("  label.valid:after {\r\n");
      out.write("    content: '\\f269';\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    height: 100%;\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    /* right: 0; */\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("    color: green; }\r\n");
      out.write("\r\n");
      out.write(".label-agree-term {\r\n");
      out.write("  position: relative;\r\n");
      out.write("  top: 0%;\r\n");
      out.write("  transform: translateY(0);\r\n");
      out.write("  -moz-transform: translateY(0);\r\n");
      out.write("  -webkit-transform: translateY(0);\r\n");
      out.write("  -o-transform: translateY(0);\r\n");
      out.write("  -ms-transform: translateY(0); }\r\n");
      out.write("\r\n");
      out.write(".material-icons-name {\r\n");
      out.write("  font-size: 18px; }\r\n");
      out.write("\r\n");
      out.write(".signin-content {\r\n");
      out.write("  padding-top: 67px;\r\n");
      out.write("  padding-bottom: 87px; }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".signin-form {\r\n");
      out.write("  margin-right: 90px;\r\n");
      out.write("  margin-left: 80px; }\r\n");
      out.write("\r\n");
      out.write(".signin-image {\r\n");
      out.write("  margin-left: 110px;\r\n");
      out.write("  margin-right: 20px;\r\n");
      out.write("  margin-top: 10px; }\r\n");
      out.write("\r\n");
      out.write("@media screen and (max-width: 1200px) {\r\n");
      out.write("  .container {\r\n");
      out.write("    width: calc( 100% - 30px);\r\n");
      out.write("    max-width: 100%; } }\r\n");
      out.write("@media screen and (min-width: 1024px) {\r\n");
      out.write("  .container {\r\n");
      out.write("    max-width: 1200px; } }\r\n");
      out.write("@media screen and (max-width: 768px) {\r\n");
      out.write("  .signup-content, .signin-content {\r\n");
      out.write("    flex-direction: column;\r\n");
      out.write("    -moz-flex-direction: column;\r\n");
      out.write("    -webkit-flex-direction: column;\r\n");
      out.write("    -o-flex-direction: column;\r\n");
      out.write("    -ms-flex-direction: column;\r\n");
      out.write("    justify-content: center;\r\n");
      out.write("    -moz-justify-content: center;\r\n");
      out.write("    -webkit-justify-content: center;\r\n");
      out.write("    -o-justify-content: center;\r\n");
      out.write("    -ms-justify-content: center; }\r\n");
      out.write("\r\n");
      out.write("  .signup-form {\r\n");
      out.write("    margin-left: 0px;\r\n");
      out.write("    margin-right: 0px;\r\n");
      out.write("    padding-left: 0px;\r\n");
      out.write("    /* box-sizing: border-box; */\r\n");
      out.write("    padding: 0 30px; }\r\n");
      out.write("\r\n");
      out.write("  .signin-image {\r\n");
      out.write("    margin-left: 0px;\r\n");
      out.write("    margin-right: 0px;\r\n");
      out.write("    margin-top: 50px;\r\n");
      out.write("    order: 2;\r\n");
      out.write("    -moz-order: 2;\r\n");
      out.write("    -webkit-order: 2;\r\n");
      out.write("    -o-order: 2;\r\n");
      out.write("    -ms-order: 2; }\r\n");
      out.write("\r\n");
      out.write("  .signup-form, .signup-image, .signin-form, .signin-image {\r\n");
      out.write("    width: auto; }\r\n");
      out.write("\r\n");
      out.write("  .social-login {\r\n");
      out.write("    justify-content: center;\r\n");
      out.write("    -moz-justify-content: center;\r\n");
      out.write("    -webkit-justify-content: center;\r\n");
      out.write("    -o-justify-content: center;\r\n");
      out.write("    -ms-justify-content: center; }\r\n");
      out.write("\r\n");
      out.write("  .form-button {\r\n");
      out.write("    text-align: center; }\r\n");
      out.write("\r\n");
      out.write("  .signin-form {\r\n");
      out.write("    order: 1;\r\n");
      out.write("    -moz-order: 1;\r\n");
      out.write("    -webkit-order: 1;\r\n");
      out.write("    -o-order: 1;\r\n");
      out.write("    -ms-order: 1;\r\n");
      out.write("    margin-right: 0px;\r\n");
      out.write("    margin-left: 0px;\r\n");
      out.write("    padding: 0 30px; }\r\n");
      out.write("\r\n");
      out.write("  .form-title {\r\n");
      out.write("    text-align: center; } }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  * {\r\n");
      out.write("            font-family: 'Poppins', sans-serif;\r\n");
      out.write("            /* Add other styles as needed */\r\n");
      out.write("        }\r\n");
      out.write("</style>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
