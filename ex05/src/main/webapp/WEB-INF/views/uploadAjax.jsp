<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

	 
	 <style>
	 
	 .uploadResult {
	 	width : 100%;
	 	background-color: gray;
	 }
	 
	 .uploadResult ul{
	 	display: flex;
	 	flex-flow: row;
	 	justify-content: center;
	 	align-items: center;
	 }
	 
	 .uploadResult ul li {
	 	list-style: none;
	 	padding: 10px;
	 }
	 
	 .uploadResult ul li img{
	 	width: 20px;
	 }
	 
	</style>

</head>
<body>
	
	<h1>Upload with Ajax</h1>
	
	 <div class="uploadDiv">
	 	<input type="file" name='uploadFile' multiple>
	 </div>
	 
	 <div class="uploadResult">
	 	<ul>
	 	
	 	</ul>
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
		 
		 //������ó��
		 var cloneObj = $(".uploadDiv").clone();
		 
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
			 
			 
			 var uploadResult = $(".uploadResult ul");
			 
			 function showUploadedFile(uploadResultArr) {
				 
				 var str = "";
				 
				 $(uploadResultArr).each(function(i, obj) {
					 
					 if(!obj.image) {
						str += "<li><img src = 'resources/img/attach.png'>" + obj.fileName + "</li>";		
					 } else {
						 //str += "<li>" + obj.fileName + "</li>";
						 
						 var fileCallPath = encodeURIComponent( obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
						 
						 str += "<li><img src='/display?fileName=" +fileCallPath+ "'></li>"
					 }
			 	});
				 
			 	uploadResult.append(str);
			 	
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
					 
					 showUploadedFile(result);
					 
					 $(".uploadDiv").html(cloneObj.html());
				 }
			 }); //$.ajax

			 
		 });
	 });
	 
	 </script>
	 

</body>
</html>