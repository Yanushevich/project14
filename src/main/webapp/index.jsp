<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="assets/css/style.css">  
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Farro&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed&display=swap" rel="stylesheet">

<style><%@include file="/assets/css/style.css"%></style>

    <title> Инвестиционный калькулятор </title>
</head>
    <body background=”/assets/images/background.jpg”>
        <header class="header">
            <div class="container">
                <div class="header__inner">
                    <div class="header__logo">Инвестиционный калькулятор</div>
                    <nav class="nav">
                        <a class="nav__link_a" href="admin.html">Администраторский доступ</a>
                        <a class="nav__link" href="description.html">Описание</a>
                        <a class="nav__link" href="Info.html">Над калькулятором работали</a>
                        <a class="nav__link" href="#">Сохранить в PDF</a>
                    </nav>
                </div>
            </div>
        </header>
        <div class="intro">
            <div class="container">
                <script type="text/javascript">
function getDate()
{
    var date = new Date();
    var month = date.getMonth()+1;
    var year = date.getFullYear();
    var days = date.getDate();
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var seconds = date.getSeconds();
    //Добавляем нули для привычного вида даты и времени
    if(seconds < 10){seconds = '0' + seconds;}
    if(days < 10){days = '0' + days;}
    if(month < 10){month = '0' + month;}
    if(minutes < 10){minutes = '0' + minutes;}
    document.getElementById('timedisplay').innerHTML = 'Текущее время и дата: ' + days + '.' + month + '.' + year + ' ' + hours + ':' + minutes + ':' + seconds;
}
setInterval(getDate, 0);
</script>

                <div class="marquee"><span><div id="timedisplay"></div></span></div>
                
				
				
  <form action="calc" method="post">
	
  <label class="txt">Выберите то, что хотите рассчитать:</label>
  <br>

    <div class="b-radio" id="calc" role="group" aria-label="Basic radio toggle button group">

		<label >
            <input type="radio" name="radio" id="btnradio1" data-show="a" value="a" autocomplete="off">
            <span>Доход</span>
        </label>

		<label >
            <input type="radio" name="radio" id="btnradio2" data-show="b" value="b" autocomplete="off">
            <span>Стартовый капитал</span>
        </label>
        
		<label >
            <input type="radio" name="radio" id="btnradio3" data-show="c" value="c" autocomplete="off">
            <span>Срок достижения</span>
        </label>
	
  </div>  
  
  <script type="text/javascript">
  
  const desc1 = {
	a: 'Стартовый капитал',
	b: 'Ваша цель',
	c: 'Ваша цель'
	}
	
  const desc2 = {
	a: 'Срок инвестирования',
	b: 'Срок инвестирования',
	c: 'Стартовый капитал'
	}
	
	calc.addEventListener('change', function(evt){
	let descId = evt.target.dataset.show
	disp1.innerHTML = desc1[descId]
	disp2.innerHTML = desc2[descId]
	})
  
  </script>
  
    <div id="disp1"></div>
    <input type="text" class="textbox" name="Text1" aria-describedby="basic-addon1">
  
    <div id="disp2"></div>  
    <input type="text" class="textbox" name="Text2" aria-describedby="basic-addon2">
  
  
    <div class="calc-frow">
        <div>Банк</div>
        <div>
            <div>
                <select name="bank">
                    <option value="1" selected>Сбербанк (1 %) </option>
                    <option value="2" >ВТБ (2 %)</option>
                    <option value="3" >Газпромбанк (3 %)</option>
                    <option value="4" >Альфа-Банк (4 %)</option>
                    <option value="5" >Тинькофф (5 %)</option>
                </select>
            </div>
        </div>
    </div>
 
  <div class="calc-frow">
        <div class="calc-fleft">Период реинвестирования</div>
        <div class="calc-fright">
            <div class="calc-input">
                <select name="period" class="calc-inp">
                    <option value="0" >Не реинвестировать</option>
                    <option value="12" selected>1 раз в месяц</option>
                    <option value="3" >1 раз в квартал</option>
                    <option value="2" >1 раз в полгода</option>
                    <option value="1" >1 раз в год</option>
                </select>
            </div>
        </div>
    </div>

                   <button type="submit" class="animate-gradient">Посчитать</button>
                </form>
            </div>
        </div>
    </body>
</html>