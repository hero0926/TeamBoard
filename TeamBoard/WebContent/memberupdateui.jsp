<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>

<html>
<head>
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
	  if (form.name.value == "")
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

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보 수정하기</h1>
<hr>
<form action="memberupdate.do" name="form1" method="post">
비밀번호 변경하기 : 
<input name="pw" type="password">
<br>
이름 변경하기 : 
<input name="name" type="text">
<input type="button" value="수정하기" onclick="isNull();"/>

</form>

</body>
</html>
<%@ include file="footer.jsp" %>