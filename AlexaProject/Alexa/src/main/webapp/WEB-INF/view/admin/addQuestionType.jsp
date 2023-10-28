<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/adminResources/images/favicon.png" />
<script src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	   $("#addQuestionTypeForm").validate({
		      rules: {
		    	  
		    	  questionType: 'required'
		       },
		       
			   messages: {
				  
				   questionType: '*This field is required'
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
			<!-- partial:../../partials/_settings-panel.html -->
			<div id="settings-trigger">
				<i class="mdi mdi-format-color-fill"></i>
			</div>
			
			<!-- partial -->
			<!-- partial:../../partials/_sidebar.html -->
			<!-- menu part -->
			<jsp:include page="menu.jsp"></jsp:include>

			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="page-header">
						<h3 class="page-title">Add Question Type</h3>
					</div>
					<div class="row grid-margin">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<f:form action="saveQuestionType" method="post"
										modelAttribute="questionTypeVO"
										id="addQuestionTypeForm">
										<fieldset>
											<div class="form-group">
							           			<label for="exampleFormControlSelect2">Skill:</label>
							                    <f:select path="skillVO.skillId" cssClass="form-control" id="exampleFormControlSelect2"
							                    		name="skill">  
							                      <c:forEach items="${skillVOList}" var="i">
							                      
							                      	<f:option value="${i.skillId}">${i.skillName}</f:option>
							                      </c:forEach>
							                    </f:select>
							                </div>
											<div class="form-group">
												<label for="cname">Question Type Name:</label>
												<f:input path="questionTypeName" cssClass="form-control" name="questionType"/>
											</div>

											<div class="form-group">
												<label for="cemail">Question Type Description</label>
												<f:textarea path="questionTypeDescription" cssClass="form-control"
													id="" />
											</div>
											<f:hidden path="questionTypeId" />
											<input class="btn btn-primary" type="submit" value="Submit">
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
	<script type="text/javascript">
	</script>
	<!-- End custom js for this page-->
</body>

</html>
