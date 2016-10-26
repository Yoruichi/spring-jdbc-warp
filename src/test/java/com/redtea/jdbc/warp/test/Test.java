package com.redtea.jdbc.warp.test;

import com.redtea.jdbc.warp.dao.FooDao;
import com.redtea.jdbc.warp.po.Foo;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yoruichi on 16/10/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class Test {

    @Autowired
    private FooDao fooDao;

    @Rollback
    @org.junit.Test
    public void test() {
        Foo foo = new Foo();
        foo.setName("testA");
        try {
            fooDao.insertOne(foo);
            fooDao.insertOne(foo);
            int id = fooDao.insertOneGetId(foo);
            Assert.assertEquals(3, fooDao.selectMany(foo).size());
            foo.setId(id);
            foo.setAge(27);
            foo.setName("testB");
            fooDao.insertOrUpdate(foo);
            Foo f = new Foo();
            f.in("name",new String[]{"testA","testB"});
            Assert.assertEquals(3, fooDao.selectMany(f).size());
            Foo f1 = new Foo();
            f1.gt("age", 22);
            Assert.assertEquals("testB", fooDao.select(f1).getName());
            Foo f2 = new Foo();
            f2.in("age", new Integer[]{22,27});
            Assert.assertEquals(3, fooDao.selectMany(f).size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
