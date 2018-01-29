package com.hehe.adapter.service.impl;

import com.hehe.adapter.service.ProgramerService;

public class ProgramerAdapter implements MyAdapter{
    public void work(Object worker) {
        ((ProgramerService)worker).program();
    }

    public boolean isSupport(Object worker) {
        return worker instanceof ProgramerService;
    }
}
