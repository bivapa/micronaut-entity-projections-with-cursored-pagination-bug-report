package example;

import io.micronaut.data.model.CursoredPageable;
import io.micronaut.data.model.Sort;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.example.ExampleEntity;
import com.example.ExampleEntityRepository;

import org.junit.jupiter.api.BeforeAll;

import jakarta.inject.Inject;

@MicronautTest
@TestInstance(Lifecycle.PER_CLASS)
class EntityProjectionCursoredPaginationTest {
    @Inject
    ExampleEntityRepository repository;

    @BeforeAll
    void createEntity() {
        repository.save(new ExampleEntity(1));
    }

    @Test
    void cursoredPaginationWorksForEntity() {
        repository.findAll(CursoredPageable.from(Sort.UNSORTED));
    }

    @Test
    void cursoredPaginationWorksForEntityProjection() {
        repository.find(CursoredPageable.from(Sort.UNSORTED));
    }
}
