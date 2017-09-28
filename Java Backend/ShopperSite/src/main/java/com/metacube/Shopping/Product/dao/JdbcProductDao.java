package com.metacube.Shopping.Product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.Shopping.Product.Model.Product;
import com.metacube.Shopping.dao.GenericJdbcDao;


public class JdbcProductDao extends GenericJdbcDao <Product, Integer> implements ProductDao
{

    @Override protected String getTableName()
    {
        return "Product";
    }

    @Override protected Product extractResultSetRow(final ResultSet resultSet)
    {
        Product product = new Product();

        try
        {
            product.setImageUrl(resultSet.getString("imageUrl"));
            product.setPrice(resultSet.getDouble("price"));
            product.setName(resultSet.getString("name"));
            product.setId(resultSet.getInt("id"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return product;
    }

    @Override protected String getPrimaryKeyColoumnName()
    {
        return "id";
    }

}

