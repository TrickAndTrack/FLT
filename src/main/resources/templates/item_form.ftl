<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add/Edit Item</title>
</head>
<body>
    <h1>
        <#if item??>
            <#if item.id??>Edit<#else>Add</#if> Item
        <#else>
            Add Item
        </#if>
    </h1>
    <form action="/items/save" method="post">
        <#if item?? && item.id??>
            <input type="hidden" name="id" value="${item.id}">
        </#if>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${item.name!}" required>
        <br><br>
        <label for="price">Price:</label>
        <input type="number" step="0.01" id="price" name="price" value="${item.price!}" required>
        <br><br>
        <button type="submit">Save</button>
    </form>
    <br>
    <a href="/items">Back to List</a>
</body>
</html>
