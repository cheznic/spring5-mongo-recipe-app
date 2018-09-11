package me.cheznic.learning.recipe.repositories.reactive;

import me.cheznic.learning.recipe.model.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryIT {

    @Autowired
    UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;

    @Before
    public void setUp() throws Exception {
        unitOfMeasureReactiveRepository.deleteAll().block();
    }

    @Test
    public void testSaveUom() throws Exception {

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription("cup");

        unitOfMeasureReactiveRepository.save(uom).block();

        Long count = unitOfMeasureReactiveRepository.count().block();

        assertEquals(Long.valueOf(1L), count);
    }

    @Test
    public void testFindByDescription() throws Exception {

        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription("cup");

        unitOfMeasureReactiveRepository.save(uom).block();

        UnitOfMeasure unitOfMeasure = unitOfMeasureReactiveRepository.findFirstByDescription("cup").block();

        assertNotNull(unitOfMeasure);
        assertEquals("cup", unitOfMeasure.getDescription());
    }
}