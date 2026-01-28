package com.example.demo_blog_jpa.repository;

import com.example.demo_blog_jpa.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBlogRepository extends JpaRepository<Blog,Integer> {

    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    @Query(value = "select * from blogs where category_id = :searchCategory " +
            "and title like :searchTitle " +
            "order by create_blog desc",
            countQuery = "select count(*) from blogs " +
                    "where title like :searchTitle " +
                    "and category_id = :searchCategory",nativeQuery = true)
    Page<Blog> search(@Param("searchCategory")int categoryId,
                      @Param("searchTitle")String title,
                      Pageable pageable);
}
