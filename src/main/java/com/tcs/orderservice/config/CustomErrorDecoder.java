package com.tcs.orderservice.config;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.tcs.orderservice.exceptions.BadRequestException;
import com.tcs.orderservice.exceptions.InternalServerError;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
		case 400:
			return new BadRequestException();
		case 404:
			return new NotFoundException();
		case 500:
			return new InternalServerError();
		default:
			return new Exception("Generic error");
		}
	}

}