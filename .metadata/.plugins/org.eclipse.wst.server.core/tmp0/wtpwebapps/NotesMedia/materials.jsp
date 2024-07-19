<!-- materials.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.example.dao.MaterialDao, com.example.model.Material" %>
<!DOCTYPE html>
<html>
<head>
    <title>Materials</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('images/resources.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: auto;
        }
        .container {
            background: rgba(255, 255, 255, 0.8);
            padding: 30px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            max-width: 1000px;
            width: 100%;
        }
        h1 {
            color: #333;
            margin-bottom: 20px;
        }
        .form-group {
            text-align: left;
        }
        .btn {
            margin-top: 10px;
        }
        .table {
            margin-top: 20px;
        }
        .search-box {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Materials</h1>
        <a href="logout" class="btn btn-danger btn-block">Logout</a>
        <form class="search-box">
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Search for materials..." id="searchInput">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="button" onclick="searchMaterials()">Search</button>
                </div>
            </div>
        </form>
        
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Filename</th>
                    <th>Upload Date</th>
                    <th>Download</th>
                </tr>
            </thead>
            <tbody id="materialsTable">
                <%
                    MaterialDao materialDao = new MaterialDao();
                    List<Material> materials = materialDao.getAllMaterials();
                    for (Material material : materials) {
                %>
                <tr>
                    <td><%= material.getTitle() %></td>
                    <td><%= material.getDescription() %></td>
                    <td><%= material.getFilename() %></td>
                    <td><%= material.getUploadDate() %></td>
                    <td><a href="uploads/<%= material.getFilename() %>" download>Download</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script>
        function searchMaterials() {
            let input = document.getElementById('searchInput').value.toLowerCase();
            let table = document.getElementById('materialsTable');
            let rows = table.getElementsByTagName('tr');
            for (let i = 0; i < rows.length; i++) {
                let title = rows[i].getElementsByTagName('td')[0].textContent.toLowerCase();
                let description = rows[i].getElementsByTagName('td')[1].textContent.toLowerCase();
                if (title.includes(input) || description.includes(input)) {
                    rows[i].style.display = '';
                } else {
                    rows[i].style.display = 'none';
                }
            }
        }
    </script>
</body>
</html>
