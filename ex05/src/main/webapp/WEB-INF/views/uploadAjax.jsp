<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Upload with Ajax</h1>
	
	 <div class="uploadDiv">
	 	<input type="file" name='uploadFile' multiple>
	 </div>
	 
	 <button id='uploadBtn'>Upload</button>
	 
	 <script src="https://code.jquery.com/jquery-3.3.1.min.js" 
	 integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" 
	 crossorigin="anonymous"></script>
	 
	 <script>
	 
	 $(document).ready(function(){
		 
		 
		 var regex = new RegExp("(.*?)\.(exe|sh|zip|arz)$");
		 var maxSize = 5242880; //5MB
		 
		 function checkExtension(fileName, fileSize) {
			 
			 if(fileSize >= maxSize){
				 alert("���� ������ �ʰ�");
				 return false;
			 }
			 
			 if(regex.test(fileName)){
				 alert("�ش� ������ ������ ���ε� �� �� �����ϴ�.");
				 return false;
			 }
			return true;
		 }
		 
		 $("#uploadBtn").on("click", function(e){
			 
			 var formData = new FormData();
			 var inputFile = $("input[name='uploadFile']");
			 var files = inputFile[0].files;
			 
			 console.log(files);
			 
			 //add filedata to formdata
			 for(var i = 0; i < files.length; i++){
				 
				 if(!checkExtension(files[i].name, files[i].size) ){
					 return false;
				 }
				 
				 formData.append("uploadFile", files[i]);
				 
			 }
			 
			 $.ajax({
				 url : '/uploadAjaxAction',
				 processData : false,
				 contentType : false,
				 data: formData,
				 type : 'POST',
				 dataType : 'json',
				 success : function(result){
					 //alert("Uploaded");
					 console.log(result);
				 }
			 }); //$.ajax

			 
		 });
	 });
	 
	 </script>
	 

</body>
</html>