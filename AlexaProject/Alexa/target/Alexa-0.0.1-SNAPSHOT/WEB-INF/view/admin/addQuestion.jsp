<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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

<script src="<%=request.getContextPath()%>/adminResources/js/jquery-1.11.2.min.js"></script>
<script src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.min.js"></script>
<script type="text/javascript">
	function showOptionInput(e){
		var quetype = e.options[e.selectedIndex].text;
		var optionDiv = document.getElementById("optionDiv");
		if(quetype == "M.C.Q."){
			optionDiv.style.display="";			
		}else{
			optionDiv.style.display="none";
		}
		
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		   $("#addQuestionForm").validate({
			      rules: {
			    	  question: 'required',
			    	  answer: 'required'
			       },
				   messages: {
					   question: '*This field is required',
					   answer: '*This field is required'
				   }
					
			    });
		});
</script>
</head>

<body>
	<div class="container-scroller">
		<!-- partial:../../partials/_navbar.html -->

		<!-- header part -->
		<jsp:include page="header.jsp"></jsp:include>


		<!-- partial -->
		<div class="container-fluid page-body-wrapper">

			<!-- partial -->
			<!-- partial:../../partials/_sidebar.html -->
			<!-- menu part -->
			<jsp:include page="menu.jsp"></jsp:include>

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="page-header">
						<h3 class="page-title">Add Question</h3>
					</div>
					<div class="row grid-margin">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title"></h4>
									<f:form action="saveQuestion" method="post"
										modelAttribute="questionVO" id="addQuestionForm">
										<fieldset>
											<div class="row">
												<div class="col">
													<div class="form-group">
														<label for="skill">Skill:</label>
														<f:select path="skillVO.skillId" cssClass="form-control"
															placeholder="Skill" id="skills"
															onchange="getQuestionTypeBySkillId()">
															<f:option value="0" selected="true" disabled="disabled">Type</f:option>
															<c:forEach items="${skillVOList}" var="i">
																<f:option value="${i.skillId}">${i.skillName}</f:option>
															</c:forEach>
														</f:select>
													</div>
												</div>

												<div class="col">
													<div class="form-group">
														<label for="form-Question-Type">Question Type:</label>
														<f:select id="questionTypeSelect"
															path="questionTypeVO.questionTypeId"
															cssClass="form-control" onchange="showOptionInput(this)">
															<option value="" disabled="true" selected="selected">Question
																Type</option>

															<%-- <c:forEach items="${questionTypeVOList}" var="i">
	
																</c:forEach> --%>

														</f:select>


														<!-- <select name="questionTypeId" class="form-control"
															id="questionType" onchange="showOptionInput(this)">
															<option value="" disabled="true" selected="selected">Question
																Type</option>
														</select> -->
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col">
													<div class="form-group">
														<label for="Question">Question:</label>
														<f:input name="question" path="question"
															cssClass="form-control" placeholder="Question" />
													</div>

												</div>

												<div class="col">
													<div class="form-group">
														<label for="answer">Answer:</label>
														<f:input path="answer" name="answer"
															cssClass="form-control" placeholder="Answer" />
													</div>

												</div>
											</div>

											<div id="optionDiv" style="display: none;">

												<label for="options">Options:</label>
												<div class="row">
													<div class="col">
														<div class="form-group">
															<f:input path="optionValue1" cssClass="form-control"
																placeholder="Option-1" />
														</div>
													</div>
													<div class="col">
														<div class="form-group">
															<f:input path="optionValue2" cssClass="form-control"
																placeholder="Option-2" />
														</div>
													</div>
													<div class="col">
														<div class="form-group">
															<f:input path="optionValue3" cssClass="form-control"
																placeholder="Option-3" />
														</div>
													</div>
													<div class="col">
														<div class="form-group">
															<f:input path="optionValue4" cssClass="form-control"
																placeholder="Option-4" />
														</div>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="col">
													<div class="form-group">
														<label for="questionDescription">Question
															Description</label>
														<f:textarea path="questionDescription"
															cssClass="form-control" id="" />
													</div>
												</div>
												<div class="col">
													<div class="form-group">
														<label for="answer">Answer Description:</label>
														<f:textarea path="answerDescription"
															cssClass="form-control" id="" />
													</div>
												</div>
											</div>

											<f:hidden path="questionId" />
											<input class="btn btn-primary" type="submit" value="Add">
										</fieldset>
									</f:form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->

				<!-- footer part -->
				<jsp:include page="footer.jsp"></jsp:include>


				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
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
	<script src="<%=request.getContextPath()%>/adminResources/js/form-validation.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/form-repeater.js"></script>
	<!-- <script src="<%=request.getContextPath()%>/adminResources/js/dropify.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/dropzone.js"></script>
	 -->
	<!-- End custom js for this page-->

	<script type="text/javascript">
	function getQuestionTypeBySkillId(){
		var questionType = document.getElementById("questionTypeSelect");		
		var skills = document.getElementById("skills");
		console.log("ajax is called"+skills.value);
		console.log(questionType);
		
		var htp = new XMLHttpRequest();

		htp.onreadystatechange = function() {

			if (htp.readyState == 4) {

				var jsn = JSON.parse(htp.responseText);
				
				if (jsn.length > 0) {
					
					questionType.innerHTML="";
		
					var opn = document.createElement("option");
					opn.text= "Select";
					questionType.options.add(opn);
					
					for(var i=0 ; i<jsn.length ; i++){
						
						
						var opn = document.createElement("option");
						opn.text = jsn[i].questionTypeName;
						opn.value = jsn[i].questionTypeId;
						
						questionType.options.add(opn);
						
					}
				}
			}
		}			
		htp.open("get", "getQuestionTypeBySkillId?skillId="+skills.value, true);
		htp.send();
		console.log("ajax is called"+skills.value);
	}			
	</script>


</body>

</html>
