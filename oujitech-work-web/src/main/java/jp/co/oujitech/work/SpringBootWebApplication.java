package jp.co.oujitech.work;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication implements CommandLineRunner {

	// LogFactory
	final static Log log = LogFactory.getLog(SpringBootWebApplication.class);



	/**
	 *main
	 */
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		log.info("Main Start");
		// TODO 自動生成されたメソッド・スタブ
		SpringApplication.run(SpringBootWebApplication.class, args);

		log.info("Main End");
	}

	/**
	 * Database Connection
	 */
	public void run(String... args) throws Exception {
		log.info("DATASOURCE = " + dataSource);
	}

}
