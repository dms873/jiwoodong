<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header style="margin-top: 10px;">
        <div id="p_main_top" style="width: 1200px; margin: 0 auto; border-bottom: 2px solid silver;">
            <div style="float: right;">
                <p style="font-size: 10px; margin: 25px 30px 0 10px;">환영합니다 손은진님</p>
                <a href=""
                    style="font-size: 14px; margin: 0 0 0 30px; color: red; font-weight: bold; text-decoration: none;">로그아웃</a>
            </div>
            <div id="p_top_logo" style="float: left; margin: 0 0 0 30px;">
                <a href="http://localhost:8090/jwd/AdminMainPage"><img
                        src="https://cdn.discordapp.com/attachments/958566133752016901/966263461803876422/22b75afde37f348d.png"
                        width="80px" alt="logo" id="logo"></a>
            </div>
            <div style="float: left; margin: 15px 0 0 0;">
                <nav class="navbar navbar-expand-lg">
                    <div class="container-fluid">
                        <div class="collapse navbar-collapse">
                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">
                                    <a href="#" class="nav-link" id="s_notice_menu" role="button"
                                        data-bs-toggle="dropdown">
                                        공지사항 관리
                                    </a>
                                </li>
                            </ul>
                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown dropdown-toggle" href="#" role="button"
                                        data-bs-toggle="dropdown">
                                        사업자관리
                                    </a>
                                    <ul class="dropdown-menu dropdown-menu">
                                        <li><a class="dropdown-item" href="#" id="s_bu_accept_menu">업체 승인</a></li>
                                        <li>
                                            <hr class="dropdown-divider">
                                        </li>
                                        <li><a class="dropdown-item" href="#" id="s_bu_info_menu">사업자 정보 조회</a></li>
                                    </ul>
                                </li>
                            </ul>
                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown" href="#" role="button" id="s_us_info_menu">
                                        사용자관리
                                    </a>
                                </li>
                            </ul>
                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">
                                    <a class="nav-link" href="#" role="button" data-bs-toggle="dropdown"
                                        id="s_review_menu">
                                        리뷰관리
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div style="float: right; margin-top: 10px;">
                <div style="text-align: center;">
                    <img src="https://media.discordapp.net/attachments/692994434526085184/965630874999730296/1.png"
                        alt="프사" width="60px">
                </div>
            </div>
            <div style="clear: both;"></div>
        </div>
    </header>
</body>
</html>