<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" 
		pageEncoding="UTF-8" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>TestJEE Project</title>
</head>
<body>
<h3>Greeting from TestJEE Project</h3>
<p>${requestScope.Msg}</p>


<p><i><u>Tip</u>: specify a different language using <b>lang</b> parameter.
<br/>
&#160;Ex. <a href="/testJEE/?lang=uk">/testJEE/?lang=uk</a></i>
</p>

</body>
</html>
</jsp:root>
