<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">.
<meta name="viewport" content="width=device-width, initial-scale=1">
<section>
  <article>
    <h1>London</h1>
    <p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p>
    <p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p>
  </article>
</section>
<title><tiles:getAsString name="title" /></title>	<!-- tile.jsp에서 이름이 title인 것을 가지고 온다 -->
</head>
<body>
<tiles:insertAttribute name="header" />

<section>
  <tiles:insertAttribute name="menu" />
</section>
  
  <article>
<tiles:insertAttribute name="body" />
  </article>

	<div>	
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>