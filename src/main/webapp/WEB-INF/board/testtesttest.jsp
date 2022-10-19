<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    			<div class="section section3">
				<div class="slide" id="slide1">
					<div class="row">
						<div class="left"> 
							<h2>PROJECT1</h2>
							<p><a href="#"><img src="img/com.png" alt="모니터" width="550" /></a></p>
							<div class="inner">
								<a href="project/project1/index.html" class="hidden"><img src="img/project1.png" width="500" alt="web_main" /></a>
							</div>
                        </div>
                        <div class="right">
							<div class="txt_box">
								<h3>#1 경찰청</h3>
								<ul>
									<li>
										처음으로 HTML, CSS, JS를 사용하여 만든<br>웹페이지인 만큼 시행착오도 많고<br>수강 기간중 가장 힘들었던 작업이였지만,<br>그만큼 제가 한층 성장하는 것에 있어서<br>가장 중요하고 의미있는 프로젝트였습니다.
									</li>
									<li>-제작기간 : 총3주 소요</li>
									<li>-참여도 : 100%</li>
								</ul>
								<a href="project/project1/index.html">홈페이지<br>바로가기</a>
                            </div>
                        </div>
                    </div>
				</div><!-- #slide1 -->
				<div class="slide" id="slide2">
					<div class="row">
						<div class="left">
							<h2>PROJECT2</h2>
							<p><a href="#"><img src="img/com.png" alt="모니터" width="550" /></a></p>
							<div class="inner">
								<a href="project/project2/index.html" class="hidden"><img src="img/project2.png" width="500" alt="web_main" /></a>
							</div>
                        </div>
                        <div class="right">
							<div class="txt_box">
								<h3>#2 벤큐</h3>
								<ul>
									<li>
										두번째로 작업한 벤큐사이트이며, 처음 하였던 경찰청보다 좀 더 수월하게 구현이 가능했고 기간도 확실히 더짧게 끝났습니다. HTML CSS로 틀을 잡았고 media screen을 주사용하여 반응형 웹페이지를 만들었습니다
									</li>
									<li>-제작기간 : 4일</li>
									<li>-참여도 : 100%</li>
								</ul>
								<a href="project/project2/index.html">홈페이지<br>바로가기</a>
							</div>
                        </div>
                    </div>
				</div><!-- #slide2 -->
				<div class="slide" id="slide3">
					<div class="row">
						<div class="left">
							<h2>PROJECT3</h2>
							<p><a href="#"><img src="img/iphone.png" alt="휴대폰" width="550" height="570" /></a></p>
							<div class="inner">
								<a href="https://xd.adobe.com/view/85512a8c-07e3-4d03-8a74-85be7daa0aed-d002/" class="app"><img src="img/app.png" width="216" height="400" alt="web_main"/></a>
							</div>
                        </div>
                        <div class="right">
							<div class="txt_box">
								<h3>Mobile App 채끼라웃</h3>
								<ul>
									<li>
										팀작업으로 만들게 된 비건앱 채끼라웃입니다<br>채식인들을 위한 앱으로 주변식당, 채식스토어, 채식관련뉴스, 채식다이어리등등 다양한 기능으로 채식인들의 편의성을 갖게 해줄 앱이라고 생각합니다
									</li>
									<li>-제작기간 : 4주</li>
									<li>-참여도 : 100%</li>
								</ul>
								<a href="https://xd.adobe.com/view/85512a8c-07e3-4d03-8a74-85be7daa0aed-d002/">홈페이지<br>바로가기</a>
								<a href="project/plan_5team_final.pdf">기획서</a>
							</div>
                        </div>
                    </div>
				</div><!-- #slide3 -->
			</div>
			
<script type="text/javascript">
$(function () {
	var g_interval
	/* 시간 */
	const lapse = 10000

	$("#fullpage").fullpage({
		menu: "#menu",
		anchors: ["page1", "page2", "page3", "page4", "page5"],
		navigation: true,
		navigationPosition: "right",
		afterLoad: function (anchorLink, index) {
			if (anchorLink == "page1") {
				$(".section1").addClass("sectionIn")
			} else {
				$(".section1").removeClass("sectionIn")
			}

			if (anchorLink == "page4") {
				animateChart()
			}
		},
		//새로운 구역으로 이동하는 와중에 실행
		onLeave: function (origin, destination, direction) {
			if (destination > 1) {
				$(".page5").css("color", "#fff")
			} else {
				$(".page5").css("color", "#8fd8ca")
			}
			if (destination == 5) {
				$(".page5").css("color", "#8fd8ca")
			}
			if (destination > 1 && destination !== 4) {
				$("#menu>li").eq(3).addClass("on")
			} else {
				$("#menu>li").eq(3).removeClass("on")
			}
			if (destination == 3) {
				auto();
				function auto(){
					if ($(".fp-slides").length) {
						g_interval = setInterval(function () {
							$.fn.fullpage.moveSlideRight()
						}, lapse)
					}

				}
				$(".section3 .row").hover(
					function () {
						clearInterval(g_interval)
					},
					function () {
						auto()
					}
				)
			}

		},
	})
	$(".hidden").hover(
		function () {
			var ah = $(this).innerHeight()
			var img = $(this).find("img")
			var imgh = img.innerHeight()

			img.stop().animate({ top: ah - imgh }, 4000)
		},
		function () {
			var img = $(this).find("img")
			img.stop().animate({ top: 0 }, 3000)
		}
	)
	/* 슬라이드 자동넘기기 */

	/* skill */
	var chart = $(".chart")

	function animateChart() {
		chart.each(function () {
			var item = $(this)
			var title = item.find("h2")
			var targetNum = title.attr("data-num")
			var circle = item.find("circle")

			$({ rate: 0 }).animate(
				{ rate: targetNum },
				{
					duration: 6000,
					progress: function () {
						var now = this.rate
						var amount = 630 - (630 * now) / 100

						title.text(Math.floor(now))
						circle.css({ strokeDashoffset: amount })
					},
				}
			)
		}) //chart each
	}
})

</script>
    
