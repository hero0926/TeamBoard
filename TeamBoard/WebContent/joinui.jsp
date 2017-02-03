<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
<script type="text/javascript">
 
function checkfield(obj){
	
 var blank= /\s/;
 var isnull= null;
 if(blank.exec(obj.value)){ 
 alert("공백 사용 불가");
 obj.focues();
 obj.value = obj.value.replace(' ', '');
 return false;
 
 }
 
}


function isNull(){
	var form = document.form1;
	
	  if (form.id.value == "")
      {
              alert("아이디를 입력해야 합니다!");
              form.txtID.focus();
              return;
      }
	  else if (form.name.value == "")
      {
              alert("이름을 입력해야 합니다!");
              form.txtID.focus();
              return;
      }
	  else if (form.pw.value == "")
      {
              alert("비밀번호를 입력해야 합니다!");
              form.txtID.focus();//
              return;
      }
	
	  form.submit();
}
</script>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<%@ include file="header.jsp" %>

<body>
<h1>회원가입 페이지</h1>
<hr>
	<form action="join.do" name="form1"  method="post">
	
		ID : <input type="text" name="id" onkeyup="checkfield(this);" placeholder="아이디"><br><br>
		비밀번호 : <input type="password" name="pw" onkeyup="checkfield(this);" placeholder="비밀번호"><br><br>
		이름 : <input type="text" name="name" onkeyup="checkfield(this);" placeholder="이름"><Br><br>
		<br>
		<input type="button" value="회원가입" onclick="isNull();"/>
	</form>
	

<%@ include file="footer.jsp" %>
				
</body>
</html>