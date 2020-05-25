package com.erc.repositories;

import com.erc.domain.Category;
import com.erc.domain.Data;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Data, Integer> {

    Category findByName(String name);

}
