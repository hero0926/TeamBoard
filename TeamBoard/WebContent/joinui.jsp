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
 alert("���� ��� �Ұ�");
 obj.focues();
 obj.value = obj.value.replace(' ', '');
 return false;
 
 }
 
}


function isNull(){
	var form = document.form1;
	
	  if (form.id.value == "")
      {
              alert("���̵� �Է��ؾ� �մϴ�!");
              form.txtID.focus();
              return;
      }
	  else if (form.name.value == "")
      {
              alert("�̸��� �Է��ؾ� �մϴ�!");
              form.txtID.focus();
              return;
      }
	  else if (form.pw.value == "")
      {
              alert("��й�ȣ�� �Է��ؾ� �մϴ�!");
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
<h1>ȸ������ ������</h1>
<hr>
	<form action="join.do" name="form1"  method="post">
	
		ID : <input type="text" name="id" onkeyup="checkfield(this);" placeholder="���̵�"><br><br>
		��й�ȣ : <input type="password" name="pw" onkeyup="checkfield(this);" placeholder="��й�ȣ"><br><br>
		�̸� : <input type="text" name="name" onkeyup="checkfield(this);" placeholder="�̸�"><Br><br>
		<br>
		<input type="button" value="ȸ������" onclick="isNull();"/>
	</form>
	

<%@ include file="footer.jsp" %>
				
</body>
</html>