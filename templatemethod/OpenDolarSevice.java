package templatemethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OpenDolarSevice {
	private static final String API_URL = "https://open.er-api.com/v6/latest/USD";
	private static final int MAX_RETRY = 3;

	public static double getExchangeRate(String targetCurrency) throws IOException {
		for (int attempt = 1; attempt <= MAX_RETRY; attempt++) {
			try {
				String apiUrl = API_URL + "?symbols=" + targetCurrency;

				URL url = new URL(apiUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");

				int responseCode = connection.getResponseCode();

				if (responseCode == HttpURLConnection.HTTP_OK) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					StringBuilder response = new StringBuilder();
					String line;

					while ((line = reader.readLine()) != null) {
						response.append(line);
					}

					reader.close();

					String jsonResponse = response.toString();
					return parseExchangeRate(jsonResponse, targetCurrency);
				} else {
					if (attempt == MAX_RETRY) {
						throw new IOException(
								"Falhou ao recuperar a taxa de câmbio após " + MAX_RETRY + " tentativas!");
					}

					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		throw new IllegalStateException("Falha ao tentar consultar, tente novamente mais tarde!");
	}

	private static double parseExchangeRate(String jsonResponse, String targetCurrency) {
		String rateKeyPattern = "\"rates\"\\s*:\\s*\\{[^}]*\"" + targetCurrency + "\"\\s*:\\s*([^,}]+)";
		Pattern pattern = Pattern.compile(rateKeyPattern);
		Matcher matcher = pattern.matcher(jsonResponse);

		if (matcher.find()) {
			String usdRate = matcher.group(1);
			return Double.parseDouble(usdRate);
		} else {
			throw new IllegalArgumentException("Taxa de câmbio USD não encontrada na resposta JSON");
		}
	}
}
