<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/login.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/mainpage.css"> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 로그인</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

	    <!-- google font -->
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Jua&family=Noto+Sans+KR:wght@500&display=swap');
    </style>
</head>
<body style="background: none;">
	<div id="bgcolor" style="background-image: url(https://cdn.discordapp.com/attachments/692994434526085184/970185730959749120/34234234324.png);">
	<div>
		<%@ include file="../view/template_header.jsp"%>
	</div>
    <div id="j_loginform" style="margin-bottom: 80px;">
        <p><img id="j_logo_img" alt="지우동 로고" src="https://cdn.discordapp.com/attachments/958566133752016901/966263461803876422/22b75afde37f348d.png"></p>
        <form action="bumLogin.lo" method="post" name="loginFrm" onsubmit="return validateForm(this);">
            <div id="j_loginform2">
                <fieldset id="j_loginform3">
                    <legend style="color: #0f7bc3; float: none; font-size: large; font-weight: bolder; text-align: center; padding: 0 5px; width: 130px;">사업자 로그인</legend>
                    <div style="position: relative; height: 150px;">
							<div id="j_id_div" style="position: absolute; line-height: 30px; margin-top: 10px;">
								<label id="j_id" for="bu_id"
									style="display: inline- block; color: #0f7bc3;"><strong>아이디</strong></label>
								<input type="text" id="bu_id" name="bu_id"/><br />
							</div>
							<div id="j_pw_div" style="position: absolute; line-height: 30px; margin-top: 10px;">
								<label id="j_password" for="password"
									style="display: inline- block; color: #0f7bc3;"><strong>비밀번호</strong></label>
								<input type="password" id="password" name="password" /><br />
							</div>
						</div>
                </fieldset>
                <div id="j_loginform4">
                    <input type="submit" id="login_btn" value="로그인하기" /><br>
                </div>
            </div>
        </form>
    </div>
       	<footer style="margin-top: 0px; background-color: #001020; color: white;">
        <div id="p_main_bottom">
            <div id="p_bottom_left">
                <h3>지금 우리 동네는</h3>
                <h5>간편하고 쉬운, 실시간예약 사이트</h5>
                <p>
                    (주)지우동 | 서울 강남구 테헤란로 14길 6 남동빌딩 2층, 3층 (우)06234 | OWNER. 손은진 | 호스팅사업자 : 올때마스크써조<br>
                    TEL. 02)123-4567 | E-MAIL. <a
                        href="https://github.com/dms873/jiwoodong.git">https://github.com/dms873/jiwoodong.git</a><br>
                    JIWOODONG CO.2022 All rights reserved.<br>
                </p>
            </div>
            <div id="p_bottom_right">
                <h4>고객지원</h4>
                <p>고객센터 : <a href="#">6612-1867</a></p>
            </div>
        </div>
    </footer>
    </div>

  	<script>
    function validateForm(form) {
        if (!form.bu_id.value) {
            alert("아이디를 입력하세요.");
            form.bu_id.focus();
            return false;
        }
        if (form.password.value == "") {
        	form.password.focus();
            alert("패스워드를 입력하세요.");
            return false;
        }
    }
    </script>
</body>
</html>