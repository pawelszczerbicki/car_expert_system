<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <div id="intro" class="lead">
            <p>Take participation in our survey to let know what car is most appropriate one for you.</p>
            <br>
            <p class="text-center"><a id="btn-start-survey" class="btn btn-lg btn-primary" href="#" role="button">Start survey</a></p>
        </div>
        <div id="question" style="display: none;">
            <h4 id="question-title"></h4>
            <div id="question-body"></div>
            <p id="btn-next-question" class="text-right"><a class="btn btn-primary" href="#" role="button">Next question</a></p>
        </div>
        <%--<p class="pull-left text-left"><a class="btn btn-primary" href="#" role="button">Previous question</a></p>--%>
    </div>


    <div class="footer">
        <p>&copy; 2014 | Wojciech Kwiatek, Pawel Szczerbicki</p>
    </div>

</div> <!-- /container -->