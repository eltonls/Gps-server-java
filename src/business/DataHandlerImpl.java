package business;

import model.DataRead;

import java.util.regex.Pattern;

public class DataHandlerImpl implements DataHandler<DataRead, String> {

    @Override
    public DataRead treatData(String data) {
        Pattern pattern;
        pattern = Pattern.compile("^STT;[0-9]{8};\\d{8};[0-2][0-9]:[0-5][0-9]:[0-5][0-9];[\\+\\-]?\\d{1,3}\\.\\d{1,7};[\\+\\-]?\\d{1,3}\\.\\d{1,7};$");

        if (pattern.matcher(data).matches()) {
            DataRead d1 = new DataRead();
            d1.CreateFromString(data);
            System.out.println(d1);

            return d1;
        }

        System.out.println("String recebida não está conforme os padrões definidos");
        System.out.println("Exemplo: STT;12345678;20240501;12:30:45;+40.7128;-74.0060;");

        return null;
    }
}
