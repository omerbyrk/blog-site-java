<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</div>
          </section>
        </main>

        <nav id="sidebar-right" class="sidebar col-3 col-lg-2 bg-faded sidebar-right custom-hidden-sm-down bg-inverse text-white m-0">
          <div class="sidebar-content d-flex flex-column p-1 max-height">
            <h5><i class="fa fa-bars mt-2" aria-hidden="true"></i> Kategoriler</h5>
            <div class="category-list" id="category-list">
              <c:forEach items="${categoryList}" var="category">
              	<a href="category/${category.name}" class="button button-block button-rounded button-3d button-small mt-3 text-capitalize text-left pl-3"><i class="fa fa-folder-o" aria-hidden="true"></i> ${category.name}</a>
              </c:forEach>
            </div>
            <h6><i class="fa fa-tags mt-5" aria-hidden="true"></i> Etiketler</h6>
            <div class="tag-list">
              <c:forEach items="${tagList}" var="tag">
              	<a href="tag/${tag.name}" class="button button-rounded button-tiny px-2 mt-1 cursorable">${tag.name}<small>(${tag.totalBlog})</small></a>
              </c:forEach>
            </div>
          </div>
        </nav>
      </div>
    </div>
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha256-eZrrJcwDc/3uDhsdt61sL2oOBY362qM3lon1gyExkL0=" crossorigin="anonymous" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Buttons/1.1.1/css/buttons.css" />
	
    <!-- Bootstrap core JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <script src="resources/js/template.js"></script>
  </body>
</html>