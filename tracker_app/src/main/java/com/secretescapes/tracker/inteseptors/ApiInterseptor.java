package com.secretescapes.tracker.inteseptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApiInterseptor extends HandlerInterceptorAdapter {


		@Override
		public boolean preHandle(
				HttpServletRequest request,
				HttpServletResponse response,
				Object handler) {
			return true;
		}

		@Override
		public void afterCompletion(
				HttpServletRequest request,
				HttpServletResponse response,
				Object handler,
				Exception ex) {

		}

}
