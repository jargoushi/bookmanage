package com.bijian.bookmanage.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/23
 * @Content:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest {

    @Autowired
    private FileService fileService;

    @Test
    public void upload() {

        String upload = fileService.upload(new File("C:\\Users\\ruwenbo\\Desktop\\u=1208538952,1443328523&fm=26&gp=0.jpg"));

        System.out.println(upload);
    }
}