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
 alert("���� ��� �Ұ�");
 obj.focues();
 obj.value = obj.value.replace(' ', '');
 return false;
 
 }
 
}


function isNull(){
	var form = document.form1;
	  if (form.name.value == "")
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

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>ȸ������ �����ϱ�</h1>
<hr>
<form action="memberupdate.do" name="form1" method="post">
��й�ȣ �����ϱ� : 
<input name="pw" type="password">
<br>
�̸� �����ϱ� : 
<input name="name" type="text">
<input type="button" value="�����ϱ�" onclick="isNull();"/>

</form>

</body>
</html>
<%@ include file="footer.jsp" %>