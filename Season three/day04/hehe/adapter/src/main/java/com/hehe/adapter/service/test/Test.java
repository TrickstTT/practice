package com.hehe.adapter.service.test;

import com.hehe.adapter.service.ProgramerService;
import com.hehe.adapter.service.TeacherService;
import com.hehe.adapter.service.impl.JavaProgramer;
import com.hehe.adapter.service.impl.MathTeacher;
import com.hehe.adapter.service.impl.MyAdapter;
import com.hehe.adapter.service.impl.ProgramerAdapter;
import com.hehe.adapter.service.impl.TeacherAdapter;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        TeacherService teacherService = new MathTeacher();
        ProgramerService programerService = new JavaProgramer();
        Object [] workers = new Object[]{teacherService,programerService};
        for (Object worker : workers) {
            MyAdapter myAdapter = getAdapter(worker);
            myAdapter.work(worker);
        }
    }

    private static MyAdapter getAdapter(Object worker) {
        List<MyAdapter> adapters = new ArrayList<MyAdapter>();
        //加载全部适配器
        adapters.add(new TeacherAdapter());
        adapters.add(new ProgramerAdapter());
        //匹配适合哪种适配器并返回
        for (MyAdapter adapter : adapters) {
            if(adapter.isSupport(worker)){
                return adapter;
            }
        }
        return null;
    }
}
