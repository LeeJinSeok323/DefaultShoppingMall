/**
 *  header.js
 */
class CustomHeader extends HTMLElement{
	connectedCallback(){
		let auth = sessionStorage.getItem("auth");
		
		let html = `
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		        <div class="container">
		            <a class="navbar-brand" href="/">Default Shopping Mall</a>
		            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
		                <span class="navbar-toggler-icon"></span>
		            </button>
		            <div class="collapse navbar-collapse" id="navbarResponsive">
		                <ul class="navbar-nav ml-auto">
		                    <li class="nav-item" th:if="${auth == null}">
		                        <a class="nav-link" href="/login/">로그인</a>
		                    </li>
		                    <th:block th:if="${auth != null}">
			                    <li class="nav-item">
			                        <a class="nav-link" href="/login/logout">로그아웃</a>
			                    </li>
			                    <!-- 직원 네비게이션 바 -->
			                    <li class="nav-item"  th:if="${auth == 'emp'}">
			                        <a class="nav-link" href="/user1/list" >관리자페이지</a>
			                    </li>
			                    <!-- 회원 네이게이션 바 -->
			                    <li class="nav-item" th:if="${auth == 'mem'}">
			                        <a class="nav-link" href="#">장바구니</a>
			                    </li>
		                </ul>
		            </div>
		        </div>
		    </nav>
			`
		let content = document.createElement(html);
		this.appendChild(content);
	}
}

customElements.define("navigation-bar", CustomHeader);
