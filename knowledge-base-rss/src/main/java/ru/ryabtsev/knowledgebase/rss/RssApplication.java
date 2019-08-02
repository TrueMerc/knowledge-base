package ru.ryabtsev.knowledgebase.rss;

import com.rometools.rome.feed.synd.SyndEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.integration.annotation.*;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
import org.springframework.messaging.Message;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
@Configuration
public class RssApplication {

    private static final Logger LOG = LoggerFactory.getLogger(RssApplication.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(RssApplication.class, args);
        System.in.read();
        Runtime.getRuntime().exit(SpringApplication.exit(ctx));
    }

    @Autowired
    private Environment env;

    @Value("${rss.url}")
    private String rssUrl;

    @Bean
    @InboundChannelAdapter(value = "feedChannel", poller = @Poller(maxMessagesPerPoll = "100", fixedRate = "10000"))
    public MessageSource<SyndEntry> feedAdapter() throws MalformedURLException {
        return new FeedEntryMessageSource(new URL(rssUrl), "feedAdapter");
    }

    @MessageEndpoint
    public static class Endpoint {
        @ServiceActivator(inputChannel = "feedChannel")
        public void log(Message<SyndEntry> message) {
            SyndEntry payload = message.getPayload();
            LOG.info(payload.getPublishedDate() + " - " + payload.getTitle());
        }
    }
}