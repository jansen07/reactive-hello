package com.goyena.reactivehello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.util.logging.Logger;

@SpringBootApplication
@Slf4j
public class ReactiveHelloApplication {

	private static String[] friends = {"Ichiro", "Hiro", "Ando", "Mari"};

	public static void main(String[] args) {
		//Nothing happens until you subscribe
		//this is not asynchronous yet. map is for synchronous non-blocking and flatMap is for asynchronous non-blocking
		Flux<String> friendsFlux = Flux.range(0,3)
				.map(Community::getFriendsName);
		System.out.println("Nothing is happening yet");


		friendsFlux.subscribe();
	}
	static class Community{
		public static String getFriendsName(int index){
			log.info("retrieving %s! \n", friends[index]);
			return friends[index];
		}
	}

}
