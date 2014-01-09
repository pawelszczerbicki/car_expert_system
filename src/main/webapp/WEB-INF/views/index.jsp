<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Car purchase assistant</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="<c:url value='/'/>">Main</a></li>
                <li><a href="<c:url value='/knowledge'/>">Knowledge</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container container-narrow">

    <h1 class="text-center">Car purchase assistance</h1>
    <div class="jumbotron">
        <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.
        </p>
        <p class="pull-left text-left"><a class="btn btn-primary" href="#" role="button">Previous question</a></p>
        <p class="text-right"><a class="btn btn-primary" href="#" role="button">Next question</a></p>
    </div>


    <div class="footer">
        <p>&copy; 2014 | Wojciech Kwiatek, Pawel Szczerbicki</p>
    </div>

</div> <!-- /container -->