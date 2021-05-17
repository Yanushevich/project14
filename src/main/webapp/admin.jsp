<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Администраторская</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" 
	crossorigin="anonymous">


</head>
    <div class="container-fluid">
	<div class="row">
	<div 
	class="col-12 bg-dark text-light d-flex justify-content-center align-items-center"
	style="height: 100vh">
  
		        <form action="admin2" method="post">
		        
		          <div class="form-group">
		          
				    <label>Банк</label>
				    <select required name="bank">
                    <option value="1" selected>Сбербанк: ${perc1}%</option>
                    <option value="2" >ВТБ: ${perc2}%</option>
                    <option value="3" >Газпромбанк: ${perc3}%</option>
                    <option value="4" >Альфа-Банк: ${perc4}%</option>
                    <option value="5" >Тинькофф: ${perc5}%</option>
                </select>
				  </div>
				  <div class="form-group">
				  
				    <label>Процент</label>
				    <input 
				    	type="text" name="percent" class="form-control">
				  </div>
  
  				<button type="submit" class="btn btn-primary">Изменить</button>
			    
			    
		       </form>                
             
             </div>
             </div>
             </div>
            
    </body>
</html>