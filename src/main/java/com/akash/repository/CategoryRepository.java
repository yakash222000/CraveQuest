package com.akash.repository;

import java.util.List;
import com.akash.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findByRestaurnatId(Long id);


}
