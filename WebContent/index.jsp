<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="pl">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <div class="row>">
    <div class="col-md-2">
    </div>
    <div class="col-md-8">

  <h2>Kalkulator walut</h2>
  
  <form method="post" action="./main">
    <div class="form-group ">
      <br/>
      <h4>Wprowadź kwotę:</h4>
       <input  type="number"  class="form-control" name="ilosc">
       <br/>
      <label for="sel1">Przelicz z:</label>
	  <input list="browsers" class="form-control"  name="browser" >
	  <datalist id="browsers">
      <select class="form-control" id="sel1">
        <option >PLN</option>
        <option>EUR</option>
        <option>DOL</option>
        <option>CHF</option>
        <option value="CAD">CAD</option>
        <option value="GBP">GBP</option>
        <option value="JPY">JPY</option>
		<option value="AUD">AUD</option>  
		<option value="CZK">CZK</option>
		<option value="UAH">UAH</option>      
      </select>
	  </datalist>
	  </input>
      <br>
      
    </div>
    <br/>
      
  
    <div class="form-group">
      <label for="sel1">Przelicz na:</label>
	  <input list="browsers2" class="form-control"  name="browser2" >
  		<datalist id="browsers2" >
      <select class="form-control" id="sel1">
        <option value="EUR">EUR</option>
        <option value="PLN">PLN</option>
        <option value="DOL">DOL</option>
        <option value="CHF">CHF</option>
        <option value="CAD">CAD</option>
        <option value="GBP">GBP</option>
        <option value="JPY">JPY</option>
		<option value="AUD">AUD</option>  
		<option value="CZK">CZK</option>
		<option value="UAH">UAH</option>      
      </select>
	  </datalist>
	  </input>
      <br/>
	  <input type="submit" class="btn btn-info" value="Przelicz">
      
    </div>
  </form>
  <br/>
   <h1>${requestScope.ilosc} ${requestScope.walP}</h1>
 <h1> ${requestScope.wartosc } ${requestScope.waluta } </h1>
 <h1>${requestScope.error }</h1>
      </div>
      <div class="col-md-2">
    </div>
    </div>
  </div>


</body>
</html>