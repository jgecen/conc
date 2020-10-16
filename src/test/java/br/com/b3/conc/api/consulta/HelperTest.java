package br.com.b3.conc.api.consulta;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class HelperTest {

	public static void initialDataset(DataSource dataSource)
			throws DatabaseUnitException, MalformedURLException, DataSetException, SQLException {
		Connection connection = dataSource.getConnection();
		DatabaseConnection dbunitConnection = new DatabaseConnection(connection, "CONC");
		FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
		builder.setColumnSensing(true);
		IDataSet dataSet = builder.build(new File("src/test/resources/dataset-full.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(dbunitConnection, dataSet);
	}

}
