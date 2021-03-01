<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello! Java laba #6:</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

</head>
<body>

<%
    String contextPath = request.getContextPath();

    // PageValues values = (PageValues) request.getAttribute("values");
    String scale = request.getParameter("scale");
    String figure_machine_name = request.getParameter("figure");
    String size_a = (String) request.getAttribute("size_a");
    String size_b = (String) request.getAttribute("size_b");
    String size_c = (String) request.getAttribute("size_c");
    String square = (String) request.getAttribute("square");
    String error = (String) request.getAttribute("error");
    String figure_name = (String) request.getAttribute("figure_name");
    String figure_scale = (String) request.getAttribute("figure_scale");

    String selectedCircle = (figure_machine_name != null && figure_machine_name.equals("circle")) ? "selected" : "";
    String selectedCone = (figure_machine_name != null && figure_machine_name.equals("cone")) ? "selected" : "";
    String selectedParallelepiped = (figure_machine_name != null && figure_machine_name.equals("parallelepiped")) ? "selected" : "";

%>
<div class="page">
    <div class="container">
        <div class="header>">
            <h1>Hello! Figure calculator</h1>

        </div>
        <div class="main">
            <div class="row">
                <div class="col-9">
                    <div id="form" class="form--figure">
                        <form action="<%= contextPath %>/figure" method="GET" enctype="multipart/form-data">

                            <div class="row">
                                <div class="edit-input mb-3 col">
                                    <label for="edit-size-a">Size A (or r)</label>
                                    <input id="edit-size-a"  required name="size_a" type="number" min="0" max="999999" step="0.000001" value="<%= size_a %>"/>
                                </div>
                                <div class="edit-input mb-3 col">
                                    <label for="edit-size-b">Size B (or h)</label>
                                    <input id="edit-size-b" required name="size_b" type="number" min="0" max="999999" step="0.000001" value="<%= size_b %>"/>
                                </div>
                                <div class="edit-input mb-3 col">
                                    <label for="edit-size-c">Size C</label>
                                    <input id="edit-size-c" required name="size_c" type="number" min="0" max="999999" step="0.000001" value="<%= size_c %>"/>
                                </div>
                            </div>
                            <div class="edit-input mb-3">
                                <label for="edit-scale">Scale</label>
                                <input id="edit-scale"  required name="scale" type="number" min="0" max="6" step="1" value="<%= scale %>"/>
                            </div>
                            <div class="edit-input mb-3">
                                <label for="edit-figure">Figure type</label>
                                <select id="edit-figure" name="figure" class="form-select" required aria-label="Select figure">
                                    <option <%= selectedCircle %> value="circle">Circle</option>
                                    <option <%= selectedCone %> value="cone">Cone</option>
                                    <option <%= selectedParallelepiped %> value="parallelepiped">Parallelepiped</option>
                                </select>
                            </div>

                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
                <div class="col-3">
                    <h2>Result:</h2>
                    <p>Full area of the figure  (<%= figure_name %>): S = <%= square %></p>
                    <p>Scale: <%= figure_scale %> </p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
