package com.example;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.CursoredPage;
import io.micronaut.data.model.CursoredPageable;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.GenericRepository;

@JdbcRepository(dialect = Dialect.H2, dataSource = "default")
public interface ExampleEntityRepository extends GenericRepository<ExampleEntity, Integer> {
    void save(ExampleEntity entity);
    CursoredPage<ExampleEntity> findAll(CursoredPageable cursoredPageable);
    CursoredPage<ExampleEntityProjection> find(CursoredPageable cursoredPageable);
}