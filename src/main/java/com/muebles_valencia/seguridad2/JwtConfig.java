package com.muebles_valencia.seguridad2;

public class JwtConfig {

	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----RSA BEGIN PRIVATE KEY-----"
			+ "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCuAbdjh4K1kSK6\r\n"
			+ "7kWVurKze3RmnsAWzMzQK6ZZJRoIBaWTDd6pO3MSWgKfpmAQKB6K0j+0WapIN9Zn\r\n"
			+ "SExOetlbtvPm3lABRbjKPCPDG92yfgY1dpPmKYf1Dh5I0xEMMD1xi2cfs/iYQTOk\r\n"
			+ "DRFGmDL1r9hlXhPF0kZBpqW70uLJCBVPpm7SQxBSim7BgnVv8NQBirytW8TGjisZ\r\n"
			+ "n2Mi02lRHeZgoct03COaDh84n12seYNPE3NdLIHenOUi0i7CEOl/USs8aPkIF4kf\r\n"
			+ "y0IQ2gd3EhZ2SKxaXnww8JzNuACaVp4uMpuOZ1qcYNUx1OXkHkyqi91iZ7I2B/H9\r\n"
			+ "nGaDtOuFAgMBAAECggEADzzRPWMBfDrgarQw3cLCoVr/P3lJYvW+PcCEyaupEujD\r\n"
			+ "rhP52qH9Gq9NKYPdR6zrt8Zfk8CCW96f5N186SZy4EguJZp0MRhU7UjE7PIEwPuu\r\n"
			+ "OYJPw0kBweDhoAjzpjiXONk3R5xv+Y1EI2qNh7wOQluKvJ23Z4xZYKhiPQdjmqz4\r\n"
			+ "gOrABStHnGHmPwcJ7LinZwaNLtJJzALg/qhjjbmCbA5Z8cmuw7oMi4QcgMPaLV2s\r\n"
			+ "auisPOPlZLBigBce756w6NPbjnkKL4gsNuQIcYZ6EujWXbRsKhdgYupJFHqf8Mbe\r\n"
			+ "zMEbi079LkObzItCZhZNMTv3MaD85be2tKaAR7qzwQKBgQDgCZ3lVesndDlNN7Yj\r\n"
			+ "hKOEJSagL66esbfTs88bnu77trOO2o2TU+sZZQ4pvYB2LaPcZAoaNP6mABRSSHV2\r\n"
			+ "XO6OF4rgvtm14Vlq6ulrS1DUYH8+wijcJ0QY7vKvq2yeGr5bk5z64SO96QVK84b8\r\n"
			+ "tMLf12Dtf25a6GT+HZ05e4qSEQKBgQDG1NqYNawjOsO+PwYiBZgoODHJA7MZOKBp\r\n"
			+ "Qt5/5Ls/z6RJVR32q/15Hp9W0a/sqP6zP5AZhatqRggkNMwxM9wqoG+aMEYIYNmE\r\n"
			+ "nyANCJV8AOYFwi9XpfydDje8vuxO8U5/u3bKdIAIalhevqLj0RI2YV43UhUEv6to\r\n"
			+ "urIv68vONQKBgH2rp1Bvo5rcDRCNgbPmwTptBH+yf4cxNWahZDmgK3ozAAHQAr5z\r\n"
			+ "wlraXtl3HUotS89ipnAQ7g772GpXjtw4QPCfsB1lsQXfRKM+5nRzKQIYpwfzLaxg\r\n"
			+ "skgyMRvtUt5VLhZ8dQAdrkjnHzrt4/h5BR8+13YhlyuTVKNexUTrUc2hAoGBAJao\r\n"
			+ "DgIrGQWQr2Tl6EW7K3G+Mqr3bKt9pr5bdrA9pkxRj1ApeIzCAUvXEjD8rWqLGoLD\r\n"
			+ "dPKBwELEUcLtZpMZkoeSDT4tucL7b5X35Jc7m9jb7W8Llke5c9GlRkJ0ACZI3YwX\r\n"
			+ "hYkeAS1fNxqDJHWuozglSvhr75UrjjvKyt1Ys5LJAoGAC1IoZ8VwL8LZw59vw7+i\r\n"
			+ "S/SKpITNW0Ubce8RTPPyQLo9dKCP98zcv0yBJurCSsofOcjQa+YJWX/hZS0TSAYX\r\n"
			+ "nySot2QCrn26oE+vxDC53857HKrkwA3Ekd/79lLejZyhRY2W1dBairvp+r6JxEdZ\r\n"
			+ "7M5mBZKf1KT/e7awD9XoViA=\r\n"
			+ "-----END RSA PRIVATE KEY-----";
	public static final String RSA_PUBLICA ="-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArgG3Y4eCtZEiuu5Flbqy\r\n"
			+ "s3t0Zp7AFszM0CumWSUaCAWlkw3eqTtzEloCn6ZgECgeitI/tFmqSDfWZ0hMTnrZ\r\n"
			+ "W7bz5t5QAUW4yjwjwxvdsn4GNXaT5imH9Q4eSNMRDDA9cYtnH7P4mEEzpA0RRpgy\r\n"
			+ "9a/YZV4TxdJGQaalu9LiyQgVT6Zu0kMQUopuwYJ1b/DUAYq8rVvExo4rGZ9jItNp\r\n"
			+ "UR3mYKHLdNwjmg4fOJ9drHmDTxNzXSyB3pzlItIuwhDpf1ErPGj5CBeJH8tCENoH\r\n"
			+ "dxIWdkisWl58MPCczbgAmlaeLjKbjmdanGDVMdTl5B5MqovdYmeyNgfx/Zxmg7Tr\r\n"
			+ "hQIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
