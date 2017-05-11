 	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		  <!-- <script>
            window.onload = function() {
                var dropbox = document.getElementById("dropbox");
                dropbox.addEventListener("dragenter", noop, false);
                dropbox.addEventListener("dragexit", noop, false);
                dropbox.addEventListener("dragover", noop, false);
                dropbox.addEventListener("drop", dropUpload, false);
            }

            function noop(event) {
                event.stopPropagation();
                event.preventDefault();
            }

            function dropUpload(event) {
                noop(event);
                var files = event.dataTransfer.files;

                for (var i = 0; i < files.length; i++) {
                    upload(files[i]);
                }
            }

            function upload(file) {
                document.getElementById("status").innerHTML = "Uploading " + file.name;

                var formData = new FormData();
                formData.append("fileUpload", file);

                var xhr = new XMLHttpRequest();
                xhr.upload.addEventListener("progress", uploadProgress, false);
                xhr.addEventListener("load", uploadComplete, false);
                xhr.open("POST", "upload.html", true); // If async=false, then you'll miss progress bar support.
                xhr.send(formData);
            }

            function uploadProgress(event) {
                // Note: doesn't work with async=false.
                var progress = Math.round(event.loaded / event.total * 100);
                document.getElementById("status").innerHTML = "Progress " + progress + "%";
            }

             function uploadComplete(event) {
                document.getElementById("status").innerHTML = event.target.responseText;
            } 
        </script>
        <style>
            #dropbox {
                width: 300px;
                height: 50px;
                border: 1px solid gray;
                border-radius: 5px;
                padding: 5px;
                color: gray;
            }
        </style> -->
        
        <script src='/assets/dropzone/dropzone.js'></script>
	</head>
	
<body>

	<h1 align=center>File Management</h1> 
	
	
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-success" style="width=50%;">
			<div class="panel-heading">
				<h4 align=center class="panel-title">Select or Drop a New File</h4>
			</div>
      
			<div class="panel-body">
					<form method="post" action="upload.html" class="dropzone" enctype="multipart/form-data"  id="my-awesome-dropzone">
				<div >
					<div align=center>
						<input type="file" name="fileUpload" onchange="this.form.submit()"/>
					</div>
			
				</div>
					<div align=center>
					<!-- <input type="submit" value="Upload" /> -->
					</div>
				</form>
		</div>
	</div>
	</div>

	

	
	
	
	<div class="container" >
	<table class="table table-striped table-bordered" style="text-align= center; vertical-align:middle; ">
		<thead>
		<tr> <th> Name </th> <th> View </th> <th> Download </th> <th> Delete </th> <th> Rename File </th></tr></thead>
		<c:forEach items="${files}" var="file" > 
		<tbody> 
		<tr> <td align=center valign="middle">${file.name}</td> <td><a class="btn" href="upload/view.html?f=${file}" data-toggle="tooltip" title="Open"> <i class="glyphicon glyphicon-eye-open"></i></a></td> 
			 <td ><a class="btn" href="upload/download.html?f=${file}" data-toggle="tooltip" title="Download"> <i class="glyphicon glyphicon-open-file"></i></a></td>
			 <td ><a class="btn" href="upload/delete.html?f=${file}" data-toggle="tooltip" title="Delete"> <i class="glyphicon glyphicon-trash"></i> </a></td>
			 <td> 
			 <div align=center style="valign:middle;">
			 <form method="get" action="upload/edit.html" >
			 <input type="text" name="userName" />
			 <input type="hidden" value="${file}" name="fileName"/>
			 <input type="submit" value="Rename" />
			 </form>
			 </div>
			 </td>
			 </tr>
		</tbody>
		</c:forEach>
		</table>
		</div> 
		
			
	
</body>
</html> 