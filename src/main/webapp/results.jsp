<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <body background="${pageContext.request.contextPath}/assets/images/bg.jpg" >
        <header class="header">
            <div class="container">
                <div class="header__inner">
                    <div class="header__logo">Инвестиционный калькулятор</div>
                    <nav class="nav">
                        <a class="nav__link" href="description.html">Описание</a>
                        <a class="nav__link" href="Info.html">Над калькулятором работали</a>
                        <a class="nav__link" href="pdf" target="_blank">Сохранить в PDF</a>
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
                
    <br><label class="txt">${first_result}</label>
    <br><label class="txt_r">${second_result}</label>
    <br><label class="txt_r">Ставка: ${bank} %</label>
    <br><label class="txt_r">Период реинвестирования: ${period}</label>
    <br><label class="txt_r">${radio} : ${result}</label>
    <form action="perc" method="post">
<br><button type="submit" class="animate-gradient">Назад</button>
	</form>
            </div>
        </div>
    </body>
</html>