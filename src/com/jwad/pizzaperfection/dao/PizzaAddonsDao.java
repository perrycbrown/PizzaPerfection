package com.jwad.pizzaperfection.dao;

import java.util.List;

import com.jwad.pizzaperfection.domainmodel.PizzaAddonsImpl;

public interface PizzaAddonsDao {

	public void persist(PizzaAddonsImpl addon);
	public PizzaAddonsImpl get(int addon);
	public void update(PizzaAddonsImpl addon);
	public void delete(PizzaAddonsImpl addon);
	public List<PizzaAddonsImpl> list();

}
