package com.example.luke.myapplication;

import junit.framework.Assert;

import org.junit.Test;

public class EqualsTest {

    class Sample{
        public int id;
        public String name;

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }

    @Test
    public void equalsTest() {
        Sample sampleA = new Sample();
        sampleA.id = 1;
        sampleA.name = "test";

        Sample sampleB = new Sample();
        sampleB.id = 1;
        sampleB.name = "test";

        System.out.println(sampleA.hashCode());
        System.out.println(sampleB.hashCode());
        Assert.assertFalse(sampleA.equals(sampleB));
    }

    @Test
    public void equalsTest2() {
        Sample sampleA = new Sample();
        sampleA.id = 1;
        sampleA.name = "test";

        Sample sampleB = new Sample();
        sampleB.id = 1;
        sampleB.name = "test";

        System.out.println(sampleA.hashCode());
        System.out.println(sampleB.hashCode());
        Assert.assertFalse(sampleA == sampleB);
    }

    @Test
    public void equalsTest3() {
        Sample sampleA = new Sample();
        sampleA.id = 1;
        sampleA.name = "test";

        Sample sampleB = new Sample();
        sampleB.id = 1;
        sampleB.name = "test";

        System.out.println(sampleA.hashCode());
        System.out.println(sampleB.hashCode());
        Assert.assertTrue(sampleA.name.equals(sampleB.name));
    }

    @Test
    public void equalsTest4() {
        Sample sampleA = new Sample();
        sampleA.id = 1;
        sampleA.name = "test";

        Sample sampleB = new Sample();
        sampleB.id = 1;
        sampleB.name = "test";

        System.out.println(sampleA.hashCode());
        System.out.println(sampleB.hashCode());
        Assert.assertTrue(sampleA.id == sampleB.id);
    }
}
