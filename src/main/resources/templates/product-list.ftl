<!DOCTYPE html>
<html>
<head><title>Product List</title></head>
<body>
    <h1>Product List</h1>
    <a href="/products/create">Create New Product</a>
    <form action="/products/filter" method="get">
        <input type="text" name="name" placeholder="Filter by name">
        <button type="submit">Filter</button>
    </form>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <#if products?? && products?size > 0>
                <#list products as product>
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price?string["0.00"]}</td>
                        <td>
                            <a href="/products/edit/${product.id}">Edit</a> |
                            <a href="/products/delete/${product.id}" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
                        </td>
                    </tr>
                </#list>
            <#else>
                <tr>
                    <td colspan="5">No products found.</td>
                </tr>
            </#if>
        </tbody>
    </table>
</body>
</html>
