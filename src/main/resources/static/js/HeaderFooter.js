/**
 *  HeaderFooter.js
 *  헤더 푸터 HTML 코드
 */

const template = document.createElement('template');
template.innerHTML = `
<footer class="game-footer">
	    <div class="container">
	        <div class="footer-content">
	            <div class="row">
	                <div class="col-md-4">
	                    <h5 class="neon-text">ABOUT STEAM</h5>
	                    <ul class="footer-links">
	                        <li><a href="#">스토어 정보</a></li>
	                        <li><a href="#">커뮤니티</a></li>
	                        <li><a href="#">고객지원</a></li>
	                    </ul>
	                </div>
	                <div class="col-md-4">
	                    <h5 class="neon-text">QUICK LINKS</h5>
	                    <ul class="footer-links">
	                        <li><a href="#">인기 게임</a></li>
	                        <li><a href="#">신규 출시</a></li>
	                        <li><a href="#">특별 할인</a></li>
	                    </ul>
	                </div>
	                <div class="col-md-4">
	                    <h5 class="neon-text">FOLLOW US</h5>
	                    <div class="social-links">
	                        <a href="#" class="social-icon">Discord                      </a>|
	                        <a href="#" class="social-icon">Twitter                      </a>
	                        <a href="#" class="social-icon">YouTube</a>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="footer-bottom">
	            <p>© 2024 Steam. All rights reserved.</p>
	        </div>
	    </div>
	</footer>
	

`;

document.body.appendChild(template.content);