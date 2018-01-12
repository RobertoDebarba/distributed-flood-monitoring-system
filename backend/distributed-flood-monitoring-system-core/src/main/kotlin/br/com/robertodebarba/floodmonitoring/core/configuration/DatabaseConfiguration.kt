package br.com.robertodebarba.floodmonitoring.core.configuration

import com.mongodb.Mongo
import com.mongodb.MongoClient
import com.mongodb.MongoCredential
import com.mongodb.ServerAddress
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories


@Configuration
@EnableMongoRepositories("br.com.robertodebarba.floodmonitoring.core.entity")
class DatabaseConfiguration : AbstractMongoConfiguration() {

    @Value("\${spring.data.mongodb.host}")
    private lateinit var host: String

    @Value("\${spring.data.mongodb.port}")
    private lateinit var port: String

    @Value("\${spring.data.mongodb.username}")
    private lateinit var username: String

    @Value("\${spring.data.mongodb.database}")
    private lateinit var database: String

    @Value("\${spring.data.mongodb.password}")
    private lateinit var password: String

    public override fun getDatabaseName(): String {
        return database
    }

    @Bean
    override fun mongo(): Mongo {
        return MongoClient(listOf(ServerAddress(host, port.toInt())),
                listOf(MongoCredential.createCredential(username, database, password.toCharArray())))
    }

}