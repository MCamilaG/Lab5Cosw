package eci.cosw.data;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@Configuration
public class AppConfiguration {

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {

        // Set credentials
        MongoCredential credential = MongoCredential.createCredential("MCamilaG", "lab5cosw", "camiaguilar050897".toCharArray());
        ServerAddress serverAddress = new ServerAddress("ds115543.mlab.com", 15543);

        // Mongo Client
        MongoClient mongoClient = new MongoClient(serverAddress, credential, new MongoClientOptions.Builder().build());


        return new SimpleMongoDbFactory(mongoClient, "lab5cosw");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }
}
