<#include "include/header.ftl">
    <body>

    <div class="container">

        <!-- Static navbar -->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">TörökSoft Image Processing</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">List finished jobs</a></li>
                        <li><a href="/startNewJob">Send a new image for processing</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div><!--/.container-fluid -->
        </nav>

        <!-- Main component for a primary marketing message or call to action -->
        <div class="jumbotron">
            <h1>List of finished images</h1>
            <p>these are the images, which segmentation finished.</p>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Image name</th>
                        <th>Link</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1,001</td>
                        <td>Lorem</td>
                    </tr>
                    <tr>
                        <td>1,002</td>
                        <td>amet</td>
                    </tr>
                    <tr>
                        <td>1,003</td>
                        <td>Integer</td>
                    </tr>
                    <tr>
                        <td>1,003</td>
                        <td>libero</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
<#include "include/footer.ftl">