<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${employee.userName} page</title>
</head>
<body>

	<ul class="navbar">
		<li><a href="logout.ctc">logout</a></li>
		<li><a href="about.ctc">about</a></li>
	</ul>

	<h2>${employee.userName}page</h2>
	
	<div style="color:red;">${errMsg} </div>
	<form action="timeSheetProcess.ctc">
		<input type="hidden" name="username" value="${employee.userName}" />
		<input type="hidden" name="timeSheet" value="checkIn" />
		<table>
			<tr>
				<td><input type="submit" value="Check In" /></td>

			</tr>
		</table>
	</form>
	
	<form action="timeSheetProcess.ctc">
		<input type="hidden" name="username" value="${employee.userName}" />
		<input type="hidden" name="timeSheet" value="checkOut" />
		<table>
			<tr>
				<td><input type="submit" value="Check Out" /></td>

			</tr>
		</table>
	</form>

</body>
</html>