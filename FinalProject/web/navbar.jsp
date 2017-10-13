<%@include file="session_nocheck.jsp" %>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="UserController?action=home"><span class="glyphicon glyphicon-home"> Home</a>
    </div>
      
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
         <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-folder-open"> Items
            <span class="caret"></span></a>
            <ul class="dropdown-menu">
                 <li><a href="UserController?action=useritems">My Items</a></li><br>
                 <li><a href="add_item.jsp">Add Item</a></li>
            </ul>
            </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
          
          <li><a href="UserController?action=cart"><span class="glyphicon glyphicon-shopping-cart"> Cart</a></li>
          <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-user"> ${user.name}
                <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="settings.jsp"><span class="glyphicon glyphicon-cog"> Settings</a></li><br>
                  <li><a href="UserController?action=logout"><span class="glyphicon glyphicon-off"> Logout</a></li>
                </ul>
            </li>
        
      </ul>
    </div>
  </div>
</nav>