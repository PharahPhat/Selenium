package config.influx.db;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class ResultSender {

	private static final InfluxDB INFLXUDB = InfluxDBFactory.connect("http://mnt-tech-sel02:8086");
	private static final String DATABASE = "interop";

	static {
		INFLXUDB.setDatabase(DATABASE);
	}

	public static void send(final Point point) {
		String OS = System.getProperty("os.name").toLowerCase();
		if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0) {
			if (System.getProperty("databaseResults").equalsIgnoreCase("Yes")) {
				if (System.getProperty("testNGgroups").equalsIgnoreCase("All")) {
					INFLXUDB.write(point);
				}

			}
		}
	}
}
