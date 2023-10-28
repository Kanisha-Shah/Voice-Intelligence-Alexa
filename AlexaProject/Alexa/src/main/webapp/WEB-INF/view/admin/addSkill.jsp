<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Gleam Admin</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/vendors/css/vendor.bundle.base.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/adminResources/vendors/css/vendor.bundle.addons.css">
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
	   $("#addSkillForm").validate({
		      rules: {
		    	  skill: 'required',
		       },
			   messages: {
				   skill: '*This field is required'
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
      <div id="theme-settings" class="settings-panel">
        <i class="settings-close mdi mdi-close"></i>
        <p class="settings-heading">SIDEBAR SKINS</p>
        <div class="sidebar-bg-options selected" id="sidebar-default-theme"><div class="img-ss rounded-circle bg-light border mr-3"></div>Default</div>
        <div class="sidebar-bg-options" id="sidebar-dark-theme"><div class="img-ss rounded-circle bg-dark border mr-3"></div>Dark</div>
        <p class="settings-heading mt-2">HEADER SKINS</p>
        <div class="color-tiles mx-0 px-4">
          <div class="tiles primary"></div>
          <div class="tiles success"></div>
          <div class="tiles warning"></div>
          <div class="tiles danger"></div>
          <div class="tiles info"></div>
          <div class="tiles dark"></div>
          <div class="tiles default light"></div>
        </div>
      </div>
      <!-- partial -->
      <!-- partial:../../partials/_sidebar.html -->
<jsp:include page="menu.jsp"></jsp:include>

      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          <div class="page-header">
            <h3 class="page-title">
                Add Skill
            </h3>
          </div>
         
         
         
         
          <div class="row grid-margin">
            <div class="col-lg-12">
              <div class="card">
                <div class="card-body">
				<f:form action="saveSkill" method="post" modelAttribute="skillVO"
					id="addSkillForm">
                    <fieldset>
                      
                      <div class="form-group">
                        <label for="cname">Skill Name:</label>
                  		<f:input path="skillName" name="skill" id="" cssClass="form-control"/>
                      </div>
                      
                      <div class="form-group">
                        <label for="cemail">Skill Description</label>
                       	<f:textarea path="skillDescription" cssClass="form-control" id=""/>
                      </div>
                      <f:hidden path="skillId"/>
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
  <!-- End custom js for this page-->
</body>

</html>
    