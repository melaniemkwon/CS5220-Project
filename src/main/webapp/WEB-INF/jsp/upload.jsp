<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>Spring MVC file upload example</h1>

<form method="POST" action="uploadX.html?qId=8" enctype="multipart/form-data">
    <div class="form-group">
	  <input type="file" name="file" multiple>
	  <input type="text" class="form-control" placeholder="Browse File" readonly>
	</div>
	<button type="submit" class="btn btn-raised btn-primary">Submit</button>
</form>

<table class="table">
<thead>
  <tr><th>Name</th><th>Date</th></tr>
</thead>
<tbody>  
  <tr id="row-5936636">
    <td><a href="/download?fileId=5936636">HW7.js</a></td>
    <td class="shrink">6.7 KB</td>
    <td class="datetime">2017-04-21 12:14:57</td>    
  </tr>
</tbody>
</table>
