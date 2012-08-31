package org.springframework.beans;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Andy Caine
 */
public class MyBeanWrapperTest {

    @Test
    public void test() throws Exception {
        TestObject testObject = new TestObject();
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(testObject);
        beanWrapper.setAutoGrowNestedPaths(true);

        beanWrapper.setPropertyValue("items[0].name", "bob");

        assertEquals(1, testObject.getItems().size());
    }

    private static class Parent<T> {

        protected List<T> items = new ArrayList<T>();

        public List<T> getItems() {
            return items;
        }

        public void setItems(List<T> items) {
            this.items = items;
        }
    }

    public static class TestObject extends Parent<Dependent> {

        /*@Override
        public List<Dependent> getItems() {
            return super.getItems();
        }

        @Override
        public void setItems(List<Dependent> items) {
            super.setItems(items);
        }*/
    }

    public static class Dependent {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
