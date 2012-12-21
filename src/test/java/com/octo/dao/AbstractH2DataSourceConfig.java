package com.octo.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public abstract class AbstractH2DataSourceConfig {
	@Bean(name = "dataSource", destroyMethod = "shutdown")
	  public EmbeddedDatabase dataSource() throws Exception {
	    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	    builder.setType(EmbeddedDatabaseType.H2);
	    for (String script : getSqlScripts()) {
	      builder.addScript(script);
	    }
	    EmbeddedDatabase db = builder.build();
	    return db;
	  }

	  protected abstract List<String> getSqlScripts();
}
