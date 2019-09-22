package com.sweeneyb.blackjack;

import com.sweeneyb.blackjack.players.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BlackjackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlackjackApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ApplicationContext ctx) {
		return args -> {
//			System.out.println(((Game)ctx.getBean("getGame")).dealer);
			((Game)ctx.getBean("getGame")).startGame();
		};
	}

	@Bean(name="dealer")
    public Player getDealer() {
		return new Dealer();
	}

	@Bean(name="players")
	public List<Player> getPlayers() {
		return List.of(new AutomatedPlayer(), new HitTooMuchPlayer(), new AutomatedPlayer(), new SlowPlayer());
	}

	@Bean
	public Game getGame() {
		return new Game();
	}

}
