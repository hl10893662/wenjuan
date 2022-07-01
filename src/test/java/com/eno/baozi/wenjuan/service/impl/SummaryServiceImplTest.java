package com.eno.baozi.wenjuan.service.impl;

import com.eno.baozi.wenjuan.common.util.NameConvert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SummaryServiceImplTest {

    @Test
    public void bigGroupFullName2Name() {
        String name = "武夷山监狱一监区";
        System.out.println(NameConvert.bigGroupFullName2Name(name));
    }

    @Test
    public void groupFullName2Name() {
        String name = "武夷山监狱一监区一分监区";
        System.out.println(NameConvert.groupFullName2Name(name));
    }

    @Test
    public void groupFullName2NameOfHospital() {
        String name = "武夷山监狱医院";
        System.out.println(NameConvert.bigGroupFullName2Name(name));
        System.out.println(NameConvert.groupFullName2Name(name));
    }
}
