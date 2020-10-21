package com.natsumes;

import com.natsumes.service.IStudentService;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        System.out.println("start");
        ServiceLoader<IStudentService> studentServices = ServiceLoader.load(IStudentService.class);
        studentServices.findFirst().orElseThrow();
    }
}
