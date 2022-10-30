<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here (action)</title>
</head>
<body>
<h1>${msg}</h1>

 <form action="<%=request.getContextPath()%>/timeSheet.ctc">
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
                    <td><input type="submit" value="Check In"/></td>
                    <td><input type="submit" value="Check Out"/></td>
                </tr>
            </table>
 </form>

</body>
</html>