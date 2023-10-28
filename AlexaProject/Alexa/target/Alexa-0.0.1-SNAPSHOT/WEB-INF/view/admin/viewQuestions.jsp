<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Gleam Admin</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/favicon.png" />
</head>

<body>
	<div class="container-scroller">
		<!-- partial:../../partials/_navbar.html -->

		<!-- header part -->
		<jsp:include page="header.jsp"></jsp:include>



		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:../../partials/_settings-panel.html -->

			<!-- partial -->
			<!-- partial:../../partials/_sidebar.html -->

			<!-- menu bar -->
			<jsp:include page="menu.jsp"></jsp:include>

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="page-header">
						<h3 class="page-title">Questions</h3>

					</div>

					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr role="row">
													<th>Sr.</th>
													<th>Skill</th>
													<th>Question Type</th>
													<th>Question</th>
													<th>Answer</th>
													<th>Description</th>
													<th>Actions</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${questionVOList}" var="i" varStatus="j">
													<tr>
														<td>${j.count}</td>
														<td>${i.skillVO.skillName}</td>
														<td>${i.questionTypeVO.questionTypeName}</td>
														<td>${i.question}</td>
														<td>${i.answer}</td>
														<td><i class="mdi mdi-alert-circle-outline"
															data-toggle="modal" data-target="#exampleModal"
															onclick="getTheQuestionDetails(${i.questionId})"> </i></td>
												
												
												
														<td><a href="editQuestion?id=${i.questionId}"><i
																class="mdi mdi-pencil lead"></i> </a> <a
															href="deleteQuestion?id=${i.questionId}"><i
																class="mdi mdi-delete text-danger lead ml-2"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- content-wrapper ends -->
		<!-- partial:../../partials/_footer.html -->

		<!-- footer part -->
		<jsp:include page="footer.jsp"></jsp:include>


		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<table border="1px" class="table">

							<tr>
								<th>Question Type:</th>
								<td id="questionType"></td>
							</tr>
							<tr>
								<th>Question:</th>
								<td id="question"></td>
							</tr>
							<tr>
								<th>Description:</th>
								<td id="qestionDescription"></td>
							</tr>
							<tr>
								<th>Options</th>
								<td id="options"></td>
							</tr>
							<tr>
								<th>Answer:</th>
								<td id="answer"></td>
							</tr>
							<tr>
								<th>Description:</th>
								<td id="answerDescriptions"></td>
							</tr>
						</table>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-light" data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>



		<!-- partial -->
	</div>
	<!-- main-panel ends -->
	</div>
	<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->

	<!-- models -->
	<!-- plugins:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/jquery-1.11.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/misc.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="<%=request.getContextPath()%>/adminResources/js/data-table.js"></script>
	<!-- End custom js for this page-->
	
	<script type="text/javascript">
	function getTheQuestionDetails(questionId){

			var questionType = document.getElementById("questionType");
			var question = document.getElementById("question");
			var qestionDescription = document.getElementById("qestionDescription");
			var answer = document.getElementById("answer");
			var answerDescriptions = document.getElementById("answerDescriptions");
			var options = document.getElementById("options");
			
			var htp = new XMLHttpRequest();

			htp.onreadystatechange = function() {

				if (htp.readyState == 4) {

					var jsn = JSON.parse(htp.responseText);
					
					if (jsn.length > 0) {

 						var data = jsn[0];
 
 						questionType.innerHTML= data.questionTypeVO.questionTypeName;
						question.innerHTML= data.question;
						qestionDescription.innerHTML= data.questionDescription;
						if(data.optionValue1 != ""){
							options.innerHTML='<b>1)</b> '+data.optionValue1+'  <b>2)</b> '+data.optionValue2+'  <b>3)</b> '+data.optionValue3+'  <b>4)</b> '+data.optionValue4;
						}else{
							options.innerHTML="--";
						} 
 						answer.innerHTML= data.answer;
						answerDescriptions.innerHTML = data.answerDescription;

					}
				}
			}

			htp.open("get", "getQuestionDetails?questionId="+questionId, true);
			htp.send();
	}
	</script>
</body>

</html>
