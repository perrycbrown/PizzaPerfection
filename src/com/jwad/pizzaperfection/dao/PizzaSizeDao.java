package com.jwad.pizzaperfection.dao;

import java.util.List;

import com.jwad.pizzaperfection.domainmodel.PizzaSizeImpl;

public interface PizzaSizeDao {

	public void persist(PizzaSizeImpl pizza);
	public PizzaSizeImpl get(int pizzaId);
	public void update(PizzaSizeImpl pizza);
	public void delete(PizzaSizeImpl pizza);
	public List<PizzaSizeImpl> list();

}
