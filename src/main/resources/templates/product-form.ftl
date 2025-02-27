<!DOCTYPE html>
<html>
<title>${(product.id)?? then("Edit Product", "Create New Product")}</title>

<body>
    <h1>${(product.id)???string("Edit Product", "Create New Product")}</h1>

    <form action="/products/save" method="post">
        <input type="hidden" name="id" value="${product.id!''}"/>

        <label>Name:</label>
        <input type="text" name="name" value="${product.name!}" required/><br>

        <label>Description:</label>
        <input type="text" name="description" value="${product.description!}" required/><br>

        <label>Price:</label>
        <input type="number" step="0.01" name="price" value="${product.price!}" required/><br>

        <button type="submit">Save</button>
    </form>

    <a href="/products">Back to Product List</a>
</body>
</html>
