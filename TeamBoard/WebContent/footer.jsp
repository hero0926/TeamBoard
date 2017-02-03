<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
</head>    
 <body>   
    
<!-- footer start-->
		</td>
	</tr>
	<tr height="40">
		<td><img src="./img/team2.png" height="90" width="280"> </td>
		<td style="text-align:right;">2조 조원 구성<br>
		권영선&nbsp;&nbsp;&nbsp;
		강영욱&nbsp;&nbsp;&nbsp;
		고은혜&nbsp;&nbsp;&nbsp;
		김대환&nbsp;&nbsp;&nbsp;
		김설화
		</td>
		<td align="right" width="200" style="table-layout: fixed"><p id="realTimer"></p>

<script type="text/javascript">

function timer(){ 

	 var date = new Date(); 
	 var timeString = date .toLocaleTimeString(); 
	 return timeString; 
} 


function shigyeiswatch(){ 
	 document.getElementById( "realTimer" ).innerHTML = timer(); 
	 setTimeout( "shigyeiswatch()", 1000 ); 
}

var callFunction = shigyeiswatch(); 

</script>
</td>
		
	</tr>
</table>
</body>
</html>

<!-- footer end-->