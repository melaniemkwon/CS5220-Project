<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="items" required="true" type="java.util.Collection"%>
<%@ attribute name="targe" required="true" type="java.lang.Object"%>
<%@ tag body-content="scriptless"%>

<c:set var="contains" value="false" />
<c:forEach var="item" items="${items }">
  <c:if test="${item eq target}">
    <c:set var="contains" value="true" />
  </c:if>
</c:forEach>

