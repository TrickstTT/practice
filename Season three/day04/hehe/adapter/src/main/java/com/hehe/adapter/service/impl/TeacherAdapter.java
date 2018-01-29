package com.hehe.adapter.service.impl;

import com.hehe.adapter.service.TeacherService;

public class TeacherAdapter implements MyAdapter{

    public void work(Object worker) {
        ((TeacherService)worker).teach();
    }

    public boolean isSupport(Object worker) {
        return worker instanceof TeacherService;
    }
}
