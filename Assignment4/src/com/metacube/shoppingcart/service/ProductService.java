
package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.model.Product;

/**
 * The Interface ProductService.
 */
public interface ProductService {

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	Iterable<Product> getAllProducts();

	/**
	 * Gets the product by id.
	 *
	 * @param id
	 *            the id
	 * @return the product by id
	 */
	Product getProductById(int id);

	/**
	 * Delete by id.
	 *
	 * @param id
	 *            the id
	 * @return the boolean
	 */
	Boolean deleteById(Integer id);

	/**
	 * Save.
	 *
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 * @param price
	 *            the price
	 * @return the product
	 */
	Product save(int id, String name, double price);

	/**
	 * Update.
	 *
	 * @param id
	 *            the id
	 * @param name
	 *            the name
	 * @param price
	 *            the price
	 * @return the product
	 */
	Product update(int id, String name, double price);
}
