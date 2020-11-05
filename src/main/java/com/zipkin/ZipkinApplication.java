package com.zipkin;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import brave.Tracer;
import brave.Tracing;

@SpringBootApplication
@RestController
public class ZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinApplication.class, args);
	}
	
	@GetMapping("/zipkin/test")
	public String zipkintest()
	{
		
		return "Zipikin test ";
	}
	@Bean
	  public Tracer tracer() {
	    Tracing tracing = Tracing.newBuilder().build();
	    tracing.tracer().startScopedSpan("TestSpan");
	    zipkintest();
	    return tracing.tracer();
	  }


}
