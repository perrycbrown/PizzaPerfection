package com.jwad.pizzaperfection.dao;

import java.util.List;

import com.jwad.pizzaperfection.domainmodel.PizzaElementImpl;

public interface PizzaElementDao {

	public void persist(PizzaElementImpl pizza);
	public PizzaElementImpl get(int pizzaId);
	public void update(PizzaElementImpl pizza);
	public void delete(PizzaElementImpl pizza);
	public List<PizzaElementImpl> list(int complete);

}
