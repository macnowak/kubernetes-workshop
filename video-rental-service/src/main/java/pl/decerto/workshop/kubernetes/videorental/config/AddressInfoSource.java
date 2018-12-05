package pl.decerto.workshop.kubernetes.videorental.config;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Value;
import io.micronaut.context.env.PropertySource;
import io.micronaut.management.endpoint.info.InfoSource;
import io.reactivex.Flowable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;

@Slf4j
@Singleton
class AddressInfoSource implements InfoSource {

	@Inject
	private ApplicationContext applicationContext;

	@Override
	public Publisher<PropertySource> getSource() {
		return Flowable.just(PropertySource.of("address", getAddresses()));
	}

	private Map<String, Object> getAddresses() {
		try {
			Map<String, Object> map = new HashMap<>();

			map.put("local.hostAddress", InetAddress.getLocalHost().getHostAddress());
			map.put("loopback.hostAddress", InetAddress.getLoopbackAddress().getHostAddress());
			map.put("local.hostName", InetAddress.getLocalHost().getHostName());
			map.put("loopback.hostName", InetAddress.getLoopbackAddress().getHostName());
			map.put("env",applicationContext.getEnvironment().getActiveNames());

			return map;
		} catch (UnknownHostException e) {
			log.error("Error getting address info", e);
			return Collections.emptyMap();
		}
	}
}
