package com.ienliven.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class GatewayPreFilter extends AbstractGatewayFilterFactory<GatewayPreFilter.Config> {

    public GatewayPreFilter() {
        super(Config.class);
    }

    public static class Config {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            ServerHttpRequest serverHttpRequest = exchange.getRequest().mutate()
                    .header("pre-header", Math.random() * 10 + "").build();
            return chain.filter(exchange.mutate().request(serverHttpRequest).build());
        };
    }
}