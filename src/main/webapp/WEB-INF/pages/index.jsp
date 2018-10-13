<%--
  Created by IntelliJ IDEA.
  User: LYF
  Date: 2018/10/12
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- jstl:jstl1.2、javax.servlet:jstl1.2 无效？org.eclipse.jetty中没有-->
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>

<!-- jstl:jstl1.2、javax.servlet:jstl1.2、org.eclipse.jetty有效-->
<%--<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>--%>
<%--<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>--%>

<!-- jstl:jstl1.2、javax.servlet:jstl1.2、org.eclipse.jetty有效 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
     jetty
     <c:forEach items="${books}" var="book">
         <tr>
             <td>${book.bookId}</td>
             <td>${book.name}</td>
             <td>${book.number}</td>
             <td>详细</td>
         </tr>
     </c:forEach>
sdf
</body>
</html>
