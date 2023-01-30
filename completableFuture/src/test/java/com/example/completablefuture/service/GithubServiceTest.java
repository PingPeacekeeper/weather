package com.example.completablefuture.service;

import com.example.completablefuture.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@SpringBootTest
class GithubServiceTest {
    @Autowired
    GithubService service;

    @Test
    public void test() throws InterruptedException, ExecutionException {
        CompletableFuture<User> f1 = service.findUser("BananaAppleBanana");
        CompletableFuture<User> f2 = service.findUser("PingPeacekeeper");
        CompletableFuture<Void> future = CompletableFuture.allOf(f1, f2);

        future.join();
        System.out.println(f1.get());
        System.out.println(f2.get());

    }

}