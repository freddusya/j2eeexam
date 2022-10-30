<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>J2EE Exam</title>
</head>
<body>
	<div style="text-align: center">
		<h2>
			Welcome to our J2EE Exam<br> <br>
		</h2>
		<h3>
			<a href="about.ctc">Click here to See About Page... </a>
		</h3>
		<h3>
			<a href="login.ctc">Click here to See Login Page... </a>
		</h3>
		
		
	</div>

	<h3>Welcome, Set Up Time Sheet Details</h3>
        <form action="<%=request.getContextPath()%>/setup.ctc">
             <table>
                <tr>
                    <td>Number of TeamLead</td>
                    <td></td>
                </tr>
                <tr>
                    <td>Number of Staff</td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>


</body>
</html>
