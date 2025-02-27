<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Item List</title>
</head>
<body>
    <h1>Item List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <#if items?? && items?size gt 0>
            <#list items as item>
                <tr>
                    <td>${(item.id)!'N/A'}</td>  <!-- Use default value if item.id is null -->
                    <td>${item.name!''}</td>
                    <td>${item.price!'0.00'}</td>
                    <td>
                        <a href="/items/edit/${(item.id)!}">Edit</a>
                        <a href="/items/delete/${(item.id)!}" onclick="return confirm('Are you sure?');">Delete</a>
                    </td>
                </tr>
            </#list>

        <#else>
            <tr><td colspan="4">No items available.</td></tr>
        </#if>
    </table>
    <br>
    <a href="/items/new">Add New Item</a> |
    <a href="/home">Back to Home</a>
</body>
</html>
