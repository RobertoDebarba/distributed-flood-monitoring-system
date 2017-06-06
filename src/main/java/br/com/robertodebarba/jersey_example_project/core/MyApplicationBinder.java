package br.com.robertodebarba.jersey_example_project.core;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import br.com.robertodebarba.jersey_example_project.api.product.ProductDAO;

public class MyApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(ProductDAO.class).to(ProductDAO.class);
	}

}